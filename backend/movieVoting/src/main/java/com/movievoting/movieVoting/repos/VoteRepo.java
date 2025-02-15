package com.movievoting.movieVoting.repos;

import com.movievoting.movieVoting.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VoteRepo extends JpaRepository<Vote, Integer> {
    @Query("select count(v) from Vote v where v.casted=true and v.movie.movieId=:id")
    int findTrueVotes(int id);
    @Query("select v from Vote v where v.casted=false")
    List<Vote> findFalseVotes();
    @Query("select v from Vote v where v.user.userId=:userId and v.movie.movieId=:movieId and v.group.groupId=:groupId")
    Optional<Vote> findByUserIdAndMovieIdAndGroupId(int userId,int movieId,int groupId);

}
