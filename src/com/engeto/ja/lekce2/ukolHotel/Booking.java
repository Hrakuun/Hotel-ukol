package com.engeto.ja.lekce2.ukolHotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    private Room room;
    private List<Guest> guests;
    private LocalDate reservationStart;
    private LocalDate reservationEnd;
    private TypeOfVacation typeOfVacation;

    public Booking(Room room, List<Guest> guests,LocalDate reservationStart, LocalDate reservationEnd, TypeOfVacation typeOfVacation){
        this.room = room;
        this.guests = new ArrayList<>(guests);
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.typeOfVacation = typeOfVacation;
    }




}
