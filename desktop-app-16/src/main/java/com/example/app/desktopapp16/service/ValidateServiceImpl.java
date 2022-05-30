package com.example.app.desktopapp16.service;

import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateServiceImpl implements ValidateService {

    @Override
    public boolean validate(TextField surName, TextField name, TextField patronymic) {

        Pattern pattern = Pattern.compile("^[А-Яа-я]{3,}$");
        Matcher matcher1 = pattern.matcher(surName.getText());
        Matcher matcher2 = pattern.matcher(name.getText());
        Matcher matcher3 = pattern.matcher(patronymic.getText());
        if (patronymic.getText().isEmpty()) {
            if (matcher1.matches() && matcher2.matches()) {
                return true;
            } else {
                return false;
            }
        } else {
            if (matcher1.matches() && matcher2.matches() && matcher3.matches()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
