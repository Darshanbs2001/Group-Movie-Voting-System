package com.movievoting.movieVoting.repos;

import com.movievoting.movieVoting.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VoteRepo extends JpaRepository<Vote, Integer> {
    //where v.casted=true and v.movie.movieId=:id
    @Query("select count(v) from Vote v where v.vote=true and v.movie.movieId=:movieId")
    long findTrueVotes(@Param("movieId") int movieId);

    @Query("select v from Vote v where v.user.userId=:userId and v.movie.movieId=:movieId and v.group.groupId=:groupId")
    Optional<Vote> findByUserIdAndMovieIdAndGroupId(@Param("userId")int userId,@Param("movieId") int movieId,@Param("groupId") int groupId);

}
