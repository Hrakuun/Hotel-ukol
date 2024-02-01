package com.engeto.ja.lekce2.ukolHotel;

import java.time.LocalDate;
import java.util.List;

public class ListOfBookings {

    private List<Booking> bookings;


    public void createBooking(Room room, List<Guest> guests, LocalDate reservationStart, LocalDate reservationEnd, TypeOfVacation typeOfVacation){
        if((room.getBedCount()>=guests.size()) && (guests.size() > 0)){
            if(reservationStart.isBefore(reservationEnd)){
                bookings.add(new Booking(room,guests,reservationStart,reservationEnd,typeOfVacation));
            } else {
                System.out.println("Datum začátku rezervaci musí být před datem konce");
            }
        } else {
            System.out.println("Počet hostů převyšuje kapacitu lůžek");
        }
    }

}
