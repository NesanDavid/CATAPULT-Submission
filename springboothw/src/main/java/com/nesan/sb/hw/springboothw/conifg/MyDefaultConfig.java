package com.nesan.sb.hw.springboothw.conifg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
//Note this file isnt needed for basic spring web

@Configuration
public class MyDefaultConfig {
    @Value("${company.name}")
    private String name;
    
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
