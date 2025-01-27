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
}
