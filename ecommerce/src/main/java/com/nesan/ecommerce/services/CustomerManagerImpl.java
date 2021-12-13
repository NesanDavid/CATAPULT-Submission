package com.nesan.ecommerce.services;
import java.util.Random;

import com.nesan.ecommerce.CustomeExceptions.UnderAgeException;

import org.springframework.stereotype.Service;


@Service //Basically makes this class a component (can be matched with variable to be autowired)
public class CustomerManagerImpl implements CustomerManagerInterface{
   
    @Override
    public String getCustomerOTP() {
       
        
        Random r=new Random();
        int d1=r.nextInt(10);
        int d2=r.nextInt(10);
        int d3=r.nextInt(10);
        int d4=r.nextInt(10);

        return ""+d1+" "+d2+" " +d3+ " "+d4;
    }

    
    @Override
    public boolean verifyage(int age) throws UnderAgeException {
        if(age<18)
            throw new UnderAgeException("User is Under Aged, Cannot Proceed Further");
        
       
        return false;
    }
    
}
