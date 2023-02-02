package com.company;

import java.util.List;

public class Hotel {
    private int HotelNo;
    private String Hotelname;
    private List<Room> roomList;

    public Hotel(int hotelNo, String hotelname) {
        HotelNo = hotelNo;
        Hotelname = hotelname;
    }

    public int getHotelNo() {
        return HotelNo;
    }

    public void setHotelNo(int hotelNo) {
        HotelNo = hotelNo;
    }

    public String getHotelname() {
        return Hotelname;
    }

    public void setHotelname(String hotelname) {
        Hotelname = hotelname;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
