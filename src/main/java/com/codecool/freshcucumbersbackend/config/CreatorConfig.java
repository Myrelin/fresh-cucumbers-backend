package com.codecool.freshcucumbersbackend.config;

import com.codecool.freshcucumbersbackend.service.MovieCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatorConfig {

    @Bean
    public MovieCreator creator() {
        return new MovieCreator();
    }
}
