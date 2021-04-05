package com.mainul.HomePro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Floor extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String floorName;

    @OneToMany(mappedBy = "floor")
    private List<Room> rooms;

    public Floor(){

    }
    public Floor(long id, String floorName, List<Room> rooms) {
        this.id = id;
        this.floorName = floorName;
        this.rooms = rooms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", floorName='" + floorName + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
