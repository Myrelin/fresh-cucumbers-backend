package com.codecool.freshcucumbersbackend.controller;

import com.codecool.freshcucumbersbackend.apihandler.OMDbApiHandler;
import com.codecool.freshcucumbersbackend.model.Movie;
import com.codecool.freshcucumbersbackend.service.MovieStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    OMDbApiHandler omDbApiHandler;

    @Autowired
    private MovieStorage movieStorage;

    @GetMapping("/index")
    public List<Movie> movies() {
        populate();
        return movieStorage.getMovies();
    }

    @RequestMapping(value = "/search")
    public Movie SearchApiByTitle(@RequestParam("title")String name){

        return omDbApiHandler.getSearchedMovieByTitle(name);
    }

    public void populate(){
        List<String> top10Movie = new LinkedList<>(Arrays.asList("The shawshank redemption","The Godfather", "The Godfather: part II", "The Dark Knight", "12 angry men",
                "Iron man","Schindler's List","The lord of the rings: The Return Of the king","Pulp Fiction","Fight Club"));

        for (int i = 0; i < top10Movie.size() ; i++) {
            Movie movie = SearchApiByTitle(top10Movie.get(i));
            movieStorage.addTopTenMovies(movie);
        }
    }


}


