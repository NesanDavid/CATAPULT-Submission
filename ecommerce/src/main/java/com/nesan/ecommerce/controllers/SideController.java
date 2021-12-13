package com.nesan.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // Tells Spring Boot that there are methods in this class that should be able to
            // handle http requests
public class SideController extends BaseController {

    // private static final Logger logger =
    // LoggerFactory.getLogger(MyController.class);

    @GetMapping("/test")
    public ModelAndView m3() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test");
        return mv;

    }

    @GetMapping("/hover")
    public ModelAndView m4() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hover");
        return mv;

    }
}