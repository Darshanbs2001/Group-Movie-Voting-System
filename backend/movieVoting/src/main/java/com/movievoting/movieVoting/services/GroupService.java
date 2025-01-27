package com.movievoting.movieVoting.services;

import java.util.List;

import com.movievoting.movieVoting.dto.GroupDto;

public interface GroupService {
public GroupDto createGroup(GroupDto groupDto,int userId);
public List<GroupDto> listOfGroupsByUser(int userId);
}
