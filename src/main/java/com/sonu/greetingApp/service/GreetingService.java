package com.sonu.greetingApp.service;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    // Method to return a simple "Hello, World!" message
    public String getSimpleGreeting() {
        return "Hello, World!";
    }
}
