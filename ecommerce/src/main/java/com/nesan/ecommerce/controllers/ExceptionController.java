package com.nesan.ecommerce.controllers;

import com.nesan.ecommerce.CustomeExceptions.UnderAgeException;

//import org.slf4j.Logger;//SLF4J LOGGER
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // Special controller for exception handler if you want
public class ExceptionController extends BaseController {

   // private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class); //add this for logger functionality

    @ExceptionHandler(Exception.class)
    public ModelAndView handleRTErrors(Exception ex) {
        ModelAndView mvError = new ModelAndView();
        mvError.addObject("message", "System not responding try again layer -" +ex.getMessage());
        mvError.setViewName("error");
        System.out.println("\n**************************** PRINTING STACK TRACE **********************************\n");
        ex.printStackTrace();

        //logger.error("Error Occured -"+ex.getMessage(), ex);

        return mvError;

    }

    @ExceptionHandler(UnderAgeException.class)
    public ModelAndView handleAgeErrors(Exception ex) {
        ModelAndView mvError = new ModelAndView();
        mvError.addObject("message", ex.getMessage());
        mvError.setViewName("error");
        System.out.println("\n********************************** PRINTING STACK TRACE ********************************\n");
        ex.printStackTrace();
       //logger.error("Error Occured -"+ex.getMessage(), ex);

        return mvError;

    }
}
