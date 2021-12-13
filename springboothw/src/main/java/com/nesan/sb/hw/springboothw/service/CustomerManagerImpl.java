package com.nesan.sb.hw.springboothw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import com.nesan.sb.hw.springboothw.CustomExceptions.UnderAgeException;
import com.nesan.sb.hw.springboothw.conifg.MyDefaultConfig;
import com.nesan.sb.hw.springboothw.entity.BankAccount;
import com.nesan.sb.hw.springboothw.entity.BankAccountType;
import com.nesan.sb.hw.springboothw.entity.Customer;
import com.nesan.sb.hw.springboothw.entity.Role;
import com.nesan.sb.hw.springboothw.entity.User;
import com.nesan.sb.hw.springboothw.repo.CustomerDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Basically makes this class a component (can be matched with variable to be
         // autowired)
@Transactional
public class CustomerManagerImpl implements CustomerManagerInterface {
    @Autowired
    private MyDefaultConfig mdc;// Shocasing a defaultconfiguration we set applications properties and
                                // initialised in MyDefaultConfig.java

    @Autowired
    private CustomerDAOImpl repo;

    @Override
    public String getCustomerOTP() {

        Random r = new Random();
        int d1 = r.nextInt(10);
        int d2 = r.nextInt(10);
        int d3 = r.nextInt(10);

        return "" + d1 + d2 + d3;
    }

    @Override
    public String addMr(String s) {
        // int j=10/0;//THrowing Exception
        return mdc.getName() + " Mr " + s;
    }

    @Override
    public boolean verifyage(int age) throws UnderAgeException {
        if (age < 18)
            throw new UnderAgeException("User is Under Aged, Cannot Proceed Further");

        return false;
    }

    @Override
    public void save(Customer cust) {
        List<BankAccount> accounts = new ArrayList<>();
        BankAccountType bType1 = new BankAccountType();
        BankAccountType bType2 = new BankAccountType();
        bType1.setDescription("savings");
        bType2.setDescription("current");
        BankAccountType select;
        for (int i = 0; i < 5; i++) {
            // ONE IS TO ONE BankAccount-> BankAccountType
            // BankAccountType bType=new BankAccountType();
            if (i % 2 == 0) {
                bType1.setDescription("Savings");
                select = bType1;
            } else {
                bType2.setDescription("Current");
                select = bType2;
            }

            BankAccount ba = new BankAccount();
            ba.setBalance(100 * i);
            ba.setBankAcctNbr("012761" + i);
            ba.setBranchCode("BRANCH00" + i);
            ba.setType(select);
            accounts.add(ba);
        }
        // ONE IS TO MANY CUSTOMER->BANK ACCOUNTS
        cust.setBankAccounts(accounts);// Cutomer has list of bankaccounts as property(one is to many). Setting Given
                                       // customer with 5 accounts
        repo.save(cust);

    }

    @Override
    public Customer fetchCustomerById(int id) {

        return repo.getCustomerById(id);
    }

    @Override
    public List<BankAccount> fetchBankAccounts() {

        return repo.getBankAccounts();
    }

    @Override
    public void User_Roles_Create() {
        for (int i = 1; i <= 2; i++) 
        {
            User usr = new User();
            usr.setUserid("virt"+i);
            usr.setEmail(i+"virt@nesan.com");
            usr.setPassword("virt00"+i);

            // Setting 2 roles for usr

            Role r1 = new Role();
            Role r2 = new Role();
            r1.setDescription("General User");
            r1.setRoleId("Particitpant type "+i);
            r2.setDescription("User with higher Privilege");
            r2.setRoleId("Admin level "+i);
            List<Role> rolelist = new ArrayList<>();
            rolelist.add(r1);
            rolelist.add(r2);
            usr.setRoles(rolelist);

            repo.save(usr);
        }

    }

    @Override
    public void testquery(int id) {
        repo.testquery(id);
        
    }
   
    

}
