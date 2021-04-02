package com.mainul.HomePro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Expense {

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

    public Expense() {

    }

    public Expense(Long id, int expenseAmount, String description, Date expenseDate, ExpenseType expenseType, Long expenseTypeid) {
        this.id = id;
        this.expenseAmount = expenseAmount;
        this.description = description;
        this.expenseDate = expenseDate;
        this.expenseType = expenseType;
        this.expenseTypeid = expenseTypeid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public Long getExpenseTypeid() {
        return expenseTypeid;
    }

    public void setExpenseTypeid(Long expenseTypeid) {
        this.expenseTypeid = expenseTypeid;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expenseAmount=" + expenseAmount +
                ", description='" + description + '\'' +
                ", expenseDate=" + expenseDate +
                ", expenseType=" + expenseType +
                ", expenseTypeid=" + expenseTypeid +
                '}';
    }
}
