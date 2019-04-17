package com.codecool.freshcucumbersbackend.controller;

import com.codecool.freshcucumbersbackend.repository.MovieStorage;
import com.codecool.freshcucumbersbackend.service.OMDbApiHandler;
import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.repository.MovieRepository;

import com.codecool.freshcucumbersbackend.repository.ReviewRepository;
import com.codecool.freshcucumbersbackend.repository.ReviewStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    OMDbApiHandler omDbApiHandler;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReviewStorage reviewStorage;

    @Autowired
    MovieStorage movieStorage;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/index")
    public List<Movie> movies() {
/*        List<Movie> movies = movieRepository.findAll();
        List<Movie> top10Movies = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            top10Movies.add(movies.get(i));
        }
        System.out.println(movies.size());
        System.out.println(top10Movies.size());
        return top10Movies;*/
        return movieStorage.retrieveFirstTenMovies();
    }

    @RequestMapping(value = "/search")
    public List<Movie> searchApiByTitle(@RequestParam("title")String name){
        List<Movie> movies = new LinkedList<>();
        movies.add(omDbApiHandler.getSearchedMovieByTitle(name));
        return movies;
    }

    @GetMapping(value = "/movieDetails={id}")
    public Optional<Movie> getMovieDetails(@PathVariable("id") Long id) {
        return movieRepository.findById(id);
    }

    @RequestMapping(value = "/addreviewtomovie")
    public void addNewReviewToMovie(@RequestParam("id") Long id,
                                    @RequestParam("author") String author,
                                    @RequestParam("newreview") String review) {

        if (!reviewStorage.checkIfReviewInDb(author, id)) {

            reviewStorage.createNewReview(id, author, review);
            System.out.println("Review added to db!");
        }

    }
}


