package com.codecool.freshcucumbersbackend.dao;

import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.entity.Review;
import com.codecool.freshcucumbersbackend.repository.MovieRepository;
import com.codecool.freshcucumbersbackend.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewHandler {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public void createNewReview(Long movieId, String author, String review) {
        Movie movie = movieRepository.getOne(movieId);
        Review newReview = new Review();
        newReview.setMovie(movie);
        newReview.setAuthor(author);
        newReview.setContent(review);
        movie.addReviewToMovie(newReview);
        reviewRepository.save(newReview);
        movieRepository.save(movie);
    }
}
