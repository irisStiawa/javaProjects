package com.example.menschaergeredichnicht;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class Field {
    private StackPane field;
    private boolean isActive;

    public Field(StackPane field) {
        this.field = field;

    }

    public StackPane getField() {
        return field;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
