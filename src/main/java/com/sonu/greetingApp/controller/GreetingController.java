package com.sonu.greetingApp.controller;
import com.sonu.greetingApp.entity.GreetingEntity;
import com.sonu.greetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Get a greeting by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getGreetingById(@PathVariable Long id) {
        GreetingEntity greetingEntity = greetingService.findGreetingById(id);
        if (greetingEntity != null) {
            // Return a structured JSON response for a single greeting
            return ResponseEntity.ok().body(
                    Map.of("greeting", "Greeting for ID " + id, "message", greetingEntity.getMessage())
            );
        } else {
            // Return an error message if not found
            return ResponseEntity.status(404).body(
                    Map.of("error", "Greeting not found for ID " + id)
            );
        }
    }

    // Get all greetings
    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllGreetings() {
        List<String> greetings = greetingService.getAllGreetings()
                .stream()
                .map(greeting -> "Greeting for ID " + greeting.getId() + ": " + greeting.getMessage())
                .collect(Collectors.toList());

        return ResponseEntity.ok(greetings);
    }

    // PUT method to update a Greeting by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGreeting(@PathVariable Long id, @RequestBody GreetingEntity updatedGreeting) {
        GreetingEntity existingGreeting = greetingService.findGreetingById(id);

        if (existingGreeting == null) {
            return ResponseEntity.status(404).body("Greeting not found for ID " + id);
        }

        existingGreeting.setFirstName(updatedGreeting.getFirstName());
        existingGreeting.setLastName(updatedGreeting.getLastName());
        existingGreeting.setMessage(updatedGreeting.getMessage());

        GreetingEntity savedGreeting = greetingService.saveGreeting(existingGreeting);

        return ResponseEntity.ok(savedGreeting);
    }
}
