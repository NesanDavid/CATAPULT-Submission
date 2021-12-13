package com.nesan.sb.hw.springboothw.service;

import java.util.List;

import com.nesan.sb.hw.springboothw.CustomExceptions.UnderAgeException;
import com.nesan.sb.hw.springboothw.entity.BankAccount;
import com.nesan.sb.hw.springboothw.entity.Customer;

public interface CustomerManagerInterface {
    public String getCustomerOTP();
    public String addMr(String s);
    public boolean verifyage(int age) throws UnderAgeException;
    public void save(Customer cust);
    public Customer fetchCustomerById(int id);
    public List<BankAccount> fetchBankAccounts();
    public void User_Roles_Create();
    public void testquery(int id);
    
}
