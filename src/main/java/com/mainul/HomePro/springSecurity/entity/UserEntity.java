package com.mainul.HomePro.springSecurity.entity;

import com.mainul.HomePro.models.Home;
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
    //private String username;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;


    @OneToMany(mappedBy = "user")
    private List<Home> myTodos = new ArrayList<Home>();



}