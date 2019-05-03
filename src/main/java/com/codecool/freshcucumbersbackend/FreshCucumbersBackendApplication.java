package com.codecool.freshcucumbersbackend;

import com.codecool.freshcucumbersbackend.service.TopTenMovieHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import javax.annotation.PostConstruct;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:auth0.properties")
})
public class FreshCucumbersBackendApplication {

    @Autowired
    private TopTenMovieHandler topTenMovieHandler;

    public static void main(String[] args) {
        SpringApplication.run(FreshCucumbersBackendApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        topTenMovieHandler.populate();

    }

}
