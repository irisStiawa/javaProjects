package com.example.menschaergeredichnicht;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenschAergereDichNichtApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenschAergereDichNichtApplication.class.getResource("menschAergereDichNicht-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mensch ärgere dich nicht!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}