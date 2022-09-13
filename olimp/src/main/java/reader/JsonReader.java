package reader;

import model.JSONData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonReader {
    public String[][] result;
    public int step;

    public void readeJson(String path) throws IOException, ParseException {
        File file = new File(path);
        Object object = new JSONParser().parse(new FileReader(file));
        JSONArray jsonArray = (JSONArray) object;
        printMatrix(matrix(jsonArray));
        firstSymbol(jsonArray);
    }

    public int[][] matrix(JSONArray jsonArray) {
        boolean run = true;
        int[][] mat = new int[jsonArray.size()][jsonArray.size()];
        while (run) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                if (jsonObject.get("reference_id") != null) {
                    String s = jsonObject.get("reference_id").toString();
                    s = s.replaceAll("\\[", "");
                    s = s.replaceAll("\\]", "");
                    String[] arrayString = s.split(",");
                    for (int j = 0; j < arrayString.length; j++) {
                        int num = Integer.parseInt(arrayString[j]);

                        mat[i][num - 1] = 1;
                        mat[num - 1][i] = 1;
                    }
                }
            }
            run = false;
        }
        return mat;
    }

    public void printMatrix(int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                stringBuilder.append(matrix[i][j] + "  ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        System.out.println("\n\n\n");
    }

    public String[][] rotate(String[][] oldMatrix) {
        String[][] newMatrix = new String[oldMatrix.length][oldMatrix.length];
        for (int i = 0; i < oldMatrix.length; i++) {
            for (int j = 0; j < oldMatrix.length; j++) {
                newMatrix[i][j] = oldMatrix[j][i];
            }
        }
        return newMatrix;
    }


    public void firstSymbol(JSONArray jsonArray) {
        StringBuilder builder = new StringBuilder();
        int size = 0;
        step = 1;
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if (Integer.parseInt(jsonObject.get("symbol_count").toString()) > size) {
                size = Integer.parseInt(jsonObject.get("symbol_count").toString());
            }
        }
        result = new String[size * 2][size * 2];
        for (int i = 0; i < size * 2; i++) {
            for (int j = 0; j < size * 2; j++) {
                result[i][j] = "";
            }
        }
        HashMap<Integer, String[]> allDetail = new HashMap<>();
        HashMap<Integer, JSONData> detailData = new HashMap<>();
        //забираем нужные данные
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONData data = new JSONData();
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            //получаем id
            int id = Integer.parseInt(jsonObject.get("id").toString());
            //получаем символ
            String symbol = jsonObject.get("symbol").toString();
            data.setSymbol(symbol);
            //Получаем размер детали
            int count = Integer.parseInt(jsonObject.get("symbol_count").toString());
            data.setCount(count);
            if (jsonObject.get("reference_id") != null) {
                String ref = jsonObject.get("reference_id").toString().trim();
                ref = ref.replaceAll("\\[", "");
                ref = ref.replaceAll("\\]", "");
                String[] referenceString = ref.split(",");
                int[] reference = new int[referenceString.length];
                for (int j = 0; j < referenceString.length; j++) {
                    reference[j] = Integer.parseInt(referenceString[j]);
                }
                data.setReference(reference);
            }
            detailData.put(id, data);
            String[] model = new String[count];
            //получаем деталь
            for (int j = 0; j < count; j++) {
                model[j] = symbol;
            }
            allDetail.put(id, model);
        }
        //Ищем деталь с большим количеством связей
        int manyReferenceDetailId = 0;
        int maxReferenceCount = 0;
        int[][] matrix = matrix(jsonArray);
        for (int i = 0; i < matrix.length; i++) {
            int referenceCount = 0;
            for (int j = 0; j < matrix.length; j++) {
                referenceCount = referenceCount + matrix[i][j];
            }
            if (referenceCount > maxReferenceCount) {
                maxReferenceCount = referenceCount;
                manyReferenceDetailId = i + 1;
            }
        }
        //строим основную деталь
        JSONData firstDetail = detailData.get(manyReferenceDetailId);
        for (int i = 0; i < firstDetail.getCount(); i++) {
            result[i][0] = firstDetail.getSymbol();
        }
        //Получаем связи основной детали(первый уровень)
        List<Integer> firstReferenceList = new ArrayList<>();
        if (firstDetail.getReference() != null) {
            for (int i = 0; i < firstDetail.getReference().length; i++) {
                firstReferenceList.add(firstDetail.getReference()[i]);
            }
        }
        var keySet = detailData.keySet();
        for (var key : keySet) {
            JSONData data = detailData.get(key);
            if (data.getReference() != null) {
                int[] ref = data.getReference();
                for (int i = 0; i < ref.length; i++) {
                    if (ref[i] == manyReferenceDetailId) firstReferenceList.add(key);
                }
            }
        }

        //Связи 2 уровня
        List<String> secondReferenceList = new ArrayList<>();
        for (int id : firstReferenceList) {
            for (var key : keySet) {
                JSONData data = detailData.get(key);
                if (data.getReference() != null) {
                    int[] ref = data.getReference();
                    for (int i = 0; i < ref.length; i++) {
                        if (ref[i] == id) {
                            secondReferenceList.add(id + "," + key);
                        }
                    }
                }
            }
        }

        //Связи 3 уровня
        List<String> thirdReferenceList = new ArrayList<>();
        for (String id : secondReferenceList) {
            var refStr = id.split(",");
            int refId = Integer.parseInt(refStr[refStr.length - 1]);
            for (var key : keySet) {
                JSONData data = detailData.get(key);
                if (data.getReference() != null) {
                    int[] ref = data.getReference();
                    for (int i = 0; i < ref.length; i++) {
                        if (ref[i] == refId) thirdReferenceList.add(refId + "," + key);
                    }
                }
            }
        }

        List<String> groupDetail = new ArrayList<>();
        //проверка совпадения связей на уровнях 1 и 2
        for (int firstNum : firstReferenceList) {
            for (String secondNum : secondReferenceList) {
                var refStr = secondNum.split(",");
                int refId = Integer.parseInt(refStr[refStr.length - 1]);
                if (firstNum == refId) {
                    groupDetail.add(secondNum);
                }
            }
        }

        //проверка совпадения связей на уровнях 2 и 3
        for (String secondNum : secondReferenceList) {
            var refStr = secondNum.split(",");
            int secondNumId = Integer.parseInt(refStr[refStr.length - 1]);
            for (String thirdNum : thirdReferenceList) {
                var refStr2 = thirdNum.split(",");
                int thirdNumId = Integer.parseInt(refStr2[refStr2.length - 1]);
                if (secondNumId == thirdNumId && !secondNum.trim().equals(thirdNum.trim())) {
                    groupDetail.add(secondNum + "," + refStr2[0]);
                }
            }
        }

        List<String> deleteList = new ArrayList<>();

        for (var a : groupDetail) {
            var reference1 = a.trim().split(",");
            for (var b : groupDetail) {
                Pattern pattern = Pattern.compile(reference1[0]);
                Matcher matcher = pattern.matcher(b);
                Pattern pattern2 = Pattern.compile(reference1[1]);
                Matcher matcher2 = pattern2.matcher(b);
                var srt = a.trim().split(",");
                if (matcher.find() && matcher2.find() && !a.equals(b) && srt.length < 3) {
                    deleteList.add(a);
                }
            }
        }
        for (var g : deleteList) {
            groupDetail.remove(g);
        }
        List<String> newGroupDetail = new ArrayList<>();
        deleteList = new ArrayList<>();
        for (var s : groupDetail) {
            var a = s.trim().split(",");
            for (var d : groupDetail) {
                var b = d.trim().split(",");
                if (a[0].trim().equals(b[0].trim()) && !s.equals(d)) {
                    deleteList.add(s);
                    deleteList.add(d);
                    String newResult = s;
                    for (int i = 1; i < b.length; i++) {
                        newResult = newResult + "," + b[i];
                    }
                    newGroupDetail.add(newResult);
                    break;
                }
            }
        }
        String detail = null;
        for (String detailGroup : newGroupDetail) {
            var first = detailGroup.trim().split(",")[0];
            for (String det : newGroupDetail) {
                var second = det.trim().split(",")[0];
                if (detail == null && first.equals(second) && !detailGroup.trim().equals(det.trim())) detail = det;
            }
        }
        newGroupDetail.remove(detail);
        for (var str : newGroupDetail) {
            groupDetail.add(str);
        }
        for (var str : deleteList) {
            groupDetail.remove(str);
        }
        deleteList = new ArrayList<>();
        for (var str : deleteList) {
            groupDetail.remove(str);
        }
        for (var g : groupDetail) {
        }

        //проверка совпадения связей на уровнях 1 и 3
        for (int firstNum : firstReferenceList) {
            for (String thirdNum : thirdReferenceList) {
                var refStr2 = thirdNum.split(",");
                int thirdNumId = Integer.parseInt(refStr2[refStr2.length - 1]);
                if (firstNum == thirdNumId) {
                }
            }
        }


        int detailNum = 1;
        //создаем матрицу с объединенными деталями
        for (var group : groupDetail) {
            StringBuilder stringBuilder = new StringBuilder();
            var splittedGroup = group.trim().split(",");
            int[] idGroup = new int[splittedGroup.length];
            for (int i = 0; i < splittedGroup.length; i++) {
                idGroup[i] = Integer.parseInt(splittedGroup[i]);
            }
            int detailSize = 0;
            //находим самую большую деталь
            for (int i = 0; i < idGroup.length; i++) {
                int id = idGroup[i];
                if (i == 0) {

                    detailSize = detailData.get(id).getCount();
                }
                if (detailData.get(id).getCount() > detailSize) detailSize = detailData.get(id).getCount();
            }
            detailSize = detailSize + 3;
            //создаем матрицу
            String[][] string = new String[detailSize][detailSize];
            //заполняем матрицу
            for (int i = 0; i < detailSize; i++) {
                for (int j = 0; j < detailSize; j++) {
                    string[i][j] = "";
                }
            }
            boolean first = true;
            //добавляем каждую деталь в матрицу
            if (splittedGroup.length == 2) {
                for (int i = 0; i < splittedGroup.length; i++) {
                    //id детали
                    int id = Integer.parseInt(splittedGroup[i].trim());
                    //Символ детали
                    String symbol = detailData.get(id).getSymbol();
                    for (int j = 0; j < allDetail.get(id).length; j++) {
                        if (first) {
                            string[detailSize / 2][j] = symbol;
                        } else {
                            string[(detailSize / 2) + 1][j] = symbol;
                        }
                    }
                    first = false;
                }
            } else if (idGroup.length == 3) {
                int detailNumber = 1;
                for (int i = 0; i < idGroup.length; i++) {
                    //id детали
                    int id = idGroup[i];
                    //Символ детали
                    String symbol = detailData.get(id).getSymbol();
                    //одна деталь
                    for (int j = 0; j < allDetail.get(id).length; j++) {
                        if (detailNumber == 1) {
                            string[detailSize / 2][j] = symbol;
                        } else if (detailNumber == 2) {
                            int a = detailSize / 2 + 1;
                            string[a][j] = symbol;
                        } else if (detailNumber == 3) {
                            int a = (detailSize / 2) + 1;
                            string[a][j + 1] = symbol;
                        }
                    }
                    detailNumber = detailNumber + 1;
                }
            } else {
                int detailNumber = 1;
                int a = detailSize / 2 + 1;
                for (int i = 0; i < idGroup.length; i++) {
                    //id детали
                    int id = idGroup[i];
                    //Символ детали
                    String symbol = detailData.get(id).getSymbol();
                    if (detailNumber == 4) {
                        detailNumber = 2;
                        a = a - 2;
                    }
                    //одна деталь
                    for (int j = 0; j < allDetail.get(id).length; j++) {
                        if (detailNumber == 1) {
                            string[detailSize / 2][j] = symbol;
                        } else if (detailNumber == 2) {
                            string[a][j + 1] = symbol;
                        } else if (detailNumber == 3) {
                            string[a][j] = symbol;
                        }
                    }
                    detailNumber = detailNumber + 1;
                }
            }
            //деталь готова

            //печать детали
            for (int i = 0; i < string.length; i++) {
                for (int j = 0; j < string.length; j++) {
                    stringBuilder.append(string[i][j] + " - ");
                }
                stringBuilder.append("\n");
            }
            // добавление элементов к основному

            for (int i = 0; i < string.length; i++) {
                for (int j = 0; j < string.length; j++) {
                    if (!string[i][j].trim().equals("")) {
                        result[step][j + 1] = string[i][j];
                    }
                }
                if (!string[i][0].trim().equals("")) step++;
            }

           /* //добавление детали к основному рисунку
            for (int i = 0; i < string.length; i++) {
                for (int j = 0; j < string.length; j++) {
                    if (!string[j][i].equals("")) {
                        result[j + 1][step] = string[j][i];
                    }
                }
                if (!string[i][0].trim().equals("")) {
                    step++;
                }
                *//*step++;*//*
            }*/
            step++;
        }

        //Заносим данные в билдер
        for (int i = 0; i < size * 2; i++) {
            for (int j = 0; j < size * 2; j++) {
                builder.append(result[i][j] + "  ");
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}


