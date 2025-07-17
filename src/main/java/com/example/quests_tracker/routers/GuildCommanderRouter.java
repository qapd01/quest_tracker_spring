package com.example.quests_tracker.routers;

import com.example.quests_tracker.dto.GuildCommanderDto;
import com.example.quests_tracker.entities.GuildCommander;
import com.example.quests_tracker.services.GuildCommanderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guild-commanders")
@RequiredArgsConstructor
public class GuildCommanderRouter {
    private final GuildCommanderService guildCommanderService;

    @GetMapping
    public List<GuildCommander> getAllGuildCommanders() {
        return guildCommanderService.getAllGuildCommanders();
    }

    @PostMapping
    public GuildCommanderDto registerGuildCommander(@Valid @RequestBody GuildCommanderDto guildCommanderDto){
        return guildCommanderService.registerGuildCommander(guildCommanderDto);
    }
}
