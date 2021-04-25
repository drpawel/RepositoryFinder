package com.example.repositoryfinder.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * RestController of the app
 */
@RestController
public class AppController {
    private final AppService appService;

    /**
     * AppController constructor
     * @param appService appService
     */
    public AppController(AppService appService) {
        this.appService = appService;
    }

    /**
     * Get repository list request method
     * @param username github username
     * @return list of repositories
     */
    @GetMapping(path = "/api/user/{username}", produces = "application/json")
    public Map<String, Object> message(@PathVariable String username){
        return appService.getRepositories(username);
    }
}
