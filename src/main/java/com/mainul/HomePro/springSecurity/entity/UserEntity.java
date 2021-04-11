package com.mainul.HomePro.springSecurity.entity;

import com.mainul.HomePro.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;


    @OneToMany(mappedBy = "user")
    private List<Home> homeList = new ArrayList<Home>();

    @OneToMany(mappedBy = "user")
    private List<Expense> expenseList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<ExpenseType> expenseTypeList = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    private List<Room> roomList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Floor> floorList = new ArrayList<>();



}