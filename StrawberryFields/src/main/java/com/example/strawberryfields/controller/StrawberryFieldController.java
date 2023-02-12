package com.example.strawberryfields.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.strawberryfields.model.Field;
import com.example.strawberryfields.model.Game;
import com.example.strawberryfields.model.Square;
import com.example.strawberryfields.app.Constants;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class StrawberryFieldController extends BaseController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private GridPane fieldView;

//    // Model, das die Daten liefert
//    private Game game = new Game();
    private Field field = game.getValue().getField();

    @FXML
    void initialize() {
        assert fieldView != null : "fx:id=\"fieldView\" was not injected: check your FXML file 'field-view.fxml'.";

        initField();

        game.getValue().getField().getSquares().addListener(new ListChangeListener<Square>() {
            @Override
            public void onChanged(Change<? extends Square> change) {

                while(change.next()) {

                    if (change.wasUpdated()) {
                        // c.from() liefert index von verändertem Square
//                        System.out.println("Updated: " + change.getFrom());
                        updateSquare(change.getFrom());
                    }
                }
            }
        });

        //ab dieser Zeile werden veränderte Squares upgedeted!


//        FieldView soll Fokus bekommen für KeyEvents
        //InvalidationListener verwenden wenn nur Zeitpunkt der Änderung benötigt wird
        //ChangeListener verwenden wenn nur Inhalt und Zeitpunkt der Änderung benötigt wird
        fieldView.sceneProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                fieldView.requestFocus();
            }
        });

//        Aufruf KeyEvent
//        fieldView.addEventHandler(KeyEvent.KEY_PRESSED, (e) -> onKeyPressed(e));
        fieldView.setOnKeyPressed(this::onKeyPressed);

        BaseController.gameProperty().addListener(new ChangeListener<Game>() {
            @Override
            public void changed(ObservableValue<? extends Game> observableValue, Game oldGame, Game newGame) {
                initialize();
            }
        });
    }



    @FXML
    private void initField() {
        // alle statisch definierten Kindknoten entfernen
        fieldView.getChildren().clear();

        for (int rowIndex = 0; rowIndex< Constants.NUMBER_ROWS; rowIndex++) {

            for (int colIndex=0; colIndex<Constants.NUMBER_COLS; colIndex++) {

                StackPane squareView = new StackPane();
                squareView.getStyleClass().add("square-view");
                fieldView.add(squareView, colIndex, rowIndex);

                // FIXME: Hier zu beginn updaten
                int index = colIndex + (Constants.NUMBER_COLS)*rowIndex;
                updateSquare(index);
            }
        }
    }



    @FXML
    private void generateSquares(){

    }

    @FXML
     private void updateSquaresAtIndex(int index){

    }

    /**
     * Entfernt den ImageView im Square View an der Stelle index und
     * Fügt ein neues ImageView ein.
     * @param index
     */
    private void updateSquare(int index) {

        if (fieldView.getChildren().get(index) instanceof StackPane squareView) {
//            lange schreibweise von instanceof
//            StackPane squareView = (StackPane) fieldView.getChildren().get(index);

            // imageView immer zuerst entfernen
            squareView.getChildren().clear();

            // Je nachdem welches Item im Model an dieser Position liegt, wird
            // das passende Bild ausgewählt
            String item = game.getValue().getField().getSquares().get(index).getItem();
            // FIXME: überprüfen ob item vorhanden
            if (item != null) {
                Image image = imageForItem(item);
                ImageView imageView = new ImageView(image);
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(createHeight(item));
                squareView.getChildren().add(imageView);
            }
        }
    }

    private double createHeight(String item) {
        return switch(item){
            case "s"-> 30;
            case "P", "p" -> 50;
            default -> 0;
        };
    }

    /**
     * Lädt je nach Item ein anderes Bild
     * @param item
     * @return
     */
    @FXML
    private Image imageForItem(String item){
        /* P, p, s */
        String path = switch (item) {
            case Constants.PERSON_FEMALE -> Constants.PATH_TO_FEMALE_PLAYER;
            case Constants.PERSON_MALE -> Constants.PATH_TO_MALE_PLAYER;
            case Constants.STRAWBERRY -> Constants.PATH_TO_STRAWBERRY;
            default -> throw new RuntimeException();
        };

        return new Image(getClass().getResourceAsStream(path));
    }


    // Eventhandler KeyEvents
    private void onKeyPressed(KeyEvent keyEvent){

        game.getValue().handleKeyPressed(keyEvent.getCode());
    }


}
