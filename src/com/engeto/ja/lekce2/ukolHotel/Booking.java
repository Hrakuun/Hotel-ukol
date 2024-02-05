package com.engeto.ja.lekce2.ukolHotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    private Room room;
    private List<Guest> guests;
    private LocalDate reservationStart;
    private LocalDate reservationEnd;
    private TypeOfVacation typeOfVacation;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd. MM. yyyy");

    public Booking(Room room, List<Guest> guests, LocalDate reservationStart, LocalDate reservationEnd, TypeOfVacation typeOfVacation) {
        this.room = room;
        this.guests = new ArrayList<>(guests);
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.typeOfVacation = typeOfVacation;
    }

    private String hasSeaView() {
        if (room.getHasSeaView())
            return "ano";
        else
            return "ne";
    }

    @Override
    public String toString() {
        return reservationStart.format(dateFormat) + " až " + reservationEnd.format(dateFormat) + ": " + guests.get(0) + "[" + guests.size() + ", " + hasSeaView() + "] za " + getPrice() + " Kč";
    }

    public void printBooking() {
        for (Guest guest : guests) {
            System.out.print(guest.getFirstName() + " " + guest.getSurname() + ", ");
        }
        System.out.println("pokoj č. " + room.getRoomNo() + ", od " + reservationStart.format(dateFormat) + " do " + reservationEnd.format(dateFormat) + ", cena: " + room.getPricePerNight() + " Kč");
    }

    public int getNumberOfGuests() {
        return guests.size();
    }

    private long getBookingLength() {
        return ChronoUnit.DAYS.between(reservationStart,reservationEnd);
    }
    public BigDecimal getPrice(){
        return room.getPricePerNight().multiply(BigDecimal.valueOf(getBookingLength()));
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
