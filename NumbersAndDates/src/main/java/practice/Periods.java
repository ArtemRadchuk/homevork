package practice;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Periods {

    // реализуйте вывод разницы между датами, используя класс Period
    public static String getPeriodFromBirthday(LocalDate firstDate, LocalDate secondDate) {
        Period period = Period.between(firstDate,secondDate);
        String periodOut ="years:" + period.getYears() + ", months:" + period.getMonths() + ", days:" + period.getDays() ;
        return periodOut;
    }

}
