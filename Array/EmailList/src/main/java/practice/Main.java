package practice;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            EmailList emailList = new EmailList();
            String command = "";
            if (input.toUpperCase(Locale.ROOT).indexOf("L") == 0 || input.toUpperCase(Locale.ROOT).indexOf("S") == 0) {
                command = input.toUpperCase(Locale.ROOT).trim();
            } else {
                command = input.substring(0, input.indexOf(" ")).toUpperCase(Locale.ROOT);
            }
            switch (command) {
                case "ADD":
                    String mail = input.substring(input.indexOf(" "));
                    emailList.add(mail.trim());
                    break;
                case "SORT":
                    emailList.getSortedEmails();
                    break;
                case "LIST":
                    emailList.getEmailList();
                    break;
                default:
                    System.out.println("Команда не найдена");
            }
        }
    }
}
