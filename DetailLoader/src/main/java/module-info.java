module com.example.detailloader {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires static lombok;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens com.example.detailloader to javafx.fxml;
    exports com.example.detailloader;
    exports com.example.detailloader.controller;
    opens com.example.detailloader.controller to javafx.fxml;
}