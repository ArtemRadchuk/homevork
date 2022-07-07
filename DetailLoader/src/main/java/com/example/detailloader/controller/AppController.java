package com.example.detailloader.controller;

import com.example.detailloader.AppApplication;
import com.example.model.XlsxModel;
import com.example.repository.ExcelReader;
import com.example.repository.ExcelWriter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppController {
    @FXML
    private TextField path;
    private static  List<XlsxModel> data;
    private static String newPath;


    @FXML
    protected void readFile() throws IOException {
        newPath = path.getText();
        ExcelReader reader = new ExcelReader();
        Pattern pattern = Pattern.compile(".xlsx");
        Matcher matcher = pattern.matcher(path.getText());
        if (matcher.find()) {
            data = reader.reade(path.getText());
        }else{
            data = reader.reade(path.getText() + ".xlsx");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(AppApplication.class.getResource("copy.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        AppApplication.stage.setTitle("Проверка Excel файла");
        AppApplication.stage.setScene(scene);
        AppApplication.stage.show();
    }

    @FXML
    protected void writeFile(){
        System.out.println("---------------------------------------------" + newPath);
        //C:\Users\User\IdeaProjects\homework\DetailLoader\src\main\resources\KTI
        ExcelWriter writer = new ExcelWriter();
        Pattern pattern = Pattern.compile(".xlsx");
        Matcher matcher = pattern.matcher(newPath);
        String newPath = null;
        try {
        if (matcher.find()) {
            newPath = AppController.newPath.substring(0, AppController.newPath.length()-5) + "_copy.xlsx";
        }else{
            newPath = AppController.newPath + "_copy.xlsx";
        }
        writer.write(data, newPath);
        }catch (NullPointerException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
