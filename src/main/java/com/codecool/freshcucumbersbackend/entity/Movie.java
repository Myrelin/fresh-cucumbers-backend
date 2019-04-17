package com.codecool.freshcucumbersbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Component
@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue
    private Long dbID;

    @JsonProperty("imdbID")
    private String id;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("imdbRating")
    private String rating;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Poster")
    private String poster;

    @Singular
    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    @JsonProperty("results")
    private Set<Review> reviews;

    public void addReviewToMovie(Review review) {
        this.getReviews().add(review);


    }
}
