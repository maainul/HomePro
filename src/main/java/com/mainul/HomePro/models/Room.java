package com.mainul.HomePro.models;

import com.mainul.HomePro.springSecurity.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room extends AuditModel{

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

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
