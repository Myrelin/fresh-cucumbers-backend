package com.codecool.freshcucumbersbackend.dao;

import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.entity.ReviewResult;
import com.codecool.freshcucumbersbackend.repository.MovieRepository;
import com.codecool.freshcucumbersbackend.repository.ReviewResultRepository;
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
    ReviewResultRepository reviewResultRepository;

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
//        System.out.println(imdbID);
        String tmdbID = String.valueOf(tmDbApiHandler.getInternalMovieID(imdbID));
//        System.out.println(tmdbID);
        List<ReviewResult> reviews = tmDbApiHandler.getMovieReviewByTMDbID(tmdbID);
//        System.out.println(reviews);
        Set<ReviewResult> reviewResults = new HashSet<>(reviews);
//        System.out.println(reviewResults);
        movie.setReviews(reviewResults);
        movieRepository.save(movie);
        System.out.println(movie);
        return movie;
    }


}
