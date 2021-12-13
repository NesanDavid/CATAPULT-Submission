package org.publisher.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting publisher Service....!" );
        if (args.length > 0){
        	System.setProperty("server.port", args[0]);
        }
        
        SpringApplication.run(Application.class, args);
    }
}
