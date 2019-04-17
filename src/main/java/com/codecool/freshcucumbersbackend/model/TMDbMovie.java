package com.codecool.freshcucumbersbackend.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "movie_results"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TMDbMovie {

    @JsonProperty("movie_results")
    private List<MovieResult> movieResults = null;
}