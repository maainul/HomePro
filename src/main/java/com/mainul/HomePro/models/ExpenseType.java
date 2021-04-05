package com.mainul.HomePro.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
public class ExpenseType extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenseTypeName;

    @OneToMany(mappedBy="expenseType")
    private List<Expense> expenses;

    public ExpenseType(){

    }
    public ExpenseType(Long id, String expenseTypeName, List<Expense> expenses) {
        this.id = id;
        this.expenseTypeName = expenseTypeName;
        this.expenses = expenses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseTypeName() {
        return expenseTypeName;
    }

    public void setExpenseTypeName(String expenseTypeName) {
        this.expenseTypeName = expenseTypeName;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "ExpenseType{" +
                "id=" + id +
                ", expenseTypeName='" + expenseTypeName + '\'' +
                ", expenses=" + expenses +
                '}';
    }
}
