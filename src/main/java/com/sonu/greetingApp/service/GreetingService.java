package com.sonu.greetingApp.service;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    // method for generate the message
    public String getGreetingMessage(String firstName, String lastName) {

        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        }
        else if (firstName != null) {
            return "Hello, " + firstName + "!";
        }
        else if (lastName != null) {
            return "Hello, " + lastName + "!";
        }
        else {
            return "Hello, World!";
        }
    }
}
