package com.example.strawberryfields.model;

import com.example.strawberryfields.app.Constants;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyCode;

public class Game {
    private Field field = new Field();
    private Player currentPlayer;
    private Player otherPlayer;

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

            checkWin();

        } else if (item != null && item.equals(otherPlayer.getItem())){
            //otherPlayer zurück zum start
            field.moveToPosition(otherPlayer.getStartPosition(), otherPlayer.getCurrentPosition());
            otherPlayer.setCurrentPosition(otherPlayer.getStartPosition());
        }

        currentPlayer.setCurrentPosition(field.moveToPosition(newPosition, currentPlayer.getCurrentPosition()));

        tooglePlayer();
    }

    private void checkWin() {
        if(getStrawberriesLeft() <= 0){
            String winner = currentPlayer.getPoints() > otherPlayer.getPoints() ? currentPlayer.getName() : otherPlayer.getName();
            System.out.println(winner + " was the Winner!!!");
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
}
