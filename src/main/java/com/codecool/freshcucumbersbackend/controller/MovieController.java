package com.codecool.freshcucumbersbackend.controller;

import com.codecool.freshcucumbersbackend.entity.Review;
import com.codecool.freshcucumbersbackend.repository.MovieStorage;
import com.codecool.freshcucumbersbackend.service.OMDbApiHandler;
import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.repository.MovieRepository;

import com.codecool.freshcucumbersbackend.repository.ReviewRepository;
import com.codecool.freshcucumbersbackend.repository.ReviewStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


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
        return movieStorage.retrieveFirstTenMovies();
    }

    @RequestMapping(value = "/search")
    public List<Movie> searchApiByTitle(@RequestParam("title")String name){
        List<Movie> movies = new LinkedList<>();
        movies.add(omDbApiHandler.getSearchedMovieByTitle(name));
        return movies;
    }

    @GetMapping(value = "/movieDetails")
    public Optional<Movie> getMovieDetails(@RequestParam("dbID") Long id) {
        return movieRepository.findById(id);
    }

    /**
        Add new reviews to a selected movie. Return depends on save outcome.
        Possible values:
            Review already in DB: "Review already in the DB."
            Could not save the review itself: "Could not save the review."
            Could not update the movie object: "Could not update the movie."
            Success: "Review saved."
        @params: id, author, newreview
        @returns: String
     */

    //void method is a-okay!
    @RequestMapping(value = "/addreviewtomovie")
    public String addNewReviewToMovie(@RequestParam("id") Long id,
                                    @RequestParam("author") String author,
                                    @RequestParam("newreview") String review) {

        if (!reviewStorage.checkIfReviewInDb(author, id)) {
            String result = reviewStorage.createNewReview(id, author, review);
            System.out.println(result);
            return result;
        }
        String message = "Review already in the DB.";
        System.out.println(message);
        return message;
    }

    @RequestMapping(value = "/testing")
    public void testingVoidReturn() {
        String test = "";
        test.charAt(3);
    }
}


