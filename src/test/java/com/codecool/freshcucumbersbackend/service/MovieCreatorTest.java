package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.model.Movie;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MovieCreatorTest {

    @Test
    void createMovie() {
        String id = "1";
        String title = "TestTitle";
        String rating = "10";
        String plot = "This is a plot";
        String poster = "www.reddit.com";
        MovieCreator movieCreator = Mockito.mock(MovieCreator.class);
        Movie movie = new Movie(id, title, rating, plot, poster);

        when(movieCreator.createMovie(id, title, rating, plot, poster))
                .thenReturn(movie);
        assertEquals(movie, movieCreator.createMovie(id, title, rating, plot, poster));
    }



}