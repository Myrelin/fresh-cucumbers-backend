package com.codecool.freshcucumbersbackend.controller;

import com.codecool.freshcucumbersbackend.dao.OMDbApiHandler;
import com.codecool.freshcucumbersbackend.entity.Movie;
import com.codecool.freshcucumbersbackend.repository.MovieRepository;

import com.codecool.freshcucumbersbackend.repository.ReviewRepository;
import com.codecool.freshcucumbersbackend.dao.ReviewHandler;
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
    ReviewHandler reviewHandler;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/index")
    public List<Movie> movies() {
//        return movieStorage.getMovies();
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    @RequestMapping(value = "/search")
    public List<Movie> searchApiByTitle(@RequestParam("title")String name){
        List<Movie> movies = new LinkedList<>();
        movies.add(omDbApiHandler.getSearchedMovieByTitle(name));
        return movies;
    }

    @GetMapping(value = "/movieDetails={id}")
    public Optional<Movie> getMovieDetails(@PathVariable("id") Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie;
    }

    @RequestMapping(value = "/addreviewtomovie")
    public void addNewReviewToMovie(@RequestParam("id") Long id,
                                    @RequestParam("author") String author,
                                    @RequestParam("newreview") String review) {

        reviewHandler.createNewReview(id, author, review);

/*        Movie movie = movieRepository.getOne(id);
        System.out.println(movie);
        Review newReview = new Review();
        newReview.setMovie(movie);
        newReview.setAuthor(author);
        newReview.setContent(review);
        movie.addReviewToMovie(newReview);
        reviewRepository.save(newReview);
        movieRepository.save(movie);*/


    }
}


