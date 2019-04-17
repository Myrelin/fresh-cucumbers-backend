package com.codecool.freshcucumbersbackend.dao;

import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.entity.Review;
import com.codecool.freshcucumbersbackend.repository.MovieRepository;
import com.codecool.freshcucumbersbackend.repository.ReviewRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@CrossOrigin
@Component
public class OMDbApiHandler {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TMDbApiHandler tmDbApiHandler;

    private static final String key = "e3e4583e";
    private static final String apiUrl = "http://www.omdbapi.com/";

    //DAO level
    public Movie getSearchedMovieByTitle(String search){

        String url = apiUrl + "?t=" + search + "&apikey=" + key;

        Movie movie = restTemplate
                .getForObject(url, Movie.class);
        String imdbID = movie.getId();

        String tmdbID = String.valueOf(tmDbApiHandler.getInternalMovieID(imdbID));

        List<Review> reviews = tmDbApiHandler.getMovieReviewByTMDbID(tmdbID);

        Set<Review> reviewResults = new HashSet<>(reviews);

        for (Review review:reviewResults) {
            review.setMovie(movie);
        }

        movie.setReviews(reviewResults);
        movieRepository.save(movie);
//        System.out.println(movie);
        return movie;
    }


}
