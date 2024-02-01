package com.engeto.ja.lekce2.ukolHotel;

import java.math.BigDecimal;

public class Room {

    private int roomNo;
    private int bedCount;
    private boolean hasBalcony;
    private boolean hasSeaView;
    private BigDecimal pricePerNight;

    public Room(int roomNo, int bedCount, boolean hasBalcony, boolean hasSeaView, BigDecimal pricePerNight) {
        this.roomNo = roomNo;
        this.bedCount = bedCount;
        this.hasBalcony = hasBalcony;
        this.hasSeaView = hasSeaView;
        this.pricePerNight = pricePerNight;
    }

    public Room(int roomNo, int bedCount, BigDecimal pricePerNight) {
        this.roomNo = roomNo;
        this.bedCount = bedCount;
        this.pricePerNight = pricePerNight;
    }

    //    region get/set
    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasSeaView() {
        return hasSeaView;
    }

    public void setHasSeaView(boolean hasSeaView) {
        this.hasSeaView = hasSeaView;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
//    endregion

}
