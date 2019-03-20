package com.codecool.freshcucumbersbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Component
public class Movie {
    private String id;
    private String title;
    private String rating;
    private String plot;
}
