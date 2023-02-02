package com.company;

public abstract class Room {
    private int RoomNo;
    private int numberOfBeds;
    private Hotel hotel;
    private int type;

    public Room(int roomNo, int numberOfBeds, Hotel hotel, int type) {
        RoomNo = roomNo;
        this.numberOfBeds = numberOfBeds;
        this.hotel = hotel;
        this.type = type;
    }

    public abstract int netPrice();

    public int getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(int roomNo) {
        RoomNo = roomNo;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
