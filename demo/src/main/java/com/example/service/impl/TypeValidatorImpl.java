package com.example.service.impl;



import com.example.service.TypeValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeValidatorImpl implements TypeValidator {

    @Override
    public boolean validateType(String type) {
        Pattern pattern = Pattern.compile("^[A-Zxх.\\s,\\d-]+$");
        Matcher matcher = pattern.matcher(type);
        return matcher.matches();
    }

    @Override
    public String seriesComment(String series) {
        if (!validateType(series) ) {
            System.err.println("Хз ошибка и все");
            return "Ошибка в строке \"Тип\". Строка не заполнена или замечено смешение Кириллицы с Латиницой";
        } else {
            return null;
        }
}
}
