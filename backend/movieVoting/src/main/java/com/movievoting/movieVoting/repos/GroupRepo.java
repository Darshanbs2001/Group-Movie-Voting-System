package com.movievoting.movieVoting.repos;

import com.movievoting.movieVoting.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group,Integer> {
}
