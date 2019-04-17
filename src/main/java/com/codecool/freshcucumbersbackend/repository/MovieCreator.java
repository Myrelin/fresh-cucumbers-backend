package com.codecool.freshcucumbersbackend.repository;

import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.entity.Review;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Data
@NoArgsConstructor
@Builder
public class MovieCreator {

    public Movie createMovie(String id, String title, String rating, String plot, String poster, Set<Review> review) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setRating(rating);
        movie.setTitle(title);
        movie.setPlot(plot);
        movie.setPoster(poster);
        movie.setReviews(review);
        return movie;
    }
}
