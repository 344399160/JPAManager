package com.trs.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan("com.trs.jpa")
@EntityScan("com.trs.jpa")
@EnableJpaRepositories("com.trs.jpa")
public class Application {

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    } 
    
}
