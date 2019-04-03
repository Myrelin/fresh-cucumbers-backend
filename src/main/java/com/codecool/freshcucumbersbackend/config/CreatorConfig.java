package com.codecool.freshcucumbersbackend.config;
import com.codecool.freshcucumbersbackend.dao.TMDbApiHandler;
import com.codecool.freshcucumbersbackend.entity.ReviewResult;
import com.codecool.freshcucumbersbackend.model.TMDbReview;
import com.codecool.freshcucumbersbackend.service.MovieCreator;
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
    public TMDbApiHandler tmDbApiHandler() {
        return new TMDbApiHandler();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ReviewResult reviewResult() {
        return new ReviewResult();
    }
}
