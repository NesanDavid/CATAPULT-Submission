package com.nesan.ecommerce.CustomeExceptions;

public class UnderAgeException extends Exception 
{

    public UnderAgeException(String message) {
        super(message);
    }

    public UnderAgeException(String message, Throwable th) {
        super(message, th);
    }
    
}
