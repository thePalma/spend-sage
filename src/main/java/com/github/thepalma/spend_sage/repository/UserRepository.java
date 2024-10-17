package com.github.thepalma.spend_sage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.thepalma.spend_sage.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

}
