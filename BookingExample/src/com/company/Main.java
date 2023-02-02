package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person p1 = new Person("Daniel", "Oeller", new Datum(18,1,1996));
        Person p2 = new Person("Max", "Hofstetter", new Datum(1,1,2020));
        Hotel h1 = new Hotel(3111,"4 Seasons");
        Hotel h2 = new Hotel(1900,"Hilton");
        Budget bud1 = new Budget(101,2,h1,1);
        Budget bud2 = new Budget(101,2,h2,1);
        Suite s1 = new Suite(501,4,h1,3);
        Suite s2 = new Suite(501,4,h2,3);
        Booking b1 = new Booking(001,p1);
        b1.addRoom(bud1);
        b1.addRoom(s1);
        Booking b2 = new Booking(002,p1);
        b2.addRoom(bud2);
        Booking b3 = new Booking(003,p2);
        b3.addRoom(s2);
        b3.addRoom(bud2);

        List<Booking> bookingList = new ArrayList<Booking>();
        bookingList.add(b1);
        bookingList.add(b2);
        bookingList.add(b3);

        //Filtern
        List<Booking> filteredBooker1 = filteredBooker(bookingList, "Oeller");
        List<Booking> filterdHotel1 = filterHotel(bookingList, "Hilton");

        System.out.println("Filtern nach Bucher:");
        for (Booking b: filteredBooker1
        ) {
            System.out.println(b.getBookingNo() + "t" + b.getBooker().getNachname());
        }

        System.out.println("Filtern nach Hotel:");
        for (Booking b: filterdHotel1
        ) for(Room r: b.getRooms()){
            System.out.println(b.getBookingNo() + "\t" + r.getRoomNo()+ "\t" + r.getHotel().getHotelname());
        }

        //Filtern mit Interface
        System.out.println("Interface:");
        BookingBookerMatcher mBooker = new BookingBookerMatcher("Oeller");
        BookingHotelMatcher mHotel = new BookingHotelMatcher("Hilton");

        List<Booking> filteredBooker = new ArrayList<Booking>();
        filteredBooker = filter(bookingList, mBooker);
        List<Booking> filteredHotel = filter(bookingList, mHotel);

        System.out.println("Filtern mit Interface nach Bucher:");
        for (Booking b: filteredBooker
             ) {
            System.out.println(b.getBookingNo() + "\t" + b.getBooker().getNachname());
        }
        System.out.println("Filtern mit Interface nach Hotel:");
        for (Booking b: filteredHotel
        ) {
            for (Room r: b.getRooms()
                 ) {
                System.out.println(b.getBookingNo() + "\t" + r.getRoomNo()+ "\t" + r.getHotel().getHotelname());
            }
        }

        int bookingPrice = 0;

        System.out.println("Preis:");
        for (Room room: b1.getRooms()) {
            System.out.println(room.netPrice());
            bookingPrice += room.netPrice();
        }

        System.out.println("Gesamtpreis: " + bookingPrice);


    }

    private static List<Booking> filteredBooker (List<Booking> bookings, String searchTerm){
        List<Booking> filteredList = new ArrayList<>();

        for (Booking b: bookings){
            if(b.getBooker().getNachname().contains(searchTerm)){
                filteredList.add(b);
            }
        }
        return filteredList;
    }

    private static List<Booking> filterHotel (List<Booking> bookings, String searchTerm){
        List<Booking> filteredList = new ArrayList<>();

        for (Booking b: bookings){
            for (Room r: b.getRooms()){
                if(r.getHotel().getHotelname().contains(searchTerm)){
                    filteredList.add(b);
                }
            }
        }
        return filteredList;
    }

    private static List<Booking> filter (List<Booking> bookings, Matcher<Booking> matcher){
        List<Booking> filteredBookings = new ArrayList<Booking>();

        for (Booking book : bookings) {
            if(matcher.match(book)){
                filteredBookings.add(book);
            }
        }
        return filteredBookings;
    }
}
