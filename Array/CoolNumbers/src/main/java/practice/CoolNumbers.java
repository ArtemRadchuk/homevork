package practice;

import java.util.*;

public class CoolNumbers {
    public static ArrayList<String> CoolNumber = new ArrayList<>();

    public static List<String> generateCoolNumbers() {
        int N = 0;
        int NMax = 9;
        int R = 1;
        int RMax = 199;
        String X = "";
        String Y = "";
        String Z = "";
        String a = "АВЕКМНОРСТУХ";
        String[] allLetter = new String[]{};
        allLetter = a.split("");
        for (R = 1; R <= RMax; R++) {
            for (N = 0; N <= NMax; N++) {
                for (int num = 0; num < allLetter.length; num++) {
                    for (int num1 = 0; num1 < allLetter.length; num1++) {
                        for (int num2 = 0; num2 < allLetter.length; num2++) {
                            if (R < 10) {
                                CoolNumber.add(allLetter[num] + N + N + N + allLetter[num1] + allLetter[num2] + 0 + R);
                            } else {
                                CoolNumber.add(allLetter[num] + N + N + N + allLetter[num1] + allLetter[num2] + R);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(CoolNumber);
        System.out.println(CoolNumber.size());
        return CoolNumber;
    }

    public static boolean bruteForceSearchInList(String number) {
        long time = System.currentTimeMillis();
        Collections.sort(CoolNumber);
        String[] array = CoolNumber.toArray(new String[0]);
        boolean out = false;
        for (int indexOfArray = 0; indexOfArray < array.length; indexOfArray++) {
            if (number.equals(array[indexOfArray])) {
                out = true;
            }
        }
        if (out == true) {
            System.out.println("Поиск перебором: Номер найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
        } else {
            System.out.println("Поиск перебором: Номер не найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
        }
        return out;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long time = System.currentTimeMillis();
        Collections.sort(CoolNumber);
        sortedList.addAll(CoolNumber);
        String[] array = CoolNumber.toArray(new String[0]);
        int low = 0;
        int high = array.length - 1;
        int mid;
        boolean out = false;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid].compareTo(number) < 0) {
                low = mid + 1;
            } else if (array[mid].compareTo(number) > 0) {
                high = mid - 1;
            } else {
                out = true;
            }
        }
        if (out == true) {
            System.out.println("Бинарный поиск: Номер найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
        } else {
            System.out.println("Бинарный поиск: Номер не найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
        }
        return out;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long time = System.currentTimeMillis();
        hashSet.addAll(CoolNumber);
        if (hashSet.contains(number)) {
            System.out.println("Поиск в HashSet: Номер найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
            return true;
        } else {
            System.out.println("Поиск в HashSet: Номер не найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
            return false;
        }

    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long time = System.currentTimeMillis();
        treeSet.addAll(CoolNumber);
        if (treeSet.contains(number)) {
            System.out.println("Поиск в TreeSet: Номер найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
            return true;
        } else {
            System.out.println("Поиск в TreeSet: Номер не найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
            return false;
        }
    }

}
