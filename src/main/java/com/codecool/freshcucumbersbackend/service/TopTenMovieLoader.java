package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.apihandler.OMDbApiHandler;
import com.codecool.freshcucumbersbackend.controller.MovieController;
import com.codecool.freshcucumbersbackend.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@Service
public class TopTenMovieLoader {
    @Autowired
    MovieStorage movieStorage;

    @Autowired
    MovieController movieController;

    public void populate(){
        List<String> top10Movie = new LinkedList<>(Arrays.asList("The shawshank redemption","The Godfather", "The Godfather: part II", "The Dark Knight", "12 angry men",
                "Iron man","Schindler's List","The lord of the rings: The Return Of the king","Pulp Fiction","Fight Club"));

        for (int i = 0; i < top10Movie.size() ; i++) {
            Movie movie = movieController.searchApiByTitle(top10Movie.get(i));
            movieStorage.addTopTenMovies(movie);
        }
    }

//    public void populateTopTenMoviesList() {
//        movieStorage.addTopTenMovies(movieCreator.createMovie("tt0111161", "The Shawshank Redemption", "9.3", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"));
//        movieStorage.addTopTenMovies(movieCreator.createMovie("tt0068646", "The Godfather", "9.2", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"));
//        movieStorage.addTopTenMovies(movieCreator.createMovie("tt0071562", "The Godfather: Part II", "9.0", "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.", "https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"));
//        movieStorage.addTopTenMovies(movieCreator.createMovie("tt0468569", "The Dark Knight", "9.0", "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg"));
//        movieStorage.addTopTenMovies(movieCreator.createMovie("tt0050083", "12 Angry Men", "8.9", "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.", "https://m.media-amazon.com/images/M/MV5BMWU4N2FjNzYtNTVkNC00NzQ0LTg0MjAtYTJlMjFhNGUxZDFmXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_SX300.jpg"));
//        movieStorage.addTopTenMovies(movieCreator.createMovie("tt0371746", "Iron Man", "7.9", "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.", "https://m.media-amazon.com/images/M/MV5BMTczNTI2ODUwOF5BMl5BanBnXkFtZTcwMTU0NTIzMw@@._V1_SX300.jpg"));
//        movieStorage.addTopTenMovies(movieCreator.createMovie("tt0108052", "Schindler's List", "8.9", "In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazi Germans.", "https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg"));
//        movieStorage.addTopTenMovies(movieCreator.createMovie("tt0167260", "The Lord of the Rings: The Return of the King", "8.9", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"));
//        movieStorage.addTopTenMovies(movieCreator.createMovie("tt0110912", "Pulp Fiction", "8.9", "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"));
//        movieStorage.addTopTenMovies(movieCreator.createMovie("tt0137523", "Fight Club", "8.8", "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.", "https://m.media-amazon.com/images/M/MV5BMjJmYTNkNmItYjYyZC00MGUxLWJhNWMtZDY4Nzc1MDAwMzU5XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"));
//
//    }
}
