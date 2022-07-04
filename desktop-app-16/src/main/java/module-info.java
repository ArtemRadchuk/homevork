module com.example.app.desktopapp16 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.app.desktopapp16 to javafx.fxml;
    exports com.example.app.desktopapp16;
    exports com.example.app.desktopapp16.controller;
    opens com.example.app.desktopapp16.controller to javafx.fxml;
}