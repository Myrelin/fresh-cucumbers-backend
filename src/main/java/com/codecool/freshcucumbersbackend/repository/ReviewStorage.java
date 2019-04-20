package com.codecool.freshcucumbersbackend.repository;

import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewStorage {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public String createNewReview(Long movieId, String author, String review) {
        Movie movie = movieRepository.getOne(movieId);
        Review newReview = new Review();
        newReview.setMovie(movie);
        newReview.setAuthor(author);
        newReview.setContent(review);
        movie.addReviewToMovie(newReview);
        try {
            reviewRepository.save(newReview);
        }
        catch(Exception e) {
            return "Could not save the review.";
        }
        try {
            movieRepository.save(movie);
        }
        catch(Exception e) {
            return "Could not update the movie.";
        }
        return "Review saved.";
    }

    public boolean checkIfReviewInDb(String author, Long id) {
        List<Review> reviewsInDb = reviewRepository.findAll();
        for (Review review:reviewsInDb) {
            if(review.getAuthor().equals(author) && review.getMovie().getDbID().equals(id)) {
                return true;
            }
        } return false;
    }
}
