package com.example.repositoryfinder.app;

import com.example.repositoryfinder.model.Repo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppService {
    public AppService() {
    }

    public Map<String, Object> getRepositories(String username){
        Map<String, Object> repositories = new LinkedHashMap<>();
        repositories.put("Username",username);
        List<Repo> reposFromAPI = getFromExternalAPI(username);
        repositories.put("Stars","10");
        repositories.put("Repositories",reposFromAPI);

        return repositories;
    }

    private List<Repo> getFromExternalAPI(String username){
        List<Repo> repos = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://api.github.com/users/"+username+"/repos",String.class);
        repos.add(new Repo("XDDD",10));
        return repos;
    }
}
