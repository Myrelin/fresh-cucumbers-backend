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
/*        "id",*/
        "results"
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TMDbReview {
/*
    @JsonProperty("id")
    public Integer id;*/
    @JsonProperty("results")
    public List<ReviewResult> reviewResults = null;

}