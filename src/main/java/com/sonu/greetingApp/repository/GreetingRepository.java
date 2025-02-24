package com.sonu.greetingApp.repository;

import com.sonu.greetingApp.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {
    // JpaRepository already provides methods like save(), findById(), etc.
}
