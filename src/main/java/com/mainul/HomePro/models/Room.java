package com.mainul.HomePro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roomName;
    private int gasBill;
    private int internetBill;
    private int extraCharge;
    private int roomRent;

    @ManyToOne()
    @JoinColumn(name = "floorid",insertable = false, updatable = false)
    private Floor floor;



}
