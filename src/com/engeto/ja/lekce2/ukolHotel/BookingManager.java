package com.engeto.ja.lekce2.ukolHotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Room room, List<Guest> guests, LocalDate reservationStart, LocalDate reservationEnd, TypeOfVacation typeOfVacation) {

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

    public void addBooking(Room room, List<Guest> guests) {
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

    public Booking getBooking(int index) {
        return bookings.get(index);
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public void clearBookings() {
        bookings.clear();
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

    public int getNumberOfWorkingBookings() {
        int numberOfWorkingBookings = 0;
        for (Booking booking : bookings) {
            if (booking.getTypeOfVacation().equals(TypeOfVacation.COMPANY)) {
                numberOfWorkingBookings = +1;
            }
        }
        return numberOfWorkingBookings;
    }

    public List<Booking> getRecreationBookings(){
        List<Booking> recreationBookings = new ArrayList<>();
        for(Booking booking : bookings){
            if(recreationBookings.size() == 8){
                break;
            }
            if(booking.getTypeOfVacation().equals(TypeOfVacation.RECREATION)){
                recreationBookings.add(booking);
            }

        }
        return new ArrayList<>(recreationBookings);
    }

    public double getAverageGuests() {
        int totalGuests = 0;
        if(bookings.isEmpty()) {
            System.out.println("Neexistují žádné rezervace");
        return 0;
        }
        for(Booking booking : bookings) {
            totalGuests += booking.getNumberOfGuests();
        }
        return (double)totalGuests / bookings.size();
    }


}
