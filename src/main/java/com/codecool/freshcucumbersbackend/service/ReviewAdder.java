package com.codecool.freshcucumbersbackend.service;

import com.codecool.freshcucumbersbackend.repository.MovieRepository;
import com.codecool.freshcucumbersbackend.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewAdder {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;
}
