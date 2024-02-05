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

    private String seaViewString(){
        if(hasSeaView)
            return "s výhledem na moře, ";
        else
            return "bez výhledu na moře, ";
    }
    private String balconyString(){
        if(hasBalcony)
            return "s balkonem, ";
        else
            return "bez balkónu, ";
    }

    @Override
    public String toString() {
        return "Pokoj č. " + roomNo + ", počet lůžek: " + bedCount + ", " + seaViewString() + balconyString() + "cena za noc: " + pricePerNight + " Kč";
    }

    //    region get/set
    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public boolean getHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean getHasSeaView() {
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

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    //    endregion

}
