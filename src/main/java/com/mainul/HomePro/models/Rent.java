package com.mainul.HomePro.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rentalPaymentDate;
    private int gasBill;
    private int internetBill;
    private int electricityBill;
    private int extraCharge;
    private int roomRent;
    private int arrears;
    private int paidArrears;

    @ManyToOne()
    @JoinColumn(name = "roomid",insertable = false, updatable = false)
    private Room room;
    private Long roomid;


    public Rent(){

    }

    public Rent(Long id, Date rentalPaymentDate, int gasBill, int internetBill, int electricityBill, int extraCharge, int roomRent, int arrears, int paidArrears, Room room, Long roomid) {
        this.id = id;
        this.rentalPaymentDate = rentalPaymentDate;
        this.gasBill = gasBill;
        this.internetBill = internetBill;
        this.electricityBill = electricityBill;
        this.extraCharge = extraCharge;
        this.roomRent = roomRent;
        this.arrears = arrears;
        this.paidArrears = paidArrears;
        this.room = room;
        this.roomid = roomid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRentalPaymentDate() {
        return rentalPaymentDate;
    }

    public void setRentalPaymentDate(Date rentalPaymentDate) {
        this.rentalPaymentDate = rentalPaymentDate;
    }

    public int getGasBill() {
        return gasBill;
    }

    public void setGasBill(int gasBill) {
        this.gasBill = gasBill;
    }

    public int getInternetBill() {
        return internetBill;
    }

    public void setInternetBill(int internetBill) {
        this.internetBill = internetBill;
    }

    public int getElectricityBill() {
        return electricityBill;
    }

    public void setElectricityBill(int electricityBill) {
        this.electricityBill = electricityBill;
    }

    public int getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(int extraCharge) {
        this.extraCharge = extraCharge;
    }

    public int getRoomRent() {
        return roomRent;
    }

    public void setRoomRent(int roomRent) {
        this.roomRent = roomRent;
    }

    public int getArrears() {
        return arrears;
    }

    public void setArrears(int arrears) {
        this.arrears = arrears;
    }

    public int getPaidArrears() {
        return paidArrears;
    }

    public void setPaidArrears(int paidArrears) {
        this.paidArrears = paidArrears;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", rentalPaymentDate=" + rentalPaymentDate +
                ", gasBill=" + gasBill +
                ", internetBill=" + internetBill +
                ", electricityBill=" + electricityBill +
                ", extraCharge=" + extraCharge +
                ", roomRent=" + roomRent +
                ", arrears=" + arrears +
                ", paidArrears=" + paidArrears +
                ", room=" + room +
                ", roomid=" + roomid +
                '}';
    }
}
