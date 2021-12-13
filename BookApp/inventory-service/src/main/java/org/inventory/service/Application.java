package org.inventory.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application 
{
    public static void main( String[] args )
    {
        System.out.println( ">>>>>> Account Services Gets Started...." );
        if (args.length > 0){
        	System.setProperty("server.port", args[0]);
        }
        SpringApplication.run(Application.class, args);
    }
}
