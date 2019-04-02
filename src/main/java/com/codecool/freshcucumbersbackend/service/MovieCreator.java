package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.model.Movie;
import com.codecool.freshcucumbersbackend.model.ReviewResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@Builder
public class MovieCreator {

    public Movie createMovie(String id, String title, String rating, String plot, String poster, List<ReviewResult> review) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setRating(rating);
        movie.setTitle(title);
        movie.setPlot(plot);
        movie.setPoster(poster);
        movie.setReview(review);
        return movie;
    }
}
