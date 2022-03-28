package practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        PhoneBook a = new PhoneBook();
        a.addContact("89297057389", "Азаглаз");
        a.addContact("89271678989", "Арараз");
        a.addContact("89297057389" , "Азарн");
        System.out.println("----");
        System.out.println(a.getContactByPhone("89297057389"));
       // System.out.println(a.getAllContacts());
    }
}
