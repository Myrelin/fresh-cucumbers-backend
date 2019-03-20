package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor

public class MovieCreator {

    public Movie createMovie() {
        Movie movie = new Movie();
        movie.setId("1");
        movie.setRating("8.9");
        movie.setTitle("Unfresh Cucumbers");
        return movie;
    }
}
