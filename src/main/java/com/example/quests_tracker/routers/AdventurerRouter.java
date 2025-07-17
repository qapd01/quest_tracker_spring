package com.example.quests_tracker.routers;

import com.example.quests_tracker.dto.AdventurerDto;
import com.example.quests_tracker.entities.Adventurer;
import com.example.quests_tracker.services.AdventurerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adventurers")
@RequiredArgsConstructor
public class AdventurerRouter {
    private final AdventurerService adventurerService;

    @GetMapping
    public List<Adventurer> getAllAdventurers() {
        return adventurerService.getAllAdventurers();
    }

    @PostMapping
    public AdventurerDto registerAdventurer(@Valid @RequestBody AdventurerDto adventurerDto) {
        return adventurerService.registerAdventurer(adventurerDto);
    }

    @GetMapping("/find-by-username")
    public Optional<Adventurer> getAdventurerByusername(@RequestParam String username) {
        return adventurerService.findByUsername(username);
    }

    @PutMapping
    public AdventurerDto updateAdventurer(@Valid @RequestBody AdventurerDto adventurerDto){
        return adventurerService.updateAdventurer(adventurerDto);
    }

    @DeleteMapping
    public String deleteAdventurer(@RequestBody AdventurerDto adventurerDto) {
        return adventurerService.deleteAdventurer(adventurerDto);
    }
}
