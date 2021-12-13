package com.nesan.sb.hw.springboothw.controller;

import com.nesan.sb.hw.springboothw.CustomExceptions.UnderAgeException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice//Special controller for exception handler if you want
public class ExceptionController  {

        @ExceptionHandler(Exception.class)   
        public ModelAndView handleRTErrors(Exception ex)
        {
            ModelAndView mvError=new ModelAndView();
            mvError.addObject("message", "System not responding try again layer");
            mvError.setViewName("error");
            System.out.println("\n**************************** PRINTING STACK TRACE **********************************\n");
            ex.printStackTrace();

            return mvError;

        }

        @ExceptionHandler(UnderAgeException.class)   
        public ModelAndView handleAgeErrors(Exception ex)
        {
            ModelAndView mvError=new ModelAndView();
            mvError.addObject("message", ex.getMessage());
            mvError.setViewName("error");
            System.out.println("\n********************************** PRINTING STACK TRACE ********************************\n");
            ex.printStackTrace();

            return mvError;

        }
}
