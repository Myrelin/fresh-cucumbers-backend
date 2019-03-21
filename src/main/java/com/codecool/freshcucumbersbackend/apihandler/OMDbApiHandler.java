package com.codecool.freshcucumbersbackend.apihandler;

import com.codecool.freshcucumbersbackend.model.Movie;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor
@CrossOrigin
@Component
public class OMDbApiHandler {

    @Autowired
    RestTemplate restTemplate;

    private static final String key = "e3e4583e";
    private static final String apiUrl = "http://www.omdbapi.com/";


    public Movie getSearchedMovieByTitle(String search, RestTemplate restTemplate){
        String url = apiUrl + "?t=" + search + "&apikey=" + key;

        Movie movie = restTemplate
                .getForObject(url, Movie.class);
        return movie;
    }


}
