package com.example.strawberryfields.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameStatusController extends BaseController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label player1NameLabel;

    @FXML
    private Label player1PointsLabel;

    @FXML
    private Label player2NameLabel;

    @FXML
    private Label player2PointsLabel;

    @FXML
    private Label strawberrysLeftLabel;

    @FXML
    void initialize() {
        assert player1NameLabel != null : "fx:id=\"player1NameLabel\" was not injected: check your FXML file 'game-status-view.fxml'.";
        assert player1PointsLabel != null : "fx:id=\"player1PointsLabel\" was not injected: check your FXML file 'game-status-view.fxml'.";
        assert player2NameLabel != null : "fx:id=\"player2NameLabel\" was not injected: check your FXML file 'game-status-view.fxml'.";
        assert player2PointsLabel != null : "fx:id=\"player2PointsLabel\" was not injected: check your FXML file 'game-status-view.fxml'.";
        assert strawberrysLeftLabel != null : "fx:id=\"strawberrysLeftLabel\" was not injected: check your FXML file 'game-status-view.fxml'.";

        player1NameLabel.textProperty().bind(game.getPlayer1().nameProperty());
        player2NameLabel.textProperty().bind(game.getPlayer2().nameProperty());
        player1PointsLabel.textProperty().bind(game.getPlayer1().pointsProperty().asString());
        player2PointsLabel.textProperty().bind(game.getPlayer2().pointsProperty().asString());
        strawberrysLeftLabel.textProperty().bind(game.strawberriesLeftProperty().asString());
    }

}
