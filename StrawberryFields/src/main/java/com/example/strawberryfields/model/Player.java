package com.example.strawberryfields.model;

import javafx.beans.property.*;

public class Player {

    //Java FX zeigt diese an
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty points = new SimpleIntegerProperty();
    private String item;
    private Position currentPosition;
    private Position startPosition;

    public Player(String name, Integer points, String item, Position startPosition) {
        // Propertys werden automatisch mit neuem Inhalt befüllt
        setName(name);
        setPoints(points);

        //verschiedene Varianten zur Property Erstellung
//        this.name.set(name);
//        setName(name);
//        this.name = new SimpleStringProperty(name);

        this.item = item;
        this.currentPosition = startPosition;
        this.startPosition = startPosition;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getPoints() {
        return points.get();
    }

    public IntegerProperty pointsProperty() {
        return points;
    }

    public void setPoints(int points) {
        this.points.set(points);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }
}
