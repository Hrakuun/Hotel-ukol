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


//region get/set
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public LocalDate getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(LocalDate reservationStart) {
        this.reservationStart = reservationStart;
    }

    public LocalDate getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(LocalDate reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public TypeOfVacation getTypeOfVacation() {
        return typeOfVacation;
    }

    public void setTypeOfVacation(TypeOfVacation typeOfVacation) {
        this.typeOfVacation = typeOfVacation;
    }
//    endregion
}
