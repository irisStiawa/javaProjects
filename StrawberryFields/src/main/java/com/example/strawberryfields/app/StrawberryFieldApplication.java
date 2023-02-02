package com.example.strawberryfields.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class StrawberryFieldApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StrawberryFieldApplication.class.getResource(Constants.PATH_TO_GAME_FXML));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Strawberry Field");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}