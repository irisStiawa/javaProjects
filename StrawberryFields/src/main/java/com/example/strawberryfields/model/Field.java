package com.example.strawberryfields.model;

import com.example.strawberryfields.app.Constants;
import com.example.strawberryfields.model.Position;
import com.example.strawberryfields.model.Square;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.util.Callback;

import java.util.Random;

public class Field {
    // Rufe 'call' auf, sobald ein Sqaure eingefügt wird und sich die itemProperty eines der Squares in der Liste ändert
    private ObservableList<Square> squares = FXCollections.observableArrayList(new Callback<Square, Observable[]>() {
        @Override
        public Observable[] call(Square square) {
//            System.out.println("callback for square");
            return new Observable[] {square.itemProperty()};
        }
    });



    public Field() {
//        erzeugt das Objektmodel, 1-dim Liste
        initSquares();
    }



    public void initStrawBerrys() {

        for(int i = 0; i < Constants.COUNT_OF_STRAWBERRY; i++){
            Random random = new Random();
            int y = random.nextInt(Constants.NUMBER_ROWS-1);
            int x = random.nextInt(Constants.NUMBER_COLS-1);
            Position position = new Position(x,y);
            System.out.println(getItemAtPosition(position));
            if(getItemAtPosition(position) == null){
                setItemAtPosition(Constants.STRAWBERRY, position);
            } else {
                i--;
            }

        }
    }

    public void setItemAtPosition(String item, Position position){
        squares.get(indexFromPosition(position)).setItem(item);
    }

    private void initSquares() {

        for (int i=0; i<(Constants.NUMBER_ROWS*Constants.NUMBER_COLS); i++) {

//            System.out.println("initSquares: " + i);
            squares.add(new Square(null));
        }
    }

    public ObservableList<Square> getSquares() {
        return squares;
    }



    public boolean isValidPosition(Position newPosition) {

        return newPosition.getX() >= 0 && newPosition.getX() < Constants.NUMBER_COLS && newPosition.getY() >= 0 && newPosition.getY() < Constants.NUMBER_ROWS;
    }

    public Position moveToPosition(Position newPosition, Position currentPosition) {
        // 1. in square an currentPosition finden
        int index = indexFromPosition(currentPosition);
        String item = squares.get(index).getItem();


        // 2. item an currentPosition löschen
        squares.get(index).setItem(null);

        // 3. item an newPosition hinzufügen
        squares.get(indexFromPosition(newPosition)).setItem(item);

        //4. Position updaten
        return newPosition;
    }

    /** Umrechnung von 2D auf 1D-Listen-Index **/
    private int indexFromPosition(Position newPosition) {
        return newPosition.getX() + newPosition.getY()*Constants.NUMBER_COLS;
    }


    public String getItemAtPosition(Position position) {
        return squares.get(indexFromPosition(position)).getItem();
    }
}
