package com.engeto.ja.lekce2.ukolHotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Guest adela = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest jan = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5));

        System.out.println(adela);
        System.out.println(jan);
        System.out.println();

        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, 1, true, true, BigDecimal.valueOf(1000)));
        rooms.add(new Room(2, 1, true, true, BigDecimal.valueOf(1000)));
        rooms.add(new Room(3, 3, false, true, BigDecimal.valueOf(2400)));

        System.out.println("Pokoje:");
        for (Room room : rooms) {
            System.out.println(room);
        }
        System.out.println();

        BookingManager bookingManager = new BookingManager();
        bookingManager.addBooking(rooms.get(0), Arrays.asList(new Guest[]{adela}), LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), TypeOfVacation.RECREATION);
        bookingManager.addBooking(rooms.get(2), Arrays.asList(new Guest[]{adela, jan}), LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), TypeOfVacation.COMPANY);
        bookingManager.addBooking(rooms.get(1), Arrays.asList(new Guest[]{jan}));

        fillBookings(bookingManager, rooms);

//        bookingManager.printListOfBookings();

        printOutBookings(bookingManager);
        System.out.println();
        printOut8RecreationBookings(bookingManager);
        System.out.println();
        printGuestStatistics(bookingManager);
    }

    public static void printOutBookings(BookingManager bookingManager) {
        System.out.println("Veškeré rezervace:");
        List<Booking> bookings = bookingManager.getBookings();
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public static void printGuestStatistics(BookingManager bookingManager) {
        System.out.println("Statistika hostů:");
        List<Booking> bookings = bookingManager.getBookings();
        int oneGuestBookings = 0;
        int twoGuestBookings = 0;
        int moreGuestBookings = 0;
        for (Booking booking : bookings) {
            if (booking.getGuests().size() == 1) {
                oneGuestBookings += 1;
            }
            if (booking.getGuests().size() == 2) {
                twoGuestBookings += 1;
            }
            if (booking.getGuests().size() > 2) {
                moreGuestBookings += 1;
            }
        }
        System.out.println("Počet rezervací s jedním hostem: " + oneGuestBookings);
        System.out.println("Počet rezervací s dvěma hosty: " + twoGuestBookings);
        System.out.println("Počet rezervací s více než dvěma hosty: " + moreGuestBookings);

    }

    public static void printOut8RecreationBookings(BookingManager bookingManager) {
        List<Booking> recreationBookings = bookingManager.getRecreationBookings();
        System.out.println("Prvních 8 rekreačních rezervací:");
        for (Booking booking : recreationBookings) {
            System.out.println(booking);
        }

    }

    public static void fillBookings(BookingManager bookingManager, List<Room> rooms) {
        bookingManager.addBooking(rooms.get(2), Arrays.asList(new Guest[]{new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15))}), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), TypeOfVacation.COMPANY);
        bookingManager.addBooking(rooms.get(1), Arrays.asList(new Guest[]{new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3))}), LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), TypeOfVacation.RECREATION);

        Guest karolina = new Guest("Karolína", "Tmavá", LocalDate.of(1987, 11, 5));
        for (int i = 0; i < 10; i++) {
            bookingManager.addBooking(rooms.get(1), Arrays.asList(new Guest[]{karolina}), LocalDate.of(2023, 8, 1).plusDays(2 * i), LocalDate.of(2023, 8, 2).plusDays(2 * i), TypeOfVacation.RECREATION);
        }
        bookingManager.addBooking(rooms.get(2), Arrays.asList(new Guest[]{karolina}), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), TypeOfVacation.COMPANY);

    }
}
