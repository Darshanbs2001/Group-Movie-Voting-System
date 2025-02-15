package com.movievoting.movieVoting.services;

import com.movievoting.movieVoting.dto.VoteDto;
import com.movievoting.movieVoting.entities.Vote;

public interface VoteService {
    public Vote addVote(VoteDto vote);
    public Vote remove(int id);
    public Vote update(int userId,int movieId,int groupId);

}
