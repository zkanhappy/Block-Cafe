module com.example.blockcafe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires com.jfoenix;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.blockcafe to javafx.fxml;
    exports com.example.blockcafe;
}