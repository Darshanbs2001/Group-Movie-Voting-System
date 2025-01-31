package com.movievoting.movieVoting.services;

import java.util.List;

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
	@Override
	public GroupDto createGroup(GroupDto groupDto,int userId) {
        User user=ur.findById(userId).get();
        Group group=map.map(groupDto, Group.class);
        group.setInviteCode("not done still");
        group.setCreatedBy(user);
        gr.save(group);
		return map.map(group, GroupDto.class);
	}

	@Override
	public List<GroupDto> listOfGroupsByUser(int userId) {
		// TODO Auto-generated method stub
		User user =ur.findById(userId).get();
		return gr.findByCreatedBy(user).stream().map(group->map.map(group, GroupDto.class)).toList();
		
	}

	public void addToGroup(int userId,int groupId) {
		User user=ur.findById(userId).get();	
	    Group group=gr.findById(groupId).get();
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
}
