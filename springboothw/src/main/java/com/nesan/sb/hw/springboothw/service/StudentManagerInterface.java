package com.nesan.sb.hw.springboothw.service;

import java.util.List;

import com.nesan.sb.hw.springboothw.entity.Dept;
import com.nesan.sb.hw.springboothw.entity.Student;




public interface StudentManagerInterface {
    
    public void save(Student s);
    public Student fetchStudentById(int id);
    public List<Dept> fetchDepts();
    public String fetchDeptbyStuid(int id);
    public void testquery(int id);
    public void testquery2();
    public void HCQLdemo();
    
}
