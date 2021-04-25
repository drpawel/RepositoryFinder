package com.example.repositoryfinder.model;

/**
 * Entity representing repository
 */
public class Repo {
    private final String repo_name;
    private final int stars_count;

    /**
     * Constructor of Repo
     * @param repo_name name of repository
     * @param stars_count number of stars in repository
     */
    public Repo(String repo_name, int stars_count) {
        this.repo_name = repo_name;
        this.stars_count = stars_count;
    }

    /**
     * Repo name getter
     * @return repo_name
     */
    public String getRepo_name() {
        return repo_name;
    }

    /**
     * Repo stars count getter
     * @return stars_count
     */
    public int getStars_count() {
        return stars_count;
    }
}
