package com.nesan.sb.hw.springboothw.repo;

import java.util.List;

import com.nesan.sb.hw.springboothw.entity.BankAccount;
import com.nesan.sb.hw.springboothw.entity.Customer;
import com.nesan.sb.hw.springboothw.entity.User;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Write our hibernate code here
//We could technically directly use this instead of going through service layer ifwe wanted
@Repository//important to add this annotation
public class CustomerDAOImpl extends BaseDAO {

    @Autowired 
    private SessionFactory sFactory;//Bean created in MyDBconfig theory, test this
    
    public void save(Customer cust)
    {
       
        Session session=sFactory.getCurrentSession();
        session.save(cust);
    }

    public Customer getCustomerById(int id)
    {
        Session session=sFactory.getCurrentSession();
        Customer cust=(Customer)session.get(Customer.class,id);
        return cust;
    }

    public List<Customer> getCustomers()
    {
        Session session=sFactory.getCurrentSession();
       
        return session.createCriteria(Customer.class).list();
    }

    public List<BankAccount> getBankAccounts()
    {
        Session session=sFactory.getCurrentSession();
       
        return session.createCriteria(BankAccount.class).list();
    }

    public void save(User user)
    {
       
        Session session=sFactory.getCurrentSession();
        session.save(user);
    }
//Reason for loop printing doesnt work for many to many is because user list points to roll list tostring and then vice versa till stack overflow
//Solution use getters and setters to print what you want
       
  
    public void testquery(int id) {
       
        Session s=sFactory.getCurrentSession();
       List<Customer> L=s.createQuery("from Customer c where c.id="+id).list();
       System.out.println("*******************************QUERY START*************************************");
       for(Customer c: L)
       {
           System.out.println(c.getBankAccounts());
       }
       System.out.println("*******************************QUERY END*************************************");
        
    }

   
    
}
