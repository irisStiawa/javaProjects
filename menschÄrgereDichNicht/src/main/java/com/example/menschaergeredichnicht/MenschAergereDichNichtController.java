package com.example.menschaergeredichnicht;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenschAergereDichNichtController {

    @FXML
    private TextField inputPlayerRed;
    @FXML
    private TextField inputPlayerBlue;
    @FXML
    private TextField inputPlayerGreen;
    @FXML
    private TextField inputPlayerYellow;
    @FXML
    private Button buttonStart;

    @FXML
    private void onMouseEnteredStart(MouseEvent mouseEvent) {
        buttonStart.setStyle("-fx-background-color: #A39384");
    }

    @FXML
    private void onMouseExitedStart(MouseEvent mouseEvent) {
        buttonStart.setStyle("-fx-background-color:  #7D7065");
    }

    @FXML
    private void onButtonStartClick(ActionEvent actionEvent) {
        isValidPlayer(inputPlayerRed.getText(), Color.RED);
        isValidPlayer(inputPlayerBlue.getText(), Color.BLUE);
        isValidPlayer(inputPlayerGreen.getText(), Color.GREEN);
        isValidPlayer(inputPlayerYellow.getText(), Color.YELLOW);

        try {
            gameScene();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void isValidPlayer(String s, Color color){
        if(!s.isBlank()){
            initPlayer(s, color);


        }
    }

    private void initPlayer(String name, Color color){
        Player player = new Player(name, color);
        Game.players.add(player);

    }


    private void gameScene() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(MenschAergereDichNichtApplication.class.getResource("gameScene-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) inputPlayerRed.getScene().getWindow();
        stage.setTitle("Mensch ärgere dich nicht!");
        stage.setScene(scene);
        stage.show();
    }


}