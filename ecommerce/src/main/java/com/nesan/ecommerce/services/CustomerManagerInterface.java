package com.nesan.ecommerce.services;

import com.nesan.ecommerce.CustomeExceptions.UnderAgeException;

public interface CustomerManagerInterface {
    public String getCustomerOTP();
    public boolean verifyage(int age) throws UnderAgeException;
    
}
