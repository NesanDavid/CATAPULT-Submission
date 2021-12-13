package com.nesan.sb.hw.springboothw.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity//table will be created automatically using (update) can be create-drop or whatever as well
@Table(name="tbl_customer")//To cahnge Table name
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="cust_name",nullable = false,length = 200)//To change Column name
    private String name;
    
    @Column(unique = true,length =150)
    private String email;

    @Temporal(TemporalType.DATE)//so date doesnt show the time just shows date
    private Date year;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER) //Customer can have more then one bank account
    //If you dont use Join Column then hibernate will create another table mapping both entities primary key
    @JoinColumn(name="custid")//custid will become foregin key in the brankacount table  N->the many side alwasy gets the foreign key
    private List<BankAccount> bankAccounts;
    

    private int age;

    




    //Getters and Setters

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    

    @Override
    public String toString() {
        return "CustomerDB [age=" + age + ", bankAccounts=" + bankAccounts + ", email=" + email + ", id=" + id
                + ", name=" + name + ", year=" + year + "]";
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    
}
