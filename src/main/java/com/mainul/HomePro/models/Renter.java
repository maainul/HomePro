
package com.mainul.HomePro.models;

import com.mainul.HomePro.springSecurity.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Renter extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String maritalStatus;
    private String NID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String email;
    private String phoneNumber1;
    private String phoneNumber2;
    private String facebook;
    private String occupation;
    private String permanentAddress;
    private String officeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date officeJoinDate;
    private String officePost;
    private String salary;
    //private Room room;
    private String discount;
    private String advanceMonth;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rentalDate;

    @Column(nullable = true, length = 64)
    private String renterImage;


    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Transient
    public String getRentersImagePath() {
        if (renterImage == null) return null;
        return "/renter-images/" + id + "/" + renterImage;
    }




}


