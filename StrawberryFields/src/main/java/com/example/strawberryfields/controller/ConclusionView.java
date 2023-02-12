package com.example.strawberryfields.controller;

import com.example.strawberryfields.model.Game;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ConclusionView extends BaseController{
    public Label winnerLabel;


    @FXML
    void initialize() {
        switch (game.getValue().getWinner()){
            case "unentschieden":
                winnerLabel.setText("Unentschieden!!");
                break;
            default: winnerLabel.setText(game.getValue().getWinner() + " hat gewonnen!!");
        }
    }

    public void playAgain(MouseEvent mouseEvent) {
        BaseController.setGame(new Game());
        Stage stage = (Stage) winnerLabel.getScene().getWindow();
        stage.close();
    }

    public void exit(MouseEvent mouseEvent) {
        Platform.exit();
        System.exit(0);
    }
}
