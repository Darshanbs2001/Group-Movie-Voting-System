package com.movievoting.movieVoting.services;

import com.movievoting.movieVoting.dto.VoteDto;
import com.movievoting.movieVoting.entities.Movie;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.entities.Vote;
import com.movievoting.movieVoting.errors.MovieNotFoundException;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import com.movievoting.movieVoting.errors.VoteNotFoundException;
import com.movievoting.movieVoting.repos.MovieRepo;
import com.movievoting.movieVoting.repos.UserRepo;
import com.movievoting.movieVoting.repos.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VoteServiceImp implements VoteService {

    @Autowired
    VoteRepo vr;
    @Autowired
    UserRepo ur;
    @Autowired
    MovieRepo mr;
    @Override
    public Vote addVote(VoteDto vote) {
        Vote saveVote = new Vote();
        if (!this.findVoteByUserIdAndMovieId(vote.getUserId(),vote.getMovieId())) {
            User user=ur.findById(vote.getUserId()).orElseThrow(()->new UserNotFoundException());
            Movie movie=mr.findById(vote.getMovieId()).orElseThrow(()->new MovieNotFoundException());
            saveVote.setUser(user);
            saveVote.setVote(true);
            saveVote.setMovie(movie);
            movie.getVotes().add(saveVote);
            saveVote=vr.save(saveVote);
            mr.save(movie);
        }
        else {
        	//throw an error here
        }
        return saveVote;
    }

    @Override
    public Vote remove(int id) {
        Vote vote=vr.findById(id).orElseThrow(()->new VoteNotFoundException());
        vr.delete(vote);
        return vote;
    }

    @Override
    public Vote update(int userId,int groupId,int movieId) {
        Vote v=vr.findByUserIdAndMovieIdAndGroupId(userId,movieId,groupId).orElseThrow(()->new VoteNotFoundException());
        v.setVote(!v.isVote());
        vr.save(v);
        return v;
    }
    public boolean findVoteByUserIdAndMovieId(int userId, int movieId){
        Movie movie=mr.findById(movieId).orElseThrow(()->new MovieNotFoundException());
        for(Vote vote: movie.getVotes()){
           if(vote.getUser().getUserId()==userId){
               return true;
           }
        }
        return false;
    }
}
