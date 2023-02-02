package com.company;

public class BookingBookerMatcher implements Matcher<Booking>{
    private String name;

    public BookingBookerMatcher(String name) {
        this.name = name;
    }

    @Override
    public boolean match(Booking var1) {
        return var1.getBooker().getNachname().contains(this.name);
    }
}
