package com.example.quests_tracker.repository;

import com.example.quests_tracker.entities.Adventurer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdventurerRepository extends JpaRepository<Adventurer, Long> {
    Optional<Adventurer> findByUsername(String username);
}
