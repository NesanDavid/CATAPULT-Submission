package com.nesan.sb.hw.springboothw.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_DeptHead")
public class DeptHead {

    @Id
    private String Name;

    private int Salary;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "DeptHead [Name=" + Name + ", Salary=" + Salary + "]";
    }


    
    
    
}
