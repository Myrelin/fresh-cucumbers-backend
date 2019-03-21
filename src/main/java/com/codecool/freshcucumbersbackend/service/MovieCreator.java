package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@Builder
public class MovieCreator {

    public Movie createMovie(String id, String title, String rating, String plot, String poster) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setRating(rating);
        movie.setTitle(title);
        movie.setPlot(plot);
        movie.setPoster(poster);
        return movie;
    }
}
