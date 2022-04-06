package practice;

import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //System.out.println("Введите номер, имя или команду: ");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(input);
            if (input.equals("LIST")) {
                myPhoneBook.getAllContacts();
            }
            if (matcher.find() && input.equals("LIST") == false) {
                System.out.println("Введите имя");
                String name = scanner.nextLine();
                myPhoneBook.addContact(input, name);
                System.out.println("Контакт сохранен!");
            } else if (matcher.find() == false && input.equals("LIST") == false) {
                System.out.println("Введите номер");
                String phone = scanner.nextLine();
                myPhoneBook.addContact(phone, input);
                System.out.println("Контакт сохранен!");
            }
        }
    }
}
