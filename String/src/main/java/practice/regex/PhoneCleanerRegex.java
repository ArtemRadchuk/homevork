package practice.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneCleanerRegex {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }
            Pattern pattern = Pattern.compile("[0-9]{11}");
            String number;
            number = input.replaceAll("[+()-]", "");
            number = number.replace(" ", "");
            Matcher matcher = pattern.matcher(number);
            if (number.length() == 11 && number.indexOf("8") == 0 || number.indexOf("7") == 0) {
                if (number.indexOf("8") == 0) {
                    number = number.replaceFirst("8", "7");

                    System.out.println(number);
                } else {

                    System.out.println(number);
                }
            } else if (number.length() == 10){

                System.out.println("7" + number);}
            else{
                System.out.println("Неверный формат номера");
            }


            //88005553535
            //+78005553535
            // 8(800)555-35-35

            //TODO:напишите ваш код тут, результат вывести в консоль.
        }
    }

}
