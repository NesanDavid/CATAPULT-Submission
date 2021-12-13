package com.nesan.sb.hw.springboothw.controller;



import java.util.Date;


import com.nesan.sb.hw.springboothw.entity.Student;
import com.nesan.sb.hw.springboothw.service.StudentManagerInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController extends BaseController {

    @Autowired
    private StudentManagerInterface studService;

    @RequestMapping(value = "/registerstudent", method = RequestMethod.GET)
    public String viewFormPage(Model model)//This is another way as appose to returning modelview
    {
      

        model.addAttribute("mystudent",new Student());
       
        
       
        return "index";
        
    }


    @RequestMapping(value = "/registerstudentcomplete", method = RequestMethod.POST)
   
    public String viewCustomerPage( @ModelAttribute("mystudent")Student student, Model model) throws Exception//Retrieves mycustomer from model view note same command for retrieving addobject()
    {  //Note that tyhe throws exception is only there for the underage custom exception that verifyage throws
    System.out.println("MODEL 2: "+model);
    
      Student std=new Student();
       std.setStuAge(student.getStuAge());
       std.setYear(new Date());
       std.setStuEmail(student.getStuEmail());
       std.setStuName(student.getStuName());
       studService.save(std);
        
        
      
       Student stdfromdb= studService.fetchStudentById(std.getStuID());
       studService.testquery(std.getStuID());
       studService.testquery2();
       studService.HCQLdemo();
      
        model.addAttribute("info","Student Created... "+stdfromdb);//Notice that for ModelandView return type we use addObject() not add attribute
        model.addAttribute("ID", student.getStuID());
        model.addAttribute("AGE", student.getStuAge());
        model.addAttribute("EMAIL", student.getStuEmail());
        model.addAttribute("YEAR", student.getYear());
        model.addAttribute("NAME", student.getStuName());
        model.addAttribute("DEPT", studService.fetchDeptbyStuid(std.getStuID()));
        
        
        return "statusstudent";
        
    }
    
}
