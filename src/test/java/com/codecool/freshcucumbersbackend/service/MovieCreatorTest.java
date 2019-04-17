package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.entity.Review;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MovieCreatorTest {

    @Test
    void createMovie() {
        Long dbId = 0L;
        String id = "1";
        String title = "TestTitle";
        String rating = "10";
        String plot = "This is a plot";
        String poster = "www.reddit.com";
        Set<Review> review = new HashSet<>();
        MovieCreator movieCreator = Mockito.mock(MovieCreator.class);
        Movie movie = new Movie(dbId, id, title, rating, plot, poster, review);

        when(movieCreator.createMovie(id, title, rating, plot, poster, review))
                .thenReturn(movie);
        assertEquals(movie, movieCreator.createMovie(id, title, rating, plot, poster, review));
    }



}