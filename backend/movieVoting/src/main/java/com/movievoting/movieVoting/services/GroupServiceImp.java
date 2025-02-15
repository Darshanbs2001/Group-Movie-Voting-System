package com.movievoting.movieVoting.services;

import java.util.*;

import com.movievoting.movieVoting.entities.Movie;
import com.movievoting.movieVoting.entities.Vote;
import com.movievoting.movieVoting.errors.GroupNotFoundException;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import com.movievoting.movieVoting.repos.VoteRepo;
import com.movievoting.movieVoting.utility.MovieWithVotes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movievoting.movieVoting.dto.GroupDto;
import com.movievoting.movieVoting.entities.Group;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.repos.GroupRepo;
import com.movievoting.movieVoting.repos.UserRepo;
@Service
public class GroupServiceImp implements GroupService {
     @Autowired
     GroupRepo gr;
     @Autowired
     UserRepo ur;	
     @Autowired
     ModelMapper map;
	 @Autowired
	VoteRepo vr;
	@Override
	public GroupDto createGroup(GroupDto groupDto,int userId) {
        User user=ur.findById(userId).orElseThrow(()-> new UserNotFoundException());

		Group group=map.map(groupDto, Group.class);
		group.setInviteCode(UUID.randomUUID().toString());
		group.setCreatedBy(user);
		group.getMembers().add(user);
		user.getGroups().add( gr.save(group));
		ur.save(user);
		return map.map(group, GroupDto.class);
	}

	@Override
	public List<GroupDto> listOfGroupsByUser(int userId) {
		// TODO Auto-generated method stub
		User user =ur.findById(userId).orElseThrow(()->new UserNotFoundException());
		return gr.findByCreatedBy(user).stream().map(group->map.map(group, GroupDto.class)).toList();
		
	}

	public void addToGroup(int userId,int groupId) {
		User user=ur.findById(userId).orElseThrow(()->new UserNotFoundException());
	    Group group=gr.findById(groupId).orElseThrow(()->new UserNotFoundException());
	    group.getMembers().add(user);
	    user.getMemberOfGroups().add(group);
	    gr.save(group);
	    ur.save(user);
	    
	}
	public List<GroupDto> listOfGroup(){
		return gr.findAll().stream().map(group->map.map(group, GroupDto.class)).toList();
	
	}
	@Override
	public List<User> listOfMembers(int id) {
		return gr.memberOfGroup(id);
	}
	public List<MovieWithVotes> findMovieVote(int groupId,int userId){
		List<MovieWithVotes> movieVotes=new ArrayList<>();
		boolean hasVoted=false;
		if(gr.existsById(groupId))
		{
			Group group=gr.findById(groupId).orElseThrow(()->new GroupNotFoundException());
			List<Movie> movies=group.getMovies();


			for(Movie movie: movies){
				int count=0;
				MovieWithVotes m=new MovieWithVotes();
				Set<Vote> votes=  movie.getVotes();
				for(Vote vote:votes){

					if(vote.isVote()){
						count++;

					}

				}
				//count=vr.findTrueVotes(movie.getMovieId());
				if(count>0){

					m.setMovieId(movie.getMovieId());
					m.setDescription(movie.getDescription());
					m.setRating(movie.getRating());
					m.setTitle(movie.getTitle());
					m.setTmdbId(movie.getTmdbId());
					m.setVoteCount(count);
					movieVotes.add(m);
				}
				for(Vote vote: votes){
					if(vote.getUser().getUserId()==userId&&count>0){
						hasVoted=true;
					}
					m.setHasVoted(hasVoted);
				}


			}
		}

		return movieVotes;
	}
	public List<MovieWithVotes> getMovies(int groupId){
		List<Movie> movies=gr.findById(groupId).orElseThrow(()->new GroupNotFoundException()).getMovies();
		List<MovieWithVotes> votes=new ArrayList<>();
		int count;
		for(Movie movie: movies){
		 	count=vr.findTrueVotes(movie.getMovieId());
			 MovieWithVotes m=new MovieWithVotes();
			 m.setMovieId(movie.getMovieId());
			 m.setTitle(movie.getTitle());
			 m.setRating(movie.getRating());
			 m.setDescription(movie.getDescription());
			 m.setVoteCount(count);
		}
		return votes;
	}
	public List<MovieWithVotes> findWinner(int groupId) throws Exception {
		List<MovieWithVotes> movieWithVotes=this.getMovies(groupId);
		List<MovieWithVotes> winnerList=new ArrayList<>();
		int max=0;
		for(MovieWithVotes movie: movieWithVotes){
			if(movie.getVoteCount()>max){
				winnerList.add(movie);
				max=movie.getVoteCount();
			}
		}
		return winnerList;
	}

}
