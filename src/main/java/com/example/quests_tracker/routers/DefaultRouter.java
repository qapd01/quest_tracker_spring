package com.example.quests_tracker.routers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultRouter {
    @GetMapping("/")
    public String healthCheck() {
        return "OK";
    }
}
