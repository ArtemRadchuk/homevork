package practice;

import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoolNumbers coolNumbers = new CoolNumbers();
        coolNumbers.generateCoolNumbers();
        while (true) {
            String number = scanner.nextLine();
            if (number.equals("0")) {
                break;
            }
            coolNumbers.bruteForceSearchInList(number);
            coolNumbers.binarySearchInList((coolNumbers.generateCoolNumbers()), number);
            TreeSet<String> tree = new TreeSet<>();
            tree.addAll(CoolNumbers.generateCoolNumbers());
            CoolNumbers.searchInTreeSet(tree, number);
            HashSet<String> hash = new HashSet<>();
            hash.addAll(CoolNumbers.generateCoolNumbers());
            CoolNumbers.searchInHashSet(hash, number);

        }
    }
}
