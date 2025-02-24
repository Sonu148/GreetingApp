package com.sonu.greetingApp.controller;

import com.sonu.greetingApp.dto.Greeting;
import com.sonu.greetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    // dependency injection
    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // get method for message using service layer
    @GetMapping
    public String getGreeting() {
        return "{\"" + greetingService.getGreetingMessage(null, null) + "\"}";
    }

    // post method for message using service layer
    @PostMapping
    public String postGreeting(@RequestBody Greeting greeting) {
        String firstName = greeting.getFirstName();
        String lastName = greeting.getLastName();

        return "{\"" + greetingService.getGreetingMessage(firstName, lastName) + "\"}";
    }

    // put method for message using service layer
    @PutMapping
    public String putGreeting(@RequestBody Greeting greeting) {
        String firstName = greeting.getFirstName();
        String lastName = greeting.getLastName();
        return "{\"Updated greeting for: " + greetingService.getGreetingMessage(firstName, lastName) + "\"}";
    }

    // delete method for message using service layer
    @DeleteMapping
    public String deleteGreeting() {
        return "{\"Greeting deleted.\"}";
    }
}
