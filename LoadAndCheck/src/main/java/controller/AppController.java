package controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.XlsxModel;
import repository.ExcelReader;

import java.util.List;

public class AppController {

    private Stage stage;
    private Scene scene;
    private List<XlsxModel> data;

    @FXML
    private TextField path;

    @FXML
    protected void readClick(String path) throws Exception {
        ExcelReader reader = new ExcelReader();
        data = reader.reade(path);
    }
}
