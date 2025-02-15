package com.movievoting.movieVoting.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movievoting.movieVoting.entities.Group;
import com.movievoting.movieVoting.entities.Movie;
import com.movievoting.movieVoting.entities.User;

public interface MovieRepo extends JpaRepository<Movie,Integer> {
	public List<Movie> findAllByUser( User user);
	public List<Movie> findAllByGroup(Group group);

}
