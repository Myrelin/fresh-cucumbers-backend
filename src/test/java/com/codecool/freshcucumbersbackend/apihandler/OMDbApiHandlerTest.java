package com.codecool.freshcucumbersbackend.apihandler;

import com.codecool.freshcucumbersbackend.model.Movie;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class OMDbApiHandlerTest {

    @Test
    void testInvalidUrlResponse() {
/*
        String search = "aaaa";
        OMDbApiHandler omDbApiHandler = new OMDbApiHandler();
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        String url = "";
        Movie movie = restTemplate
                .getForObject(url, Movie.class);

        when(omDbApiHandler.getSearchedMovieByTitle(search))
                .thenThrow(MalformedURLException.class);
        assertThrows(MalformedURLException.class, () ->omDbApiHandler.getSearchedMovieByTitle(search));
*/



    }
}