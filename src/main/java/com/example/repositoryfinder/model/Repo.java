package com.example.repositoryfinder.model;

public class Repo {
    private String repo_name;
    private int stars_count;

    public Repo(String repo_name, int stars_count) {
        this.repo_name = repo_name;
        this.stars_count = stars_count;
    }

    public String getRepo_name() {
        return repo_name;
    }

    public int getStars_count() {
        return stars_count;
    }
}
