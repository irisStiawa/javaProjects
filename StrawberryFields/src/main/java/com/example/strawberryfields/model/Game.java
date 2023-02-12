package com.example.strawberryfields.model;

import com.example.strawberryfields.app.Constants;
import com.example.strawberryfields.app.StrawberryFieldApplication;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {
    private Field field = new Field();
    private Player currentPlayer;
    private Player otherPlayer;

    private String winner;


    private final Player player1;
    private final Player player2;
    private IntegerProperty strawberriesLeft  = new SimpleIntegerProperty(Constants.COUNT_OF_STRAWBERRY);



    public Game() {
        player1 = new Player("Iris", 0, Constants.PERSON_FEMALE, new Position(0,0));
        player2 = new Player("Astrid", 0, Constants.PERSON_MALE, new Position(Constants.NUMBER_COLS-1,Constants.NUMBER_ROWS-1));

        initItems();
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void handleKeyPressed(KeyCode code) {

        Position newPosition = switch(code){
            case UP, W -> createPosition(0,-1);
            case DOWN, S -> createPosition(0,1);
            case LEFT, A -> createPosition(-1,0);
            case RIGHT, D -> createPosition(1,0);
            default -> null;
        };

        if(newPosition != null && field.isValidPosition(newPosition)){
            executeMove(newPosition);
        }
    }

    // Enthält die Spiellogik
    private void executeMove(Position newPosition) {
        String item = field.getItemAtPosition(newPosition);

        if(item != null && item.equals(Constants.STRAWBERRY)){
            // Strawberry gefunden, +1
            currentPlayer.setPoints(currentPlayer.getPoints() + 1);
            strawberriesLeft.set(getStrawberriesLeft() - 1);

            try {
                checkWin();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (item != null && item.equals(otherPlayer.getItem())){
            //otherPlayer zurück zum start
            field.moveToPosition(otherPlayer.getStartPosition(), otherPlayer.getCurrentPosition());
            otherPlayer.setCurrentPosition(otherPlayer.getStartPosition());
        }

        currentPlayer.setCurrentPosition(field.moveToPosition(newPosition, currentPlayer.getCurrentPosition()));

        tooglePlayer();
    }

    private void checkWin() throws Exception{
        if(getStrawberriesLeft() <= 0){
            if(player1.getPoints() > player2.getPoints()){
                winner = player1.getName();
            } else if (player1.getPoints() < player2.getPoints()) {
                winner = player2.getName();
            } else if(player1.getPoints() == player2.getPoints()){
                winner = "unentschieden";
            }

            FXMLLoader fxmlLoader = new FXMLLoader(StrawberryFieldApplication.class.getResource(Constants.PATH_TO_CONCLUSION_FXML));
            Parent root = null;
            root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }




    private void tooglePlayer() {

        currentPlayer = player1 == currentPlayer? player2 : player1;
        otherPlayer = player1 == otherPlayer? player2 : player1;
    }


    public Position createPosition(int x, int y) {

        return new Position(currentPlayer.getCurrentPosition().getX()+x, currentPlayer.getCurrentPosition().getY()+y);
    }

    private void initItems() {

        //Current Position festlegen und die Person_Female dort einfügen
        //currentPosition = new Position(0,0);
        field.setItemAtPosition(player1.getItem(), player1.getStartPosition());
        field.setItemAtPosition(player2.getItem(), player2.getStartPosition());

        currentPlayer = player1;
        otherPlayer = player2;

        field.initStrawBerrys();
    }


    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getStrawberriesLeft() {
        return strawberriesLeft.get();
    }

    public IntegerProperty strawberriesLeftProperty() {
        return strawberriesLeft;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }


}
