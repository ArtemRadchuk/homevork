package practice;
import javax.imageio.stream.ImageOutputStream;
import java.time.LocalDate;


public class Birthdays {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        int myYear = 0;
        System.out.println(myYear + " - " + birthday + " - " + birthday.getDayOfWeek() );
        for (; birthday.isBefore(today) == true; ) {
            myYear++;
            birthday = birthday.plusYears(1);
            System.out.println(myYear + " - " + birthday + " - " + birthday.getDayOfWeek() );
        }
         return "";
    }
}

//TODO реализуйте метод для построения строки в следующем виде
//0 - 31.12.1990 - Mon
//1 - 31.12.1991 - Tue