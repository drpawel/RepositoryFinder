package com.example.repositoryfinder.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping(path = "/user/{username}", produces = "application/json")
    public Map<String, Object> message(@PathVariable String username){
        return appService.getRepositories(username);
    }
}
