package com.movievoting.movieVoting.services;

import java.util.List;

import com.movievoting.movieVoting.dto.GroupDto;
import com.movievoting.movieVoting.entities.User;

public interface GroupService {
public GroupDto createGroup(GroupDto groupDto,int userId);
public List<GroupDto> listOfGroupsByUser(int userId);
public void addToGroup(int userId,int groupId);
public List<GroupDto> listOfGroup();
public List<User> listOfMembers(int id);
}
