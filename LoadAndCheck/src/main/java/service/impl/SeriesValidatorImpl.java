package service.impl;

import service.SeriesValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesValidatorImpl implements SeriesValidator {

    @Override
    public boolean validateLatin(String series) {
        Pattern pattern = Pattern.compile("^[A-Z]+$");
        Matcher matcher = pattern.matcher(series);
        return matcher.matches();
    }

    @Override
    public boolean validateCyrillic(String series) {
        Pattern pattern = Pattern.compile("^[А-Я]+$");
        Matcher matcher = pattern.matcher(series);
        return matcher.matches();
    }

    @Override
    public String seriesComment(String series) {
        if (!validateCyrillic(series) && !validateLatin(series)) {
            System.err.println("Ошибка");
            return "Ошибка в серии. Строка не заполнена или замечено смешение Кириллицы с Латиницой";
        } else {
            return null;
        }
    }
}
