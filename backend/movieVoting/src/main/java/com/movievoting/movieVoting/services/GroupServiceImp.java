package com.movievoting.movieVoting.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.movievoting.movieVoting.dto.GroupDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.Group;
import com.movievoting.movieVoting.entities.Movie;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.entities.Vote;
import com.movievoting.movieVoting.errors.GroupNotFoundException;
import com.movievoting.movieVoting.errors.UserNotFoundException;
import com.movievoting.movieVoting.repos.GroupRepo;
import com.movievoting.movieVoting.repos.UserRepo;
import com.movievoting.movieVoting.repos.VoteRepo;
import com.movievoting.movieVoting.response.MemberAddedSuccessfully;
import com.movievoting.movieVoting.security.JwtService;
import com.movievoting.movieVoting.utility.MovieWithVotes;

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
	@Autowired
	ModelMapper mapper;
	@Autowired
	JwtService jwts;

	@Override
	public GroupDto createGroup(GroupDto groupDto, int userId) {
		User user = ur.findById(userId).orElseThrow(() -> new UserNotFoundException());

		Group group = map.map(groupDto, Group.class);
		group.setInviteCode(UUID.randomUUID().toString());
		group.setCreatedBy(user);
		group.getMembers().add(user);
		user.getGroups().add(gr.save(group));
		ur.save(user);
		return map.map(group, GroupDto.class);
	}

	@Override
	public List<GroupDto> listOfGroupsByUser(int userId) {
		// TODO Auto-generated method stub
		// User user = ur.findById(userId).orElseThrow(() -> new
		// UserNotFoundException());
		return gr.findByCreatedBy(userId).stream().map(group -> map.map(group, GroupDto.class)).toList();

	}

	public void addToGroup(int userId, int groupId) {
		User user = ur.findById(userId).orElseThrow(() -> new UserNotFoundException());
		Group group = gr.findById(groupId).orElseThrow(() -> new UserNotFoundException());
		group.getMembers().add(user);
		user.getMemberOfGroups().add(group);
		gr.save(group);
		ur.save(user);

	}

	
	public List<GroupDto> listOfGroup() {
		return gr.findAll().stream().map(group -> map.map(group, GroupDto.class)).toList();

	}

	@Override
	public List<UserDto> listOfMembers(int id) {
		gr.findById(id).orElseThrow(() -> new GroupNotFoundException());
		return gr.memberOfGroup(id).stream().toList().stream().map((member) -> mapper.map(member, UserDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<MovieWithVotes> findMovieVote(int groupId, int userId) {
		List<MovieWithVotes> movieVotes = new ArrayList<>();
		boolean hasVoted = false;
		// gr.findById(groupId).orElseThrow(()->new GroupNotFoundException());
		if (gr.existsById(groupId)) {
			Group group = gr.findById(groupId).orElseThrow(() -> new GroupNotFoundException());
			List<Movie> movies = group.getMovies();
			System.out.println(movies);
			for (Movie movie : movies) {
				int count = 0;
				System.out.println(movie.getTitle());
				MovieWithVotes m = new MovieWithVotes();
				Set<Vote> votes = movie.getVotes();
				for (Vote vote : votes) {

					if (vote.isVote()) {
						count++;

					}

				}
				// count=vr.findTrueVotes(movie.getMovieId());

				m.setMovieId(movie.getMovieId());
				m.setDescription(movie.getDescription());
				m.setRating(movie.getRating());
				m.setTitle(movie.getTitle());
				m.setTmdbId(movie.getTmdbId());
				m.setVoteCount(count);
				movieVotes.add(m);

				for (Vote vote : votes) {
					if (vote.getUser().getUserId() == userId && count > 0) {
						hasVoted = true;
					}
					m.setHasVoted(hasVoted);
				}

			}
			System.out.println(movieVotes);
			return movieVotes;

		} else {
			throw new GroupNotFoundException();
		}

	}

	@Override
	public List<MovieWithVotes> getMovies(int groupId) {
		List<Movie> movies = gr.findById(groupId).orElseThrow(() -> new GroupNotFoundException()).getMovies();
		List<MovieWithVotes> votes = new ArrayList<>();
		long count = 0;
		for (Movie movie : movies) {
			count = vr.findTrueVotes(movie.getMovieId());
			MovieWithVotes m = new MovieWithVotes();
			m.setMovieId(movie.getMovieId());
			m.setTitle(movie.getTitle());
			m.setRating(movie.getRating());
			m.setDescription(movie.getDescription());
			m.setVoteCount((int) (count));
			// System.out.println(m.getTitle()+" votes= "+m.getVoteCount());
			votes.add(m);
		}
		return votes;
	}

	@Override
	public List<MovieWithVotes> findWinner(int groupId) {
		List<MovieWithVotes> movieWithVotes = this.getMovies(groupId);
		List<MovieWithVotes> winnerList = new ArrayList<>();
		int max = 0;
		for (MovieWithVotes movie : movieWithVotes) {
			if (movie.getVoteCount() > max) {
				System.out.println(movie.getTitle() + " votes= " + movie.getVoteCount());
				max = movie.getVoteCount();
			}
		}
		System.out.println("maximum votes= " + max);
		for (MovieWithVotes movie : movieWithVotes) {
			if (movie.getVoteCount() == max) {

				winnerList.add(movie);
			}
		}
		return winnerList;
	}

	@Override
	public MemberAddedSuccessfully addToGroupByCode(String code, int userId) {
		  User user=ur.findById(userId).orElseThrow(()->new UserNotFoundException());
	       Group group=gr.findByInviteCode(code).orElseThrow(()->new GroupNotFoundException());
	       group.getMembers().add(user);
	       user.getMemberOfGroups().add(group);
	       gr.save(group);
	       ur.save(user);
	       String userName=user.getName();
	       String groupName=group.getName();
	       
	       MemberAddedSuccessfully s= new MemberAddedSuccessfully();//(userId, userName, groupName, groupName);
	       return s;
	}

	public User returnId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null)
		{
			System.out.println(authentication.getPrincipal());
			String email=(String)authentication.getPrincipal();
			User user=ur.findByEmail(email).get();
			System.out.println(email);
			return user;
		}
		return null;
		
	}
	@Override
	public String leaveGroup(int groupId) {
        User user=this.returnId();
		if(user==null) {
			throw new UserNotFoundException();
		}
		else {
			Group group=gr.findById(groupId).orElseThrow(()->new GroupNotFoundException());
		     group.getMembers().remove(user);
		     user.getMemberOfGroups().remove(group);
		     gr.save(group);
		     ur.save(user);
		     return "user left the group";
		}
	}

}
