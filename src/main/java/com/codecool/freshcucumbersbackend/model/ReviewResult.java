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
        "author",
        "content",
//        "id"
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResult {

    @JsonProperty("author")
    public String author;
    @JsonProperty("content")
    public String content;
//    @JsonProperty("id")
//    public String id;
}