package com.codecool.freshcucumbersbackend.controller;

import com.codecool.freshcucumbersbackend.dao.OMDbApiHandler;
import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.repository.MovieRepository;
import com.codecool.freshcucumbersbackend.service.MovieStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    OMDbApiHandler omDbApiHandler;

    @Autowired
    MovieRepository movieRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/index")
    public List<Movie> movies() {
//        return movieStorage.getMovies();
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    @RequestMapping(value = "/search")
    public Movie searchApiByTitle(@RequestParam("title")String name){

        return omDbApiHandler.getSearchedMovieByTitle(name);
    }
}


