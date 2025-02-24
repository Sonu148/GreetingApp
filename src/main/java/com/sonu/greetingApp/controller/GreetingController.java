package com.sonu.greetingApp.controller;

import com.sonu.greetingApp.dto.Greeting;
import com.sonu.greetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor injection to inject GreetingService into the controller
    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // using get method
    @GetMapping
    public String getGreeting() {
        return "{\"" + greetingService.getSimpleGreeting() + "\"}";
    }

    // using post mapping
    @PostMapping
    public String postGreeting(@RequestBody Greeting greeting) {
        return "{\"Hello, " + greeting.getName() + "!\"}";
    }

    // using put http method
    @PutMapping
    public String putGreeting(@RequestBody Greeting greeting) {
        return "{\"Updated greeting for: " + greeting.getName() + "\"}";
    }

    // using delete http method
    @DeleteMapping
    public String deleteGreeting() {
        return "{\"Greeting deleted.\"}";
    }
}
