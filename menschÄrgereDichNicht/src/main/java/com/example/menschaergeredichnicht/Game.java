package com.example.menschaergeredichnicht;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

import java.util.Random;

public class Game {
    public static ArrayList<Player> players = new ArrayList<>();
    public static Player currentPlayer;
    private int indexOfCurrentPlayer = 0;
    private int diceAgain;
    private boolean next;
    private boolean isSix;
    private boolean isDiceBtnActive;
    private boolean end;
    private Label info;


    public Game() {
    }

    public void initGame(Label info) {

        this.info = info;

        currentPlayer = players.get(indexOfCurrentPlayer);

        for(Player p : players){
            setStonesForStart(p);
        }

        info.setText(currentPlayer.getName() + " your Dice!");
        isDiceBtnActive = true;
    }


    public void nextPlayer() {

            if(next && diceAgain == 3){
                next();
                next = false;
                diceAgain = 0;
            } else if(next && diceAgain > 0) {
                next = false;
            } else if (isSix){
                isSix = false;
            }else{
                next();
                next = false;
            }
            info.setText(currentPlayer.getName() + " your Dice!");

    }



    public void next(){
        indexOfCurrentPlayer++;

        if(indexOfCurrentPlayer == players.size()){
            indexOfCurrentPlayer = 0;
        }
        currentPlayer = players.get(indexOfCurrentPlayer);
        System.out.println(currentPlayer.getName());


    }


//    setzte Steine am Spielbeginn

    public void setStonesForStart(Player p) {
        Stone[] stones = p.getStones();
        for (int i = 1; i < 5; i++) {

            p.getHome().get(i).getField().getChildren().add(stones[i - 1].getCircle());

        }
    }


    //    Würfelergebnis validieren
    public void playersMove(int result) {

        isDiceBtnActive = false;
        FieldObject o = new FieldObject(currentPlayer, 1);
        if(playersOnBoard()){ // Spieler am Brett
            if(result != 6) { // Spieler am Brett und Ergebnis nicht 6
                ArrayList<Integer> stonesToMove = availableStones();
                valueMoves(result, stonesToMove);
            } else { // Spieler am Brett und Ergebnis  6
                isSix = true;
                if (currentPlayer.getStonesToPlay() < 4) {
                    if(o.isEmpty()){
                        prepareFieldWentOut();
                    } else {
                        if(!o.isCurrent()){
                            prepareFieldWentOut();
                        } else {
                            ArrayList<Integer> stonesToMove = new ArrayList<>();
                            stonesToMove.add(1);
                            valueMoves(result, stonesToMove);
                        }
                    }

                } else { //Spieler am Brett und keine Home
                    ArrayList<Integer> stonesToMove = availableStones();
                    valueMoves(result, stonesToMove);
                }
            }
        }else { //wenn kein Spieler am Brett und Ergebnis 6
            if(result == 6){
                isSix = true;
                prepareFieldWentOut();
            } else {
                diceAgain++;
                next = true;
                nextPlayer();
                isDiceBtnActive = true;
            }
        }
    }

    //    Mögliche Steine für den Zug
    public ArrayList<Integer> availableStones(){
        ArrayList<Integer> stoneList = new ArrayList<>();

        for(int i = 1; i < currentPlayer.getRound().size(); i++){
            FieldObject o = new FieldObject(currentPlayer, i);
            if(!o.isEmpty()){
                if(o.isCurrent()){
                    stoneList.add(i);
                }
            }
        }

        return stoneList;
    }


    //    mögliche Zuge
    private void valueMoves(int result, ArrayList<Integer> stonesToMove) {
        int valueFieldIndex;
        boolean moveAble = false;
        for (int i : stonesToMove) {
            valueFieldIndex = i + result;
            if (valueFieldIndex <= currentPlayer.getRound().size()) {
                FieldObject o = new FieldObject(currentPlayer, valueFieldIndex);
                if (o.isEmpty()) {
                    prepareField(i, valueFieldIndex);
                    moveAble = true;
                } else {
                    if (!o.isCurrent()) {
                        prepareField(i, valueFieldIndex);
                        moveAble = true;
                    }
                }
            }
        }

        if(!moveAble){
            next = true;
            nextPlayer();
            isDiceBtnActive = true;
        }

    }


    //    Feld vorbereitung
    private void prepareField(int index, int moveTo ) {
        StackPane stackPane = currentPlayer.getRound().get(moveTo).getField();
        stackPane.setBorder(new Border(new BorderStroke(Paint.valueOf("#b5f5f5"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3.0))));
        stackPane.setOnMouseClicked(mouseEvent -> setStoneAtPosition(index, moveTo));
    }

    private void prepareFieldWentOut() {
        StackPane stackPane = currentPlayer.getRound().get(1).getField();
        stackPane.setBorder(new Border(new BorderStroke(Paint.valueOf("#b5f5f5"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3.0))));
        stackPane.setOnMouseClicked(mouseEvent -> setStoneFromHomeToStart());


    }

    //    Spieler am Brett
    public boolean playersOnBoard(){
        return currentPlayer.getStonesToPlay()>0;
    }

    protected int randNumb(){
        Random rn = new Random();
        int rand = rn.nextInt(7);
        return rand;
    }

//    setzte Stein an den Start

    public void setStoneFromHomeToStart(){
        diceAgain = 0;

        int stoneCount = currentPlayer.getStonesToPlay() + 1;
        currentPlayer.setStonesToPlay(stoneCount);

        FieldObject o = new FieldObject(currentPlayer,stoneCount,true);
        FieldObject o2 = new FieldObject(currentPlayer, 1);

        if(!o2.isEmpty()){
            wentHome(1);
        }

        currentPlayer.getHome().get(stoneCount).getField().getChildren().removeAll(currentPlayer.getHome().get(stoneCount).getField().getChildren());
        currentPlayer.getHome().get(stoneCount).getField().getChildren().add(o.getN1());

        currentPlayer.getRound().get(1).getField().getChildren().add(o.getCircle());

        removeFields();


    }

//    setzte  Stein an Position

    public void setStoneAtPosition(int index, int indexToMove) {

        FieldObject o = new FieldObject(currentPlayer, index);
        FieldObject o2 = new FieldObject(currentPlayer, indexToMove);

        if(!o2.isEmpty() && !o2.isCurrent()){
            wentHome(indexToMove);
        }

        currentPlayer.getRound().get(index).getField().getChildren().removeAll(currentPlayer.getRound().get(index).getField().getChildren());
        currentPlayer.getRound().get(index).getField().getChildren().add(o.getN1());

        currentPlayer.getRound().get(indexToMove).getField().getChildren().add(o.getCircle());



        if(indexToMove == 41 || indexToMove == 42 || indexToMove == 43 || indexToMove == 44){
            currentPlayer.setStonesFinish(currentPlayer.getStonesFinish() + 1);
        }


        removeFields();

        if(currentPlayer.getStonesFinish() == 4){
            end = true;
            try{
                endView();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }


//    Schick Gegner heim

    private void wentHome(int index) {

        FieldObject o = new FieldObject(currentPlayer, index);

        currentPlayer.getRound().get(index).getField().getChildren().removeAll(currentPlayer.getRound().get(index).getField().getChildren());
        currentPlayer.getRound().get(index).getField().getChildren().add(o.getN1());

        for(int i = 1; i < o.getPlayer().getHome().size()+1; i++){
            FieldObject o2 = new FieldObject(o.getPlayer(), i, true);
            if (o2.isEmpty()){
                o2.getPlayer().getHome().get(i).getField().getChildren().add(o.getCircle());
                break;
            }
        }

    }


//    setze Felder zurück
    private void removeFields() {
        for(int i = 1; i < currentPlayer.getRound().size()+1; i++){
            StackPane p = currentPlayer.getRound().get(i).getField();
            if(p.getBorder() != null){
                p.setBorder(null);
                p.setOnMouseClicked(null);
            }
        }

        if(!end){
            next = true;
            nextPlayer();
            isDiceBtnActive = true;
        }
    }

    @FXML
    private void endView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenschAergereDichNichtApplication.class.getResource("end-View.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Congratulation!");
        stage.setScene(new Scene(root));
        stage.show();
    }



//    Getter/Setter
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getIndexOfCurrentPlayer() {
        return indexOfCurrentPlayer;
    }

    public void setIndexOfCurrentPlayer(int indexOfCurrentPlayer) {
        this.indexOfCurrentPlayer = indexOfCurrentPlayer;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isDiceBtnActive() {
        return isDiceBtnActive;
    }

    public void setDiceBtnActive(boolean diceBtnActive) {
        isDiceBtnActive = diceBtnActive;
    }


}
