module com.example.strawberryfields {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.strawberryfields to javafx.fxml;
    exports com.example.strawberryfields.app;
    opens com.example.strawberryfields.app to javafx.fxml;
    exports com.example.strawberryfields.controller;
    opens com.example.strawberryfields.controller to javafx.fxml;
    exports com.example.strawberryfields.model;
    opens com.example.strawberryfields.model to javafx.fxml;
}