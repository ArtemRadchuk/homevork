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
        final Pattern pattern = Pattern.compile("[0-9]");
        while (true) {
            //System.out.println("Введите номер, имя или команду: ");
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (input.equals("0")) {
                break;
            }
            if (input.equals("LIST")) {
                myPhoneBook.getAllContacts();
            }
            if (matcher.find()) {
                System.out.println("Введите имя");
                String name = scanner.nextLine();
                myPhoneBook.addContact(input, name);
            } else if (!matcher.find()) {
                System.out.println("Введите номер");
                String phone = scanner.nextLine();
                myPhoneBook.addContact(phone, input);
            }
        }
    }
}
