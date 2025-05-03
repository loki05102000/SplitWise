package com.lokesh.splitwise.models;

import com.lokesh.splitwise.models.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "expensess")
public class Expense extends BaseModel{
    private String description;
    private double amount;
    private String date;

    @ManyToOne
    private User createdBy;

    @OneToMany
    private List<ExpenseUser> expenses;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

}
