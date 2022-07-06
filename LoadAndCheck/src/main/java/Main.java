import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) throws IOException {
        launch(args);
        /*Reader reader = new Reader();
        List<XlsxModel> list = reader.reade("C:\\Users\\User\\IdeaProjects\\homework\\LoadAndCheck\\src\\main\\resources\\KTI.xlsx");
        Writer writer = new Writer();
        writer.write(list);
         */
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*stage.setTitle("Введите путь к файлу");
        stage.setHeight(360);
        stage.setWidth(300);
        root = FXMLLoader.load(getClass().getResource("/fxml/start.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        this.stage = stage;
        stage.show();*/
        stage.setTitle("Введите путь к файлу");
        stage.setHeight(360);
        stage.setWidth(300);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/start.fxml"));
        Parent root = null;
        try{
        root = loader.load();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
