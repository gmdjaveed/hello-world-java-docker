package com.jg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AppController {
    private Logger logger = LoggerFactory.getLogger(AppController.class);

    static {
        System.out.println("In AppController static block. Starting the Spring Boot Application....");
    }

    @GetMapping("/")
    public HashMap index() {
        logger.debug("JG->request serving for /");
        System.out.println("JG->Request received in /");

        return new HashMap<>() {{
            System.out.println("Returning results for /");
            put("success", true);
            put("hello", "world");
            put("new-message", "adding a new msg");
        }};
    }

    @GetMapping("/hello")
    public HashMap hello() {
        logger.debug("JG->request serving for /hello");
        System.out.println("JG->Request received in /hello");

        return new HashMap<>() {{
            System.out.println("Returning results for /hello");
            put("success", true);
            put("hello", "hello world");
            put("new-message", "adding a new msg");
        }};
    }
}
