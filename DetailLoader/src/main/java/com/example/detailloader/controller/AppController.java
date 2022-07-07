package com.example.detailloader.controller;

import com.example.detailloader.AppApplication;
import com.example.model.XlsxModel;
import com.example.repository.ExcelReader;
import com.example.repository.ExcelWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.detailloader.AppApplication.stage;

public class AppController {
    private static List<XlsxModel> data;
    private static String newPath;
    private static File file;
    private static File dir;


    @FXML
    protected void locateFile(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        file = chooser.showOpenDialog(new Stage());
        readFile(file);
    }

    @FXML
    protected void locateDirect(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Open File");
        dir = chooser.showDialog(new Stage());
    }

    @FXML
    protected void close() {
        stage.close();
    }


    private void readFile(File file) throws IOException {
        ExcelReader reader = new ExcelReader();
        newPath = file.getPath();
        data = reader.reade(newPath);
        System.err.println(reader.isFindErrors());
        if (!reader.isFindErrors()) {
            FXMLLoader fxmlLoader = new FXMLLoader(AppApplication.class.getResource("copy.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Результаты проверки");
            stage.setScene(scene);
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(AppApplication.class.getResource("noCopy.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Результаты проверки");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    protected void writeFile() throws IOException {
        ExcelWriter writer = new ExcelWriter();
        String newPath = dir.getPath() + "/" + file.getName();
        newPath = newPath.substring(0, AppController.newPath.length() - 5) + "_copy.xlsx";
        writer.write(data, newPath);
        close();
    }
}
