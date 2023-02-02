package com.example.menschaergeredichnicht;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import static com.example.menschaergeredichnicht.Game.currentPlayer;
import static com.example.menschaergeredichnicht.GameSceneController.game;

public class EndViewController {


    @FXML
    private Button newGameButton;
    @FXML
    private Label winnerMessage;

    @FXML
    private void onMouseEnteredNewGame(MouseEvent mouseEvent) {
        newGameButton.setStyle("-fx-background-color: #A39384");
    }

    @FXML
    private void onMouseExitedNewGame(MouseEvent mouseEvent) {
        newGameButton.setStyle("-fx-background-color: #7D7065");
    }

    @FXML
    public void initialize(){
        winnerMessage.setText(currentPlayer.getName() +  " wins !!!");
    }


    @FXML
    private void onMouseClickedNewGame(MouseEvent mouseEvent) {
        game = new Game();


    }
}
