package com.movievoting.movieVoting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movievoting.movieVoting.dto.GroupDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.services.GroupService;
@RequestMapping("group")
@RestController
public class GroupController {
  @Autowired
  GroupService gs;
  @PostMapping("/create/userId")
  public ResponseEntity<GroupDto> createGroup(@RequestBody  GroupDto groupDto,@RequestParam(name="id",required = true) int userId) {
	  System.out.println(groupDto.getName());

	  return ResponseEntity.ok(gs.createGroup(groupDto, userId));
  }
  @GetMapping("/list")
  public ResponseEntity<List<GroupDto>> getAll(@RequestParam(name="id")int userId){
	  return ResponseEntity.ok(gs.listOfGroupsByUser(userId));	
  }
  @PostMapping("/join/groupId/userId")
  public ResponseEntity<String> joinGroup(@RequestParam(name="groupId") int groupId,@RequestParam(name="userId") int userId){
	  gs.addToGroup(userId, groupId);
	  
	  return ResponseEntity.ok("added the user");
  }
  @GetMapping("/getAll")
  public ResponseEntity<List<GroupDto>> getGroups(){
	  return ResponseEntity.ok(gs.listOfGroup());
  }
  @PostMapping("/getmembers/group/")
  public ResponseEntity<List<User>> membersOfGroup(@RequestParam(name = "groupId") int groupId){
	  return ResponseEntity.ok(gs.listOfMembers(groupId));
  }
  
  
}
