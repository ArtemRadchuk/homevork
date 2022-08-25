package reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public void readeJson(String path) throws IOException, ParseException {
        File file = new File(path);
        Object object = new JSONParser().parse(new FileReader(file));
        JSONArray jsonArray = (JSONArray) object;
        StringBuilder builder = new StringBuilder();
        boolean run = true;
        while (run) {
            int[][] mat = new int[5][5];
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                int[] str = new int[5];
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
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    builder.append(mat[i][j] + " ");
                }
                builder.append("\n");
            }
            System.out.println(builder);
            run = false;
        }
    }
}

