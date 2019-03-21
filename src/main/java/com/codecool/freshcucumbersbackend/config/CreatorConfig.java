package com.codecool.freshcucumbersbackend.config;

import com.codecool.freshcucumbersbackend.controller.MovieController;
import com.codecool.freshcucumbersbackend.service.MovieCreator;
import com.codecool.freshcucumbersbackend.service.MovieStorage;
import com.codecool.freshcucumbersbackend.service.TopTenMovieLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CreatorConfig {

    @Bean
    public MovieCreator creator() {
        return new MovieCreator();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
