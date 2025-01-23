package com.movievoting.movieVoting.repos;

import com.movievoting.movieVoting.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie,Integer> {
}
