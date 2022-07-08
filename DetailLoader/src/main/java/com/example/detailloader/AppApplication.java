package com.example.detailloader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppApplication extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("-----");
        stage = this.stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(AppApplication.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Проверка Excel файла");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}