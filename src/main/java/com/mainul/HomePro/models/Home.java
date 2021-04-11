package com.mainul.HomePro.models;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

import com.mainul.HomePro.springSecurity.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Home extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sellerName;
    private String buyerName;
    private String propertySize;
    private String propertyLocation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date firstPaymentDate;
    private int firstPaymentAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finalPaymentDate;
    private int propertyPrice;
    private String homeName;
    private String propertyPicture;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;


    
}