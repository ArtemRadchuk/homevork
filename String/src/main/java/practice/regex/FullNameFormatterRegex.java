package practice.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullNameFormatterRegex {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(input);
            String[] fio = input.split(" ");
            if (matcher.find() == false && fio.length > 2 && fio.length < 4) {
                System.out.println("Фамилия: " + fio[0] + "\nИмя: " + fio[1]    + "\nОтчество: " + fio[2]);
            }else{
                System.out.println("Введенная строка не является ФИО");
            }


            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
        }
    }

}