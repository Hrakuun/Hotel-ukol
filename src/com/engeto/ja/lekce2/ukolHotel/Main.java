package com.engeto.ja.lekce2.ukolHotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        Guest adela = new Guest("Adéla","Malíková", LocalDate.of(1993,3,13));
        Guest jan = new Guest("Jan","Dvořáček", LocalDate.of(1995,5,5));

        System.out.println(adela);
        System.out.println(jan);
        System.out.println();

        Room room1 = new Room(1,1, true,true,BigDecimal.valueOf(1000));
        Room room2 = new Room(2,1, true,true,BigDecimal.valueOf(1000));
        Room room3 = new Room(3,3,false,true,BigDecimal.valueOf(2400));

        System.out.println(room1);
        System.out.println(room2);
        System.out.println(room3);
        System.out.println();

        ListOfBookings listOfBookings = new ListOfBookings();
        listOfBookings.createBooking(room1,Arrays.asList(new Guest[]{adela}),LocalDate.of(2021,7,19),LocalDate.of(2021,7,26),TypeOfVacation.RECREATION);
        listOfBookings.createBooking(room3,Arrays.asList(new Guest[]{adela,jan}),LocalDate.of(2021,9,1),LocalDate.of(2021,9,14),TypeOfVacation.RECREATION);
        listOfBookings.createBooking(room2,Arrays.asList(new Guest[]{jan}));

        listOfBookings.printListOfBookings();
    }
}
