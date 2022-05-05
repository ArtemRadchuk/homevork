package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    private static List<String> emailList = new ArrayList<>();

    public void add(String email) {
        email = email.toLowerCase();
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.matches()) {
            emailList.add(email);
            System.out.println("Почта добавлена");
        } else {
            System.out.println("Невалидный email");
        }
    }

    public void getEmailList() {
        for (String mail : emailList) {
            System.out.println(mail);
        }
    }

    public List<String> getSortedEmails() {
        emailList = emailList.stream().sorted().toList();
        System.out.println("Почты отсортированы");
        return emailList;
    }

}
