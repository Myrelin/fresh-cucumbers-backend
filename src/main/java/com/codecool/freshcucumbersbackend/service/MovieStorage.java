package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.ConstructorProperties;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class MovieStorage {

    private List<Movie> movies = new LinkedList<>();

/*    @Autowired
    private MovieCreator movieCreator;

    public Movie addMovie(String id, String title, String rating, String plot, String poster) {
        Movie movie = movieCreator.createMovie(id, title, rating, plot, poster );
        this.movies.add(movie);
        return movie;
    }*/

    public void addTopTenMovies(Movie movie){
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }


}
