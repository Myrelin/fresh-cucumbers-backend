package com.codecool.freshcucumbersbackend.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "video",
        "vote_count",
        "vote_average",
        "title",
        "release_date",
        "original_language",
        "original_title",
        "genre_ids",
        "backdrop_path",
        "adult",
        "overview",
        "poster_path",
        "popularity"
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResult {

    @JsonProperty("id")
    private Integer id;

}