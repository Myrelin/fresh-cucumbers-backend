package com.codecool.freshcucumbersbackend.config;
import com.codecool.freshcucumbersbackend.service.TMDbApiHandler;
import com.codecool.freshcucumbersbackend.entity.Review;
import com.codecool.freshcucumbersbackend.repository.MovieCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public MovieCreator creator() {
        return new MovieCreator();
    }

    @Bean
    public TMDbApiHandler tmDbApiHandler() {
        return new TMDbApiHandler();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Review reviewResult() {
        return new Review();
    }
}
