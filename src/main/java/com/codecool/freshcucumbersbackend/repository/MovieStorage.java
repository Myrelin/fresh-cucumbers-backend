package com.codecool.freshcucumbersbackend.repository;

import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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

    public List<Movie> retrieveFirstTenMovies() {
        List<Movie> allMoviesInDb = movieRepository.findAll();
        List<Movie> top10Movies = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            top10Movies.add(allMoviesInDb.get(i));
        }
        System.out.println(allMoviesInDb.size());
        System.out.println(top10Movies.size());
        return top10Movies;
    }
}
