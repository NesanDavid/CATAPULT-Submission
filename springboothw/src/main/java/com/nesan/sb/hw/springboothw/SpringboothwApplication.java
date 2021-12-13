package com.nesan.sb.hw.springboothw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)//because spring auto thinks you are using jpa if you want vanilla hibernate you have to do this
public class SpringboothwApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboothwApplication.class, args);

	}

}
