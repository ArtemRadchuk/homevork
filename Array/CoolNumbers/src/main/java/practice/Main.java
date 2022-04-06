package practice;

import org.checkerframework.checker.units.qual.C;

import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
      String number = "А777ВЕ168";
        CoolNumbers coolNumbers = new CoolNumbers();
        coolNumbers.generateCoolNumbers();
        coolNumbers.bruteForceSearchInList(number);
        coolNumbers.binarySearchInList((coolNumbers.generateCoolNumbers()), number);
        TreeSet<String> tree = new TreeSet<>();
        tree.addAll(CoolNumbers.generateCoolNumbers());
        CoolNumbers.searchInTreeSet(tree, number);
        HashSet<String> hash = new HashSet<>();
        hash.addAll(CoolNumbers.generateCoolNumbers());
        CoolNumbers.searchInHashSet(hash,number);

    }
}
