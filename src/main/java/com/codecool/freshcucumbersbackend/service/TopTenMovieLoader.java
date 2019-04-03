package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.dao.OMDbApiHandler;
import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.entity.ReviewResult;
import com.codecool.freshcucumbersbackend.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@Service
public class TopTenMovieLoader {
    @Autowired
    MovieStorage movieStorage;

    @Autowired
    OMDbApiHandler omDbApiHandler;

    @Autowired
    MovieRepository movieRepository;

    static final List<String> TOP_10_MOVIE = new LinkedList<>(Arrays.asList("The shawshank redemption", "The Godfather", "The Godfather: part II", "The Dark Knight", "12 angry men",
            "Iron man", "Schindler's List", "The lord of the rings: The Return Of the king", "Pulp Fiction", "Fight Club"));

    public void populate() {

        for (int i = 0; i < TOP_10_MOVIE.size(); i++) {
            Movie movie = omDbApiHandler.getSearchedMovieByTitle(TOP_10_MOVIE.get(i));
//            movieRepository.save(movie);
            System.out.println("saving to db");
//            movieStorage.addTopTenMovies(movie);movieStorage.addTopTenMovies(movie);
        }
        System.out.println("sss");

    }
}