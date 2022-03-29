package practice;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        CoolNumbers a = new CoolNumbers();
        a.generateCoolNumbers();
        System.out.println(a);
    }
}
