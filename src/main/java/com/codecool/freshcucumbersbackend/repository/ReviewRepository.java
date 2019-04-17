package com.codecool.freshcucumbersbackend.repository;

import com.codecool.freshcucumbersbackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
