package com.nesan.sb.hw.springboothw.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.nesan.sb.hw.springboothw.entity.Dept;
import com.nesan.sb.hw.springboothw.entity.DeptHead;
import com.nesan.sb.hw.springboothw.entity.Student;

import com.nesan.sb.hw.springboothw.repo.StudentDAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentManagerImpl implements StudentManagerInterface {

    @Autowired
    private StudentDAOImpl repo;

    @Override
    public void save(Student s) {
        List<Student> L = new ArrayList<Student>();
        L.add(s);
        Dept D = null;
        for (int i = 1; i < 5; i++) {
            D = new Dept();
            D.setDeptCode("DEPTCODE: 5640" + i);
            D.setDeptName("DPT" + i);

            DeptHead DH = new DeptHead();
            DH.setName("name" + i);
            DH.setSalary(100 * i);
            D.setHead(DH);
            repo.saveDept(D);
        }
        D.setStudents(L);
        repo.saveStudent(s);

    }

    @Override
    public Student fetchStudentById(int id) {
        return repo.getStudentById(id);
    }

    @Override
    public List<Dept> fetchDepts() {
        return repo.getDepts();
    }

    @Override
    public String fetchDeptbyStuid(int id) {

        return repo.getStudentDept(id);
    }

    @Override
    public void testquery(int id) {
        repo.testquery(id);
    }

    @Autowired
    private SessionFactory sFactory;// just showing that we can do the same thing without repo

    @Override
    public void testquery2() {
        Session session = sFactory.getCurrentSession();

        Query q = session.createQuery("from Student s where s.stuName=:name");
        q.setParameter("name", "JAMES BOND");// Set parameter prevents SQL Injection
        Student std = (Student) q.getSingleResult();// Can do this if you want to retrieve one result instead of list()
        System.out.println("***************QUERY3 START**************************");
        System.out.println(std);
        System.out.println("***************QUERY3 END**************************");

        // Find average Age of Students
        Double d = (Double) session.createQuery("select avg(s.stuAge) from Student s").getSingleResult();
        System.out.println("***************QUERY4 START**************************");
        System.out.println("AVERAGE AGE OF STUDENTS:" + d);
        System.out.println("***************QUERY4 END**************************");

       System.out.println("*************Native SQL demo:************************");//USE createSQLQuery instead ofcreate query
       String stri= (String)session.createSQLQuery("select Dept from tbl_student where stuid=1").getSingleResult();
       System.out.println(stri);
       System.out.println("*************Native SQL demo finished:************************");
    }

    @Override
    public void HCQLdemo() {
        Session session = sFactory.getCurrentSession();
        // Get all Student records
        Criteria c = session.createCriteria(Student.class);
        System.out.println("***************HCQL 1 START**************************");
        System.out.println("ALL STUDENTS: " + c.list());
        System.out.println("***************HCQL 1  END**************************");
        // Get Students whose age>
         c = session.createCriteria(Student.class);
        c.add(Restrictions.gt("stuAge", 20));//set any restriction
        c.addOrder(Order.asc("stuName"));//order by
        c.setProjection(Projections.property("stuName"));//WHat to print.  Can  send a ProjectionList for mulltiple properties
        System.out.println("***************HCQL 2 START**************************");
        System.out.println("STudents with age > 20: " + c.list());
        System.out.println("***************HCQL 2  END**************************");

    }

}
