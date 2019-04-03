package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MovieStorage {

    private List<Movie> movies = new LinkedList<>();

    public void addTopTenMovies(Movie movie){
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }


}
