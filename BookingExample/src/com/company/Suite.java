package com.company;

public class Suite extends Room{

    public Suite(int roomNo, int numberOfBeds, Hotel hotel, int type) {
        super(roomNo, numberOfBeds, hotel, type);
    }

    public int netPrice() {
        int calc = this.getNumberOfBeds() * 50;
        return calc;
    }
}
