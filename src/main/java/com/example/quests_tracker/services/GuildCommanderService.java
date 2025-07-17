package com.example.quests_tracker.services;

import com.example.quests_tracker.dto.GuildCommanderDto;
import com.example.quests_tracker.entities.GuildCommander;
import com.example.quests_tracker.repository.GuildCommanderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuildCommanderService {
    private final GuildCommanderRepository guildCommanderRepository;

    public List<GuildCommander> getAllGuildCommanders() {
        return guildCommanderRepository.findAll();
    }

    public GuildCommanderDto registerGuildCommander(GuildCommanderDto guildCommanderDto) {
        GuildCommander guildCommander = new GuildCommander();
        guildCommander.setUsername(guildCommanderDto.getUsername());
        guildCommander.setPassword(guildCommanderDto.getPassword());
        guildCommander.setCreatedAt(LocalDateTime.now());
        guildCommander.setUpdatedAt(LocalDateTime.now());
        guildCommanderRepository.save(guildCommander);
        return guildCommanderDto;
    }
}
