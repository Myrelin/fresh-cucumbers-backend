package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.controller.MovieController;
import com.codecool.freshcucumbersbackend.model.Movie;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class TopTenMovieLoaderTest {


    @Test
    void whenPopulateIsCalled_MoviesAreAddedToMovieStorage_V2() {
        MovieController movieController = Mockito.mock(MovieController.class);

        MovieStorage movieStorage = new MovieStorage();
        TopTenMovieLoader loader = new TopTenMovieLoader(movieStorage, movieController);

        List<String> titles = new LinkedList<>();
        when(movieController.searchApiByTitle(anyString())).thenAnswer(
                (Answer<Movie>) invocation -> {
                    Movie m = new Movie();
                    String title = invocation.getArgument(0);
                    m.setTitle(title);
                    titles.add(title);
                    return m;
            }
        );
        loader.populate();

        for (Movie movie : movieStorage.getMovies()) {
            assertTrue(titles.contains(movie.getTitle()));
        }
    }


    // whenDoingX_YShouldHappen
    @Test
    void whenPopulateIsCalled_MoviesAreAddedToMovieStorage_V1() {
        // 2 problems:
        // MovieStorage is not mocked -- use ArgumentCaptor!
        // Movie name is hardcoded; just tests for 1 movie! (solved in v2)
        MovieController movieController = Mockito.mock(MovieController.class);
        Movie movieIronMan = new Movie();
        movieIronMan.setTitle("Iron man");
        when(movieController.searchApiByTitle("Iron man"))
                .thenReturn(movieIronMan);

        MovieStorage movieStorage = new MovieStorage();
        TopTenMovieLoader loader = new TopTenMovieLoader(movieStorage, movieController);

        loader.populate();
        assertTrue(movieStorage.getMovies().contains(movieIronMan));
    }
}