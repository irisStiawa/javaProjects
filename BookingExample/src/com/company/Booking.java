package com.company;

import java.util.List;
import java.util.ArrayList;

public class Booking {
    private int bookingNo;
    private Person booker;
    private List<Room> rooms = new ArrayList();

    public Booking(int bookingNo, Person booker) {
        this.bookingNo = bookingNo;
        this.booker = booker;
    }

    public Booking(int bookingNo, Person booker, List<Room> rooms) {
        this.bookingNo = bookingNo;
        this.booker = booker;
        this.rooms = rooms;
    }

    public boolean addRoom(Room room) {
        return this.rooms.add(room);
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(int bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Person getBooker() {
        return booker;
    }

    public void setBooker(Person booker) {
        this.booker = booker;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
