package com.codecool.freshcucumbersbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Component
@Entity
@ToString(exclude = "password")
public class UserEntity {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue
    private Long dbID;

    private String userName;

    private @JsonIgnore
    String password;

    @Singular
    @OneToMany(mappedBy = "userEntity", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    @JsonProperty("results")
    private Set<Review> reviews;

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    protected UserEntity() {
    }

    public UserEntity(String userName, String password) {
        this.setPassword(password);
        this.userName = userName;

    }


}
