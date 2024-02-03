package com.engeto.ja.lekce2.ukolHotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class ListOfBookings {

    private List<Booking> bookings = new ArrayList<>();

    public void createBooking(Room room, List<Guest> guests, LocalDate reservationStart, LocalDate reservationEnd, TypeOfVacation typeOfVacation) {

        if (guests.isEmpty()) {
            System.out.println("Nezadán host");
            return;
        }
        if (room.getBedCount() < guests.size()) {
            System.out.println("Počet hostů převyšuje počet lůžek");
            return;
        }
        if (reservationStart.isAfter(reservationEnd)) {
            System.out.println("Datum začátku rezervaci musí být před datem konce");
            return;
        }
        if (!isRoomAvailable(room, reservationStart, reservationEnd)) {
            System.out.println("Pokoj je v tomto termínu obsazen");
            return;
        }
        bookings.add(new Booking(room, guests, reservationStart, reservationEnd, typeOfVacation));

    }
    public void createBooking(Room room, List<Guest> guests) {
        LocalDate reservationStart = LocalDate.now();
        LocalDate reservationEnd = reservationStart.plusDays(6);
        TypeOfVacation typeOfVacation = TypeOfVacation.RECREATION;

        if (guests.isEmpty()) {
            System.out.println("Nezadán host");
            return;
        }
        if (room.getBedCount() < guests.size()) {
            System.out.println("Počet hostů převyšuje počet lůžek");
            return;
        }

        if (!isRoomAvailable(room, reservationStart, reservationEnd)) {
            System.out.println("Pokoj je v tomto termínu obsazen");
            return;
        }
        bookings.add(new Booking(room, guests, reservationStart, reservationEnd, typeOfVacation));

    }


    public void printListOfBookings() {
        for (Booking booking : bookings) {
            booking.printBooking();
        }
    }

    private boolean isRoomAvailable(Room room, LocalDate reservationStart, LocalDate reservationEnd) {
        boolean isRoomAvailable = true;
        for (Booking booking : bookings) {
            if (room.equals(booking.getRoom())) {
                boolean isStartDateConflict = (
                        reservationStart.isAfter(booking.getReservationStart())) && (reservationStart.isBefore(booking.getReservationEnd())
                        || reservationStart.isEqual(booking.getReservationStart()));
                boolean isEndDateConflict = (
                        reservationEnd.isAfter(booking.getReservationStart())) && (reservationEnd.isBefore(booking.getReservationEnd())
                        || reservationEnd.isEqual(booking.getReservationEnd()));
                if (isStartDateConflict || isEndDateConflict) {
                    isRoomAvailable = false;
                }
            }
        }
        return isRoomAvailable;
    }
}
