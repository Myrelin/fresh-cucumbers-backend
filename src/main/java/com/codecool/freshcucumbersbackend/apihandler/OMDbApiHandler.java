package com.codecool.freshcucumbersbackend.apihandler;

import com.codecool.freshcucumbersbackend.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;

@Component
public class OMDbApiHandler {

    private static final String key = "e3e4583e";
    private static final String apiUrl = "http://www.omdbapi.com/";


    public Movie getSearchedMovieByTitle(String search){
        String url = apiUrl + "?t=" + search + "&apikey=" + key;

        RestTemplate restTemplate = new RestTemplate();
        Movie movie = restTemplate
                .getForObject(url, Movie.class);
        return movie;
    }


}
