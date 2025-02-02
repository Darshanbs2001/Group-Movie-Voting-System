package com.movievoting.movieVoting.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.movievoting.movieVoting.entities.Group;
import com.movievoting.movieVoting.entities.User;

public interface GroupRepo extends JpaRepository<Group,Integer> {
	Optional<Group> findByCreatedBy(User user);
	
	@Query("select u from Group g join g.members u where g.groupId=:gId")
	public List<User> memberOfGroup(@Param("gId") int id);
	
}
