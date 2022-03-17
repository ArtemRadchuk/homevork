package practice;

import javax.imageio.stream.ImageOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.zip.DataFormatException;


public class Birthdays {

    public static void main(String[] args) {

        int day = 17;
        int month = 3;
        int year = 2021;
        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        int myYear = -1;
        StringBuilder result = new StringBuilder();
        for (; birthday.isBefore(today) || birthday.isEqual(today) == true; ) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd.MM.yyyy - E", Locale.ENGLISH);
            String formattedString = birthday.format(formatter);
            myYear++;
            birthday = birthday.plusYears(1);
            result.append(myYear + " - " + formattedString + "\n");
           // System.out.println(myYear + " - " + formattedString);
        }
        return result.toString();
    }
}

//TODO реализуйте метод для построения строки в следующем виде
//0 - 31.12.1990 - Mon
//1 - 31.12.1991 - Tue