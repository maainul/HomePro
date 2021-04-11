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
public class ExpenseType extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenseTypeName;

    @OneToMany(mappedBy = "expenseType")
    private List<Expense> expenses;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
