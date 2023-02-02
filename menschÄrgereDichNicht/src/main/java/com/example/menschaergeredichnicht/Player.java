package com.example.menschaergeredichnicht;

import java.util.HashMap;


public class Player  {
    private String name;
    private Color color;
    private Stone[] stones;
    private HashMap<Integer, Field> home;
    private HashMap<Integer, Field> round;

    private int stonesToPlay;
    private int stonesFinish;


    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.stones = createStones();


    }

    public HashMap<Integer, Field> getHome() {
        return home;
    }

    public void setHome(HashMap<Integer, Field> home) {
        this.home = home;
    }

    public HashMap<Integer, Field> getRound() {
        return round;
    }

    public void setRound(HashMap<Integer, Field> round) {
        this.round = round;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Stone[] getStones() {
        return stones;
    }

    public void setStones(Stone[] stones) {
        this.stones = stones;
    }

    public int getStonesToPlay() {
        return stonesToPlay;
    }

    public void setStonesToPlay(int stonesToPlay) {
        this.stonesToPlay = stonesToPlay;
    }


    public Stone[] createStones() {
        Stone[] stones = new Stone[4];
        for(int i = 1; i<5; i++){
            Stone stone = new Stone(i,color);
            stones[i-1] = stone;
        }

        return stones;
    }

    public int getStonesFinish() {
        return stonesFinish;
    }

    public void setStonesFinish(int stonesFinish) {
        this.stonesFinish = stonesFinish;
    }



}
