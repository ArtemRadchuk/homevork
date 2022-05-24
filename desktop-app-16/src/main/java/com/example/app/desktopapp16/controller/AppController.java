package com.example.app.desktopapp16.controller;


import com.example.app.desktopapp16.AppApplication;
import com.example.app.desktopapp16.service.ValidateServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField surName;
    @FXML
    private TextField name;
    @FXML
    private TextField patronymic;

    @FXML
    protected void onButtonClick() throws Exception {
        if (new ValidateServiceImpl().validate(surName, name , patronymic)) {
            switchScene();
        } else {
            Stage stage = new Stage();
            stage.setTitle("Ошибка!");
            Label error = new Label("Введите Фамилию и Имя");
            VBox box = new VBox();
            stage.setWidth(330);
            stage.setHeight(85);
            Button okButton = new Button("Ok");
            okButton.setPrefWidth(100);
            okButton.setPrefHeight(15);
            okButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stage.close();
                }
            });
            box.getChildren().addAll(error, okButton);
            box.setAlignment(Pos.CENTER);
            Scene printError = new Scene(box);
            stage.setScene(printError);
            stage.show();
        }
    }

    public void switchScene() throws IOException {
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        Button button = new Button("Expand");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setTitle("Введите ФИО");
                stage.setHeight(360);
                stage.setWidth(300);
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("view.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
        Label surNameLabel = new Label(surName.getText());
        Label nameLabel = new Label(name.getText());
        hBox.getChildren().addAll(surNameLabel, nameLabel);
        if (!patronymic.getText().isEmpty()) {
        Label patronymicLabel = new Label(patronymic.getText());
        hBox.getChildren().add(patronymicLabel);
        }
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.TOP_CENTER);
        vBox.getChildren().addAll(hBox,button);
        stage = AppApplication.stage;
        hBox.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setWidth(300);
        stage.setHeight(360);
        stage.show();
    }
}