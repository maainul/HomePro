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
public class Expense extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int expenseAmount;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expenseDate;

    @ManyToOne()
    @JoinColumn(name = "expenseTypeid", insertable = false, updatable = false)
    private ExpenseType expenseType;
    private Long expenseTypeid;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
