package com.codecool.freshcucumbersbackend;

import com.codecool.freshcucumbersbackend.controller.MovieController;
import com.codecool.freshcucumbersbackend.model.Movie;
import com.codecool.freshcucumbersbackend.model.TMDbMovieTest;
import com.codecool.freshcucumbersbackend.model.TMDbReview;
import com.codecool.freshcucumbersbackend.service.MovieCreator;
import com.codecool.freshcucumbersbackend.service.MovieStorage;
import com.codecool.freshcucumbersbackend.service.TopTenMovieLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FreshCucumbersBackendApplication {

    @Autowired
    private TopTenMovieLoader topTenMovieLoader;

    public static void main(String[] args) {
        SpringApplication.run(FreshCucumbersBackendApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        topTenMovieLoader.populate();

    }

}
