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

    // Existing methods...

    // Add this method to find a greeting by ID
    public GreetingEntity findGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }
}
