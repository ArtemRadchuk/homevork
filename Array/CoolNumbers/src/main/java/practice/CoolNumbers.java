package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoolNumbers {
    public static ArrayList<String> CoolNumber = new ArrayList<>();

    public static List<String> generateCoolNumbers() {
        int N = 1;
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
            for (N = 1; N <= NMax; N++) {
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

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        Collections.sort(CoolNumber);
        String[] array = CoolNumber.toArray(new String[0]);
        boolean out = false;
        for (int indexOfArray = 0; indexOfArray < array.length; indexOfArray++) {
            if (number.equals(array[indexOfArray])) {
                out = true;
            }
        }
        return out;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
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
        return out;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        hashSet.addAll(CoolNumber);
        if (hashSet.contains(number)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        treeSet.addAll(CoolNumber);
        if (treeSet.contains(number)) {
            return true;
        } else {
            return false;
        }
    }

}
