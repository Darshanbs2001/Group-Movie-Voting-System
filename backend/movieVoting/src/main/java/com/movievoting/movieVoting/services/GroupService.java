package com.movievoting.movieVoting.services;

import java.util.List;

import com.movievoting.movieVoting.dto.GroupDto;
import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.response.MemberAddedSuccessfully;
import com.movievoting.movieVoting.utility.MovieWithVotes;

public interface GroupService {
public GroupDto createGroup(GroupDto groupDto,int userId);
public List<GroupDto> listOfGroupsByUser(int userId);
public void addToGroup(int userId,int groupId);
public List<GroupDto> listOfGroup();
public List<UserDto> listOfMembers(int id);

    List<MovieWithVotes> findMovieVote(int groupId, int userId);

    List<MovieWithVotes> getMovies(int groupId);

    List<MovieWithVotes> findWinner(int groupId) ;
	MemberAddedSuccessfully addToGroupByCode(String code, int userId);
	public String leaveGroup(int groupId);
}
