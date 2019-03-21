package com.codecool.freshcucumbersbackend.controller;

import com.codecool.freshcucumbersbackend.apihandler.OMDbApiHandler;
import com.codecool.freshcucumbersbackend.model.Movie;
import com.codecool.freshcucumbersbackend.service.MovieStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    OMDbApiHandler omDbApiHandler;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private MovieStorage movieStorage;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/index")
    public List<Movie> movies() {
        return movieStorage.getMovies();
    }

    @RequestMapping(value = "/search")
    public Movie searchApiByTitle(@RequestParam("title")String name){

        return omDbApiHandler.getSearchedMovieByTitle(name, restTemplate);
    }
}


