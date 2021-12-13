package com.nesan.sb.hw.springboothw.repo;

import java.util.List;

import com.nesan.sb.hw.springboothw.entity.Dept;
import com.nesan.sb.hw.springboothw.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Write our hibernate code here
//We could technically directly use this instead of going through service layer ifwe wanted
@Repository // important to add this annotation
public class StudentDAOImpl extends BaseDAO {

    @Autowired
    private SessionFactory sFactory;// Bean created in MyDBconfig theory, test this

    public void saveStudent(Student st) {

        Session session = sFactory.getCurrentSession();
        session.save(st);
        Student std = new Student();
        std.setStuAge(50);
        std.setYear(new Date());
        std.setStuEmail("bond@gmail.com");
        std.setStuName("JAMES BOND");
        session.save(std);

        Dept d = new Dept();
        d.setDeptName("Bond Dept");
        d.setDeptCode("007");

        List<Student> L = new ArrayList<>();
        L.add(std);
        d.setStudents(L);

        session.save(d);
    }

    public void saveDept(Dept dt) {

        Session session = sFactory.getCurrentSession();
        session.save(dt);
    }

    public Student getStudentById(int id) {
        Session session = sFactory.getCurrentSession();
        Student cust = (Student) session.get(Student.class, id);

        return cust;
    }

    public List<Student> getStudents() {
        Session session = sFactory.getCurrentSession();

        return session.createCriteria(Dept.class).list();
    }

    public List<Dept> getDepts() {
        Session session = sFactory.getCurrentSession();

        return session.createCriteria(Dept.class).list();
    }

    public String getStudentDept(int id) {
        Session s = sFactory.getCurrentSession();

        // SELECT p
        // FROM Project pj
        // JOIN pj.contributors p
        // WHERE pj.id = :pId
        // AND p.Id = :cId
        // QUESTION: Why doesnt d.students.stuId work?
        // Q2; If we want to join2 tables like in sql e.g select * from A,B where
        // A.id=B.id how do we do in hql?
        List<String> L = s.createQuery("select d.DeptCode from Dept d JOIN d.students as s  where s.stuID=" + id)
                .list();
        String ret = L.get(0);
        System.out.println("*******************************QUERY1 START*************************************");
        for (String str : L) {
            System.out.println("ROW: " + str);
        }
        System.out.println("*******************************QUERY1 END*************************************");
        return ret;

    }

    public void testquery(int id) {

        Session s = sFactory.getCurrentSession();

        // SELECT p
        // FROM Project pj
        // JOIN pj.contributors p
        // WHERE pj.id = :pId
        // AND p.Id = :cId
        // QUESTION: Why doesnt d.students.stuId work?
        // Q2; If we want to join2 tables like in sql e.g select * from A,B where
        // A.id=B.id how do we do in hql?
        List<Object[]> L = s.createQuery("from Dept d JOIN d.students as s  where s.stuID=" + id).list();
        System.out.println("*******************************QUERY2 START*************************************");
        System.out.println("OBJECT ARR PRINT: "+Arrays.toString(L.get(0)));
        for (Object oarr[] : L) {
            Dept d=(Dept)oarr[0];
            Student std=(Student)oarr[1];
            System.out.println("DEPT: " + d);
            System.out.println("STUDENT: " + std);
        }
        System.out.println("*******************************QUERY2 END*************************************");

        //DEMOING LEft JOIN
        List<Object[]> L2 = s.createQuery("select d.DeptName,s.stuID from Dept d left JOIN d.students as s").list();
        System.out.println("*******************************QUERY2.1 LEFT JOIN START*************************************");
        System.out.println("OBJECT ARR PRINT: "+L2);
        for (Object oarr[] : L2) {
           String s1=(String)oarr[0];
           Integer i2=(Integer)oarr[1];
            System.out.println("PARAM1: " + s1);
            System.out.println("PARAM2: " + i2);
        }
        System.out.println("*******************************QUERY2.1 LEFT JOIN END*************************************");
       
        //DEMOING INNER JOIN
        List<Object[]> L3 = s.createQuery("select d.DeptName,s.stuID from Dept d JOIN d.students as s").list();
        System.out.println("*******************************QUERY2.2 INNER JOIN START*************************************");
        System.out.println("OBJECT ARR PRINT: "+L3);
        for (Object oarr[] : L3) {
           String s1=(String)oarr[0];
           Integer i2=(Integer)oarr[1];
            System.out.println("PARAM1: " + s1);
            System.out.println("PARAM2: " + i2);
        }
        System.out.println("*******************************QUERY2.2 Inner JOIN END*************************************");

        //DEMOING RETURN OBJECT (same as 2.2 but saving query result into a custom object using its constructor)
        //Note: these strats can be used for Jpa @Query as well
        //Path of Retobj needed since its not an entity onject and we use new keyword since default of hibernate is is to make a list<object[]>
        List<Retobj> L4 = s.createQuery("select new com.nesan.sb.hw.springboothw.repo.Retobj(d.DeptName,s.stuID) from Dept d JOIN d.students as s").list();
        System.out.println("*******************************QUERY2.3 RETOBJ START*************************************");
        System.out.println("OBJECT ARR PRINT: "+L4);//Prints references because we have not overriden tostring
        for (Retobj oarr : L4) {
          
            System.out.println("PARAM1: " + oarr.i);
            System.out.println("PARAM2: " + oarr.s);
        }
        System.out.println("*******************************QUERY2.3 RETOBJEND*************************************");
      
    }
}
class Retobj
{
    String s;
    int i;
    public Retobj(String s, int i) {
        this.s = s;
        this.i = i;
    } 
}
