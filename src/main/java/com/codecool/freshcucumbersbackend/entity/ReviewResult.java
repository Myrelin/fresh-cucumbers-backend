package com.codecool.freshcucumbersbackend.entity;

import com.codecool.freshcucumbersbackend.entity.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "author",
        "content",
//        "id"
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ReviewResult {

    @Id
    @GeneratedValue
    private Long dbID;

    @JsonProperty("author")
    public String author;

    @JsonProperty("content")
    @Lob
    @Column
    public String content;

    @JsonIgnore
    @ManyToOne
    private Movie movie;
}