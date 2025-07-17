package com.example.quests_tracker.services;

import com.example.quests_tracker.dto.AdventurerDto;
import com.example.quests_tracker.entities.Adventurer;
import com.example.quests_tracker.repository.AdventurerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdventurerService {
    private final AdventurerRepository adventurerRepository;

    public List<Adventurer> getAllAdventurers() {
        return adventurerRepository.findAll();
    }

    public AdventurerDto registerAdventurer(AdventurerDto adventurerDto) {
        Adventurer adventurer = new Adventurer();
        adventurer.setUsername(adventurerDto.getUsername());
        adventurer.setPassword(adventurerDto.getPassword());
        adventurer.setCreatedAt(LocalDateTime.now());
        adventurer.setUpdatedAt(LocalDateTime.now());
        adventurerRepository.save(adventurer);
        return adventurerDto;
    }

    public Optional<Adventurer> findById(Long id) {
        Optional<Adventurer> res = adventurerRepository.findById(id);
        if (res.isEmpty()){
            throw new RuntimeException("Adventurer not found with id: " + id);
        }
        return res;
    }
    public Optional<Adventurer> findByUsername(String username) {
        Optional<Adventurer> res = adventurerRepository.findByUsername(username);
        if (res.isEmpty()){
            throw new RuntimeException("Adventurer not found with username: " + username);
        }
        return res;
    }

    public AdventurerDto updateAdventurer(AdventurerDto adventurerDto) {
        String username = adventurerDto.getUsername();
        Optional<Adventurer> res = adventurerRepository.findByUsername(username);
        if (res.isEmpty()){
            throw new RuntimeException("Adventurer not found with username:"+ username);
        }
        Adventurer existing = res.get();
        existing.setPassword(adventurerDto.getPassword());
        existing.setUpdatedAt(LocalDateTime.now());
        adventurerRepository.save(existing);
        return adventurerDto;
    }

    public String deleteAdventurer(AdventurerDto adventurerDto) {
        String username = adventurerDto.getUsername();
        String password = adventurerDto.getPassword();
        Optional<Adventurer> res = adventurerRepository.findByUsername(username);
        if (res.isEmpty()){
            throw  new RuntimeException("Adventurer not found with username:"+ username);
        }
        if (!res.get().getPassword().equals(password)) {
            throw new RuntimeException("Password does not match for username: " + username);
        }
        adventurerRepository.delete(res.get());
        return "Adventurer with username: " + username + " has been deleted successfully.";
    }
}
