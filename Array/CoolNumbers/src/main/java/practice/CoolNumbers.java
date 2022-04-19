package practice;

import java.util.*;

public class CoolNumbers {
    private static ArrayList<String> coolNumber = new ArrayList<>();

    public static List<String> generateCoolNumbers() {
        int NMax = 9;
        int RMax = 199;
        final String possibleLetters = "АВЕКМНОРСТУХ";
        final String[] allLetter = possibleLetters.split("");
        for (int R = 1; R <= RMax; R++) {
            for (int N = 0; N <= NMax; N++) {
                for (int num = 0; num < allLetter.length; num++) {
                    for (int num1 = 0; num1 < allLetter.length; num1++) {
                        for (int num2 = 0; num2 < allLetter.length; num2++) {
                            if (R < 10) {
                                coolNumber.add(allLetter[num] + N + N + N + allLetter[num1] + allLetter[num2] + 0 + R);
                            } else {
                                coolNumber.add(allLetter[num] + N + N + N + allLetter[num1] + allLetter[num2] + R);
                            }
                        }
                    }
                }
            }
        }

        return coolNumber;
    }

    public static boolean bruteForceSearchInList(String number) {
        long time = System.currentTimeMillis();
        boolean isFind = false;
        for (String s : CoolNumbers.generateCoolNumbers()) {
            if (s.equals(number)) {
                isFind = true;
                break;
            }
        }
        if (isFind) {
            System.out.println("Поиск перебором: Номер найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
        } else {
            System.out.println("Поиск перебором: Номер не найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
        }
        return isFind;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long time = System.currentTimeMillis();
        Collections.sort(sortedList);
        boolean out = false;
        if (Collections.binarySearch(sortedList, number) >= 0) {
            out = true;
            System.out.println("Бинарный поиск: Номер найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
        } else {
            System.out.println("Бинарный поиск: Номер не найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
        }
        return out;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long time = System.currentTimeMillis();
        hashSet.addAll(coolNumber);
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
        treeSet.addAll(coolNumber);
        if (treeSet.contains(number)) {
            System.out.println("Поиск в TreeSet: Номер найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
            return true;
        } else {
            System.out.println("Поиск в TreeSet: Номер не найден. Поиск занял: " + (System.currentTimeMillis() - time) + "нс");
            return false;
        }
    }

}
