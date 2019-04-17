package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieStorage {

    @Autowired
    MovieRepository movieRepository;

    public boolean checkIfMovieSearchInDb(String imdbID) {

        List<Movie> moviesInDB = movieRepository.findAll();
        for (Movie movie:moviesInDB) {
            if(movie.getId().equals(imdbID)) {
                return true;
            }
        } return false;
    }

    public Movie retrieveMovieFromDbByTitle(String imdbID) {
        List<Movie> moviesInDb = movieRepository.findAll();
        for(Movie movie:moviesInDb) {
            if(movie.getId().equals(imdbID)) {
                return movie;
            }
        } return null;
    }
}
