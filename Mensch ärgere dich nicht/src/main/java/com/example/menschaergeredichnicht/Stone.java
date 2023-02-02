package com.example.menschaergeredichnicht;

import javafx.scene.Node;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Stone extends Shape {
    int stoneID;
    private final Color color;
    private Circle circle;

    public Stone(int stoneID, Color color) {
        this.stoneID = stoneID;
        this.color = color;
        this.circle = createCircle();
    }

    public int getStoneID() {
        return stoneID;
    }

    public void setStoneID(int stoneID) {
        this.stoneID = stoneID;
    }

    public Color getColor() {
        return color;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    private Circle createCircle() {
        Circle circle = new Circle(25);
        circle.setUserData(this);
        circle.setStroke(Paint.valueOf(Color.BLACK.toString()));
        RadialGradient gradient = new RadialGradient(0,
                0.1,
                0.533f,
                0.507f,
                30,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0.1f, javafx.scene.paint.Color.rgb(color.getRed(), color.getGreen(), color.getBlue())),
                new Stop(1.0f, javafx.scene.paint.Color.rgb(0, 0, 0)));
        circle.setFill(gradient);

        return circle;
    }


}
