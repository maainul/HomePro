package com.mainul.HomePro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomName;
    private int gasBill;
    private int internetBill;
    private int extraCharge;
    private int roomRent;

    @ManyToOne()
    @JoinColumn(name = "floorid",insertable = false, updatable = false)
    private Floor floor;
    private Long floorid;

    @OneToMany(mappedBy = "room")
    private List<Rent> rents;

    public Room() {

    }

    public Room(Long id, String roomName, int gasBill, int internetBill, int extraCharge, int roomRent, Floor floor, Long floorid, List<Rent> rents) {
        this.id = id;
        this.roomName = roomName;
        this.gasBill = gasBill;
        this.internetBill = internetBill;
        this.extraCharge = extraCharge;
        this.roomRent = roomRent;
        this.floor = floor;
        this.floorid = floorid;
        this.rents = rents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Long getFloorid() {
        return floorid;
    }

    public void setFloorid(Long floorid) {
        this.floorid = floorid;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", gasBill=" + gasBill +
                ", internetBill=" + internetBill +
                ", extraCharge=" + extraCharge +
                ", roomRent=" + roomRent +
                ", floor=" + floor +
                ", floorid=" + floorid +
                ", rents=" + rents +
                '}';
    }
}
