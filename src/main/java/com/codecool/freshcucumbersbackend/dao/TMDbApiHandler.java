package com.codecool.freshcucumbersbackend.dao;

import com.codecool.freshcucumbersbackend.entity.ReviewResult;
import com.codecool.freshcucumbersbackend.model.TMDbMovieTest;
import com.codecool.freshcucumbersbackend.model.TMDbReview;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Data
public class TMDbApiHandler {

    @Autowired
    RestTemplate restTemplate;

    private static final String key = "82e3b9f440819e12df20a6ef6cc4f9a3";
    private static final String apiUrl = "https://api.themoviedb.org/3/";

    //https://api.themoviedb.org/3/find/{external_id}?api_key=<<api_key>>&language=en-US&external_source=imdb_id

    //https://api.themoviedb.org/3/movie/1726/reviews?api_key=82e3b9f440819e12df20a6ef6cc4f9a3&language=en-US&page=1

    public int getInternalMovieID(String imdbID) {
        String url = apiUrl + "find/" + imdbID + "?api_key=" + key + "&language=en-US&external_source=imdb_id";
        TMDbMovieTest tmDbMovieTest = restTemplate.getForObject(url, TMDbMovieTest.class);
        return tmDbMovieTest.getMovieResults().get(0).getId();
    }

    public List<ReviewResult> getMovieReviewByTMDbID(String tmdbID) {
        String url = apiUrl + "movie/" + tmdbID + "/reviews?api_key=" + key + "&language=en-US&page=1";
        TMDbReview review = restTemplate.getForObject(url, TMDbReview.class);
        return review.getReviewResults();
    }
}
