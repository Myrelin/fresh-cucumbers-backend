package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.dao.OMDbApiHandler;
import com.codecool.freshcucumbersbackend.entity.Movie;
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

    static final List<String> TOP_10_MOVIE = new LinkedList<>(Arrays.asList("The shawshank redemption", "The Godfather", "The Godfather: part II", "The Dark Knight", "12 angry men",
            "Iron man", "Schindler's List", "The lord of the rings: The Return Of the king", "Pulp Fiction", "Fight Club"));

    public void populate() {

        for (int i = 0; i < TOP_10_MOVIE.size(); i++) {
            Movie movie = omDbApiHandler.getSearchedMovieByTitle(TOP_10_MOVIE.get(i));
            movieStorage.addTopTenMovies(movie);
        }
    }
}