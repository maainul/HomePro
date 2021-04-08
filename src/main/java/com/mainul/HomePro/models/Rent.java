package com.mainul.HomePro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rent extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rentMonth;
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

}
