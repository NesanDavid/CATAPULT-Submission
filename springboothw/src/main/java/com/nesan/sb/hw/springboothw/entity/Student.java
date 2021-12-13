package com.nesan.sb.hw.springboothw.entity;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_student")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stuID;

    @Column(nullable = false,length = 200)//To change Column name
    private String stuName;
    
    @Column(unique = true,length =150)
    private String stuEmail;

    private int stuAge;

    @Temporal(TemporalType.DATE)//so date doesnt show the time just shows date
    private Date year;

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student [stuAge=" + stuAge + ", stuEmail=" + stuEmail + ", stuID=" + stuID + ", stuName=" + stuName
                + ", year=" + year + "]";
    }

   

    

  
}
