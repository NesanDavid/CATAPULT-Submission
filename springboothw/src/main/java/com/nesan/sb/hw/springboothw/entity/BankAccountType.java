package com.nesan.sb.hw.springboothw.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BankAccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Use GenerationType.IDENTITY if you want to start with 1,Auto will make sure keys are unique amoung all tables
    private int id;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BankAccountType [description=" + description + ", id=" + id + "]";
    }



    
    
}
