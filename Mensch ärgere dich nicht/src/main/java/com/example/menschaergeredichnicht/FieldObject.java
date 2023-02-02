package com.example.menschaergeredichnicht;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

import static com.example.menschaergeredichnicht.Game.currentPlayer;
import static com.example.menschaergeredichnicht.Game.players;

public class FieldObject {
    private int length;
    private Node n1;
    private Node n2;
    private boolean isEmpty;
    private Circle circle;
    private Color circleColor;
    private Stone stone;
    private Player player;
    private boolean current;

    public FieldObject(Player p, int index) {
        this.length = p.getRound().get(index).getField().getChildren().size() < 2 ? 1 : 2;
        this.isEmpty = this.length < 2;
        ObservableList <Node> nodes = p.getRound().get(index).getField().getChildren();
        if(isEmpty){
            n1 = nodes.get(0);
        } else{
            n1 = nodes.get(0);
            n2 = nodes.get(1);
            circle = (Circle) n2;
            stone = (Stone) circle.getUserData();
            circleColor = stone.getColor();
            player = setPlayer();



        }
    }

    public FieldObject(Player p, int index, boolean home) {
        this.length = p.getHome().get(index).getField().getChildren().size() < 2 ? 1 : 2;
        this.isEmpty = this.length < 2;
        ObservableList <Node> nodes = p.getHome().get(index).getField().getChildren();
        if(isEmpty){
            n1 = nodes.get(0);
            player = p;
        } else{
            n1 = nodes.get(0);
            n2 = nodes.get(1);
            circle = (Circle) n2;
            Stone s = (Stone) circle.getUserData();
            circleColor = s.getColor();
            player = p;



        }
    }

    public Player setPlayer(){
        for (Player p : players){
            if(circleColor.equals(p.getColor())){
                current = p == currentPlayer;
                return p;
            }
        }
        return null;
    }




    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node getN1() {
        return n1;
    }

    public void setN1(Node n1) {
        this.n1 = n1;
    }

    public Node getN2() {
        return n2;
    }

    public void setN2(Node n2) {
        this.n2 = n2;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Color getCircleColor() {
        return circleColor;
    }

    public void setCircleColor(Color circleColor) {
        this.circleColor = circleColor;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
