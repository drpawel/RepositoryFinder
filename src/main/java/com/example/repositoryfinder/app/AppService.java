package com.example.repositoryfinder.app;

import com.example.repositoryfinder.exception.UserNotFoundException;
import com.example.repositoryfinder.model.Repo;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppService {
    public AppService() {
    }

    public Map<String, Object> getRepositories(String username){
        Map<String, Object> repositories = new LinkedHashMap<>();
        repositories.put("username",username);
        List<Repo> reposFromAPI = getFromExternalAPI(username);
        if (reposFromAPI != null) {
            repositories.put("total_stars",reposFromAPI.stream().map(Repo::getStars_count).reduce(0,Integer::sum));
        }
        repositories.put("repositories",reposFromAPI);
        return repositories;
    }

    private List<Repo> getFromExternalAPI(String username){
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<JsonNode[]> responseEntity =
                    restTemplate.getForEntity(String.format("https://api.github.com/users/%s/repos", username)
                            ,JsonNode[].class);
            JsonNode[] objects = responseEntity.getBody();
            if(objects!=null){
                return Arrays.stream(objects)
                        .map(x-> new Repo(x.get("name").asText(),x.get("stargazers_count").asInt()))
                        .collect(Collectors.toList());
            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new UserNotFoundException();
        }
    }
}
