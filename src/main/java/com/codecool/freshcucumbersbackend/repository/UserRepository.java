package com.codecool.freshcucumbersbackend.repository;


import com.codecool.freshcucumbersbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
