package com.sonu.greetingApp.controller;


import com.sonu.greetingApp.dto.Greeting;
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

    @GetMapping
    public String getGreeting() {
        return "{\"" + greetingService.getGreetingMessage(null, null) + "\"}";
    }

    @PostMapping
    public String postGreeting(@RequestBody Greeting greeting) {
        String firstName = greeting.getFirstName();
        String lastName = greeting.getLastName();
        String message = greetingService.getGreetingMessage(firstName, lastName);

        // Save the greeting message
        GreetingEntity greetingEntity = new GreetingEntity();
        greetingEntity.setFirstName(firstName);
        greetingEntity.setLastName(lastName);
        greetingEntity.setMessage(message);
        greetingService.saveGreeting(greetingEntity);

        return "{\"" + message + "\"}";
    }

    @PutMapping
    public String putGreeting(@RequestBody Greeting greeting) {
        String firstName = greeting.getFirstName();
        String lastName = greeting.getLastName();
        return "{\"Updated greeting for: " + greetingService.getGreetingMessage(firstName, lastName) + "\"}";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "{\"Greeting deleted.\"}";
    }
}