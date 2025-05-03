package com.lokesh.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "groupss")
public class Group extends BaseModel{
    private String description;

    @ManyToOne
    private User CreatedBy;

    @ManyToMany
    private List<User> Members;

    @OneToMany
    private List<Expense> expenses;
}
