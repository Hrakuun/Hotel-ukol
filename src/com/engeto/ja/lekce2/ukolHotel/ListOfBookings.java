package com.engeto.ja.lekce2.ukolHotel;

import java.time.LocalDate;
import java.util.List;

public class ListOfBookings {

    private List<Booking> bookings;

    public void createBooking(Room room, List<Guest> guests, LocalDate reservationStart, LocalDate reservationEnd, TypeOfVacation typeOfVacation){

        if(guests.isEmpty()) {
            System.out.println("Nezadán host");
            return;
        }
        if(room.getBedCount() < guests.size()) {
            System.out.println("Počet hostů převyšuje počet lůžek");
            return;
        }
        if(reservationStart.isAfter(reservationEnd)) {
            System.out.println("Datum začátku rezervaci musí být před datem konce");
            return;
        }
        bookings.add(new Booking(room,guests,reservationStart,reservationEnd,typeOfVacation));
    }
}
