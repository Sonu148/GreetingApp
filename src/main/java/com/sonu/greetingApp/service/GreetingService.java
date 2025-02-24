package com.sonu.greetingApp.service;

import com.sonu.greetingApp.entity.GreetingEntity;
import com.sonu.greetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // method for generate the message
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello, World!";
        }
    }

    // method to save greeting
    public GreetingEntity saveGreeting(GreetingEntity greetingEntity) {
        return greetingRepository.save(greetingEntity);
    }
}