package com.codecool.freshcucumbersbackend;

import com.codecool.freshcucumbersbackend.model.Movie;
import com.codecool.freshcucumbersbackend.service.MovieCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FreshCucumbersBackendApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootApplication.class);

    @Autowired
    private MovieCreator movieCreator;

    public static void main(String[] args) {
        SpringApplication.run(FreshCucumbersBackendApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        LOGGER.info(movieCreator.createMovie().toString());

    }

}
