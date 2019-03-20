package com.codecool.freshcucumbersbackend.controller;

import com.codecool.freshcucumbersbackend.model.Movie;
import com.codecool.freshcucumbersbackend.service.MovieStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {




    @Autowired
    private MovieStorage movieStorage;

    @GetMapping("/list")
    public List<Movie> movies() {
        return movieStorage.getMovies();
    }

    @GetMapping("/add")
    public Movie createMovie() {
        return movieStorage.addMovie();
    }

}


