package com.codecool.freshcucumbersbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Component
@Entity
public class User {


    @Id
    @GeneratedValue
    private Long dbID;


    @Singular
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    @JsonProperty("results")
    private Set<Review> reviews;
}
