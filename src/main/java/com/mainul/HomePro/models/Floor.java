package com.mainul.HomePro.models;

import com.mainul.HomePro.springSecurity.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Floor extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String floorName;

    @OneToMany(mappedBy = "floor")
    private List<Room> rooms;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
