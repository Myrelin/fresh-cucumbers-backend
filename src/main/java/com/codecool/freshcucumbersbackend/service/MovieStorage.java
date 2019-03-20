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

    @Autowired
    private MovieCreator movieCreator;

    public Movie addMovie() {
        Movie movie = movieCreator.createMovie();
        this.movies.add(movie);
        return movie;
    }

    public void addTopTenMovies(Movie movie){
        movies.add(movie);
    }

    public void populateMovieList(){

    }

    public List<Movie> getMovies() {
        return movies;
    }


}
