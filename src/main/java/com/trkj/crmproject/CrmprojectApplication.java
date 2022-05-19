package com.trkj.crmproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class CrmprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmprojectApplication.class, args);
//        ConfigurableApplicationContext run = SpringApplication.run(CrmprojectApplication.class, args);
    }

}
