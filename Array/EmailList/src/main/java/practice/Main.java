package practice;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO: write code here
            EmailList emailList = new EmailList();
            String command = "";
            if (input.toUpperCase(Locale.ROOT).indexOf("L") != 0 && input.toUpperCase(Locale.ROOT).indexOf("S") != 0) {
                command = input.substring(0, input.indexOf(" ")).toUpperCase(Locale.ROOT);
            } else {
                command = input.substring(0, input.length());
            }
            switch (command) {
                case "ADD":
                    String mail = input.substring(input.indexOf(" "), input.length()).trim();
                    emailList.add(mail);
                    break;
                case "SORT":
                    emailList.getSortedEmails();
                    break;
                case "LIST":
                    emailList.getEmailList();
            }
        }
    }
}
