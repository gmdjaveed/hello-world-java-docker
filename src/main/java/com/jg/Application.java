package com.jg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("JG->In Application.main(). Starting the Spring Boot Application....");
        SpringApplication.run(Application.class, args);
    }
}
