package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.entity.Review;
import com.codecool.freshcucumbersbackend.model.TMDbMovie;
import com.codecool.freshcucumbersbackend.model.TMDbReview;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Data
@PropertySource(value = "application.properties")
public class TMDbApiHandler {

    @Autowired
    RestTemplate restTemplate;

    @Value(value = "${tmdbApiKey}")
    private String tmdbApiKey;
    @Value(value= "${tmdbApiUrl}")
    private String tmdbApiUrl;

/*    private static final String tmdbApiKey = "82e3b9f440819e12df20a6ef6cc4f9a3";
    private static final String tmdbApiUrl = "https://api.themoviedb.org/3/";*/


    public int getInternalMovieID(String imdbID) {
        String url = tmdbApiUrl + "find/" + imdbID + "?api_key=" + tmdbApiKey + "&language=en-US&external_source=imdb_id";
        TMDbMovie tmDbMovie = restTemplate.getForObject(url, TMDbMovie.class);
        return tmDbMovie.getMovieResults().get(0).getId();
    }

    public List<Review> getMovieReviewByTMDbID(String tmdbID) {
        String url = tmdbApiUrl + "movie/" + tmdbID + "/reviews?api_key=" + tmdbApiKey + "&language=en-US&page=1";
        TMDbReview review = restTemplate.getForObject(url, TMDbReview.class);
        return review.getReviews();
    }
}
