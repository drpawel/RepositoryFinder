package com.example.repositoryfinder.app;

import com.example.repositoryfinder.model.Repo;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * AppService
 */
@Service
public class AppService {

    /**
     * Get list of repositories function
     */
    public Map<String, Object> getRepositories(String username){
        Map<String, Object> repositories = new LinkedHashMap<>();
        Optional<List<Repo>> tmp = getFromExternalAPI(username);
        if(tmp.isPresent()){
            List<Repo> reposFromAPI = tmp.get();
            repositories.put("username",username);
            repositories.put("total_stars",reposFromAPI.stream().map(Repo::getStars_count).reduce(0,Integer::sum));
            repositories.put("repositories",reposFromAPI);
        }else{
            repositories.put("message","user not found");
        }
        return repositories;
    }

    /**
     * Get repositories from external GitHub API
     * @param username github repositories
     * @return list of repositories
     */
    private Optional<List<Repo>> getFromExternalAPI(String username){
        List<Repo> repos = null;
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JsonNode[]> responseEntity =
                    restTemplate.getForEntity(String.format("https://api.github.com/users/%s/repos", username)
                            ,JsonNode[].class);
            JsonNode[] objects = responseEntity.getBody();
            repos = Arrays.stream(Objects.requireNonNull(objects))
                    .map(x-> new Repo(x.get("name").asText(),x.get("stargazers_count").asInt()))
                    .collect(Collectors.toList());
        }catch (Exception e){}
        return Optional.ofNullable(repos);
    }
}
