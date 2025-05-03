package com.lokesh.splitwise.models;

import com.lokesh.splitwise.models.enums.ExpenseUserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "expense_users")
public class ExpenseUser extends BaseModel{

    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;
    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType type;
}
