package com.sonu.greetingApp.controller;

import com.sonu.greetingApp.entity.GreetingEntity;
import com.sonu.greetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Existing methods...

    // Get a greeting by ID
    @GetMapping("/{id}")
    public String getGreetingById(@PathVariable Long id) {
        GreetingEntity greetingEntity = greetingService.findGreetingById(id);
        if (greetingEntity != null) {
            return "{\"Greeting for ID " + id + ": " + greetingEntity.getMessage() + "\"}";
        } else {
            return "{\"error\": \"Greeting not found for ID " + id + "\"}";
        }
    }
}
