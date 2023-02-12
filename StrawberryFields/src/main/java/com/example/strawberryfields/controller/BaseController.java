package com.example.strawberryfields.controller;

import com.example.strawberryfields.model.Game;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class BaseController {

    //Game Instanz
    static ObjectProperty<Game> game = new SimpleObjectProperty<>(new Game());

    public static Game getGame() {
        return game.get();
    }

    public static ObjectProperty<Game> gameProperty() {
        return game;
    }

    public static void setGame(Game game) {
        BaseController.game.set(game);
    }
}
