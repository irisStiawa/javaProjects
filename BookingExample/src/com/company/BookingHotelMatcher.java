package com.company;

import java.util.List;

public class BookingHotelMatcher implements Matcher<Booking>{
    private String name;

    public BookingHotelMatcher(String name) {
        this.name = name;
    }

    @Override
    public boolean match(Booking var1) {
        List<Room> rooms = var1.getRooms();

        for (Room r:rooms
             ) {
            if(r.getHotel().getHotelname().contains(this.name)){
                return true;
            }
        }
        return false;
    }
}
