package com.nesan.sb.hw.springboothw.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Dept")
public class Dept {

    @Id
    @Column(unique = true,length =50)
    private String DeptName;
    @Column(unique = true)
    private String DeptCode;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "dept_head")
    private DeptHead Head;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER) 
    @JoinColumn(name="Dept")
    private List<Student> students;

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public DeptHead getHead() {
        return Head;
    }

    public void setHead(DeptHead head) {
        Head = head;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Dept [DeptCode=" + DeptCode + ", DeptName=" + DeptName + ", Head=" + Head + ", students=" + students
                + "]";
    }


    
    
}
