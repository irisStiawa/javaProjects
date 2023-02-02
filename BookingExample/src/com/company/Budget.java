package com.company;

public class Budget extends Room{

    public Budget(int roomNo, int numberOfBeds, Hotel hotel, int type) {
        super(roomNo, numberOfBeds, hotel, type);
    }

    public int netPrice() {
        int calc;

        if(this.getType() == 1){
            calc = this.getNumberOfBeds() * 5 * 2;
        }

        if(this.getType() == 2){
            calc = this.getNumberOfBeds() * 5 * 5;
        }

        if(this.getType() == 3){
            calc = this.getNumberOfBeds() * 5 * 1;
        }
        else{
            calc = this.getNumberOfBeds() * 5 * 1;
        }

        return calc;
    }
}
