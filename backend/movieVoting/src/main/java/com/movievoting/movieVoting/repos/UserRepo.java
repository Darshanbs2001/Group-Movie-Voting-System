package com.movievoting.movieVoting.repos;

import com.movievoting.movieVoting.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
public Optional<User> findByEmail(String email);
}
