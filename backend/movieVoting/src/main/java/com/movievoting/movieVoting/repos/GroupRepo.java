package com.movievoting.movieVoting.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movievoting.movieVoting.entities.Group;
import com.movievoting.movieVoting.entities.User;

public interface GroupRepo extends JpaRepository<Group,Integer> {
	Optional<Group> findByCreatedBy(User user);
}
