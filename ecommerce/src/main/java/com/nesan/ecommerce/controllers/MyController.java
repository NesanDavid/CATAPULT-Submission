package com.nesan.ecommerce.controllers;
import javax.validation.Valid;

import com.nesan.ecommerce.configurations.MyDataConfig;
import com.nesan.ecommerce.nesanclasses.Customer;
import com.nesan.ecommerce.services.CustomerManagerImpl;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


//NOTE: @GetMapping = @RequestMapping(method = RequestMethod.GET). ->similar for @PostMapping

@Controller// Tells Spring Boot that there are methods in this class that should be able to handle http requests
public class MyController extends BaseController{

   // private static final Logger logger = LoggerFactory.getLogger(MyController.class);
    @Autowired CustomerManagerImpl cml;
    @Autowired MyDataConfig mdc;

    @GetMapping("/home")
    public ModelAndView m1(Customer c )
    {
        //logger.debug("IN HOME");
        ModelAndView mv =new ModelAndView();
        mv.addObject("mycustomer", c);
        mv.addObject("companyname",mdc.getName());
        mv.setViewName("home");
        return mv;
       
    }

    @PostMapping(value="/order")
    public ModelAndView m2(@Valid @ModelAttribute("mycustomer")Customer customer,Errors errors) throws Exception
    {
        ModelAndView mv=new ModelAndView();
        if(errors.hasErrors())
        {
            mv.setViewName("home");
            return mv;
        }
        cml.verifyage(customer.getAge());
        
        mv.setViewName("order");
        mv.addObject("res", customer);
        mv.addObject("companyname",mdc.getName());
        String otp=cml.getCustomerOTP();
        mv.addObject("otp", otp);
        
        return mv;
    }

   
   
    
}
