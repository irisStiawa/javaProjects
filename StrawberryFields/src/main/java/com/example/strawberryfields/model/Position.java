package com.example.strawberryfields.model;

import com.example.strawberryfields.app.Constants;

import java.util.Objects;

public record Position(int x, int y) {

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

//    public boolean isStartPosition() {
//        return x == 0 && y == 0 || x == Constants.NUMBER_COLS-1 && y == Constants.NUMBER_ROWS-1;
//    }
}
