package com.nesan.ecommerce.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
//Note this file isnt needed for basic spring web
import org.springframework.context.annotation.PropertySource;
//Note: Maven places anything under src/main/resource as class path
//Can write full file url as well
@Configuration
@PropertySource(value = "classpath:data.properties")
public class MyDataConfig {
    @Value("${company.name}")
    private String name;
    
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
