package com.example.app.desktopapp16;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppApplication extends Application {
    public static Stage stage;
    public static Parent root;

    public AppApplication() throws IOException {
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Введите ФИО");
        stage.setHeight(360);
        stage.setWidth(300);
        root = FXMLLoader.load(getClass().getResource("view.fxml"));
        stage.setScene(new Scene(root));
        this.stage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}