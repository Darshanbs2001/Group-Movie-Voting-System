package com.movievoting.movieVoting.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movievoting.movieVoting.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
public Optional<User> findByEmail(String email);
}
