package com.jg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

@RestController
public class AppController {
    private Logger logger = LoggerFactory.getLogger(AppController.class);

    private String appName = System.getenv("APP_NAME");

    @GetMapping("/")
    public HashMap index() throws UnknownHostException {
        logger.debug("request serving for /");
        return getHostDetails("/");
    }

    @GetMapping("/hello")
    public HashMap hello() throws UnknownHostException {
        logger.debug("request serving for /hello");
        return getHostDetails("/hello");
    }


    private HashMap<String, String> getHostDetails(String requestedPath) throws UnknownHostException {
        // Local address
        String localHostAddress = InetAddress.getLocalHost().getHostAddress();
        String localHostName = InetAddress.getLocalHost().getHostName();

        // Remote address
        String remoteHostAddress = InetAddress.getLoopbackAddress().getHostAddress();
        String remoteHostName = InetAddress.getLoopbackAddress().getHostName();

        return new HashMap<>() {{
            System.out.println("Returning results for:" + requestedPath);
            put("success", String.valueOf(true));
            put("hello", (requestedPath.equals("/hello") ? appName + " world": "world"));
            put("APP_NAME", appName);
            put("localHostAddress", localHostAddress);
            put("localHostName", localHostName);
            put("remoteHostAddress", remoteHostAddress);
            put("remoteHostName", remoteHostName);
        }};
    }
}
