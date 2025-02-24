package com.sonu.greetingApp.service;

import com.sonu.greetingApp.entity.GreetingEntity;
import com.sonu.greetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;
    private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Existing method to find a greeting by ID
    public GreetingEntity findGreetingById(Long id) {
        logger.info("Looking for greeting with ID: {}", id);
        return greetingRepository.findById(id).orElse(null);
    }

    // Add a method to get all greetings
    public List<GreetingEntity> getAllGreetings() {
        logger.info("Fetching all greetings");
        return greetingRepository.findAll();
    }

    // Save the updated GreetingEntity
    public GreetingEntity saveGreeting(GreetingEntity greetingEntity) {
        return greetingRepository.save(greetingEntity);
    }
}
