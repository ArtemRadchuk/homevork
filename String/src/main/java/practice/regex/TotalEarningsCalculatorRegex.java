package practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class TotalEarningsCalculatorRegex {

    public static void main(String[] args) {

    }

    public static int calculateSalarySum(String text) {
        //TODO: реализуйте метод
        String[] substring = text.split(" ");
        Pattern pattern = Pattern.compile("[0-9]");
        int max = substring.length;
        int earning = 0;
        for (int numberOfString = 0; numberOfString < max; numberOfString++) {
            Matcher mat = pattern.matcher(substring[numberOfString]);
            if (mat.find() == true) {
                earning = earning + Integer.parseInt(substring[numberOfString]);
            }
        }
        return earning;
    }

}