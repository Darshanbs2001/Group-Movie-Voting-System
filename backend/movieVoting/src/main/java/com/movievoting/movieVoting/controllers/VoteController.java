package com.movievoting.movieVoting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movievoting.movieVoting.dto.VoteDto;
import com.movievoting.movieVoting.entities.Vote;
import com.movievoting.movieVoting.services.VoteService;
import com.movievoting.movieVoting.utility.UtilityMethods;

import jakarta.validation.Valid;

@RestController
@RequestMapping("vote")
public class VoteController {
	@Autowired
	VoteService service;
	@Autowired
	UtilityMethods util;
	@PostMapping("movie")
	public ResponseEntity<Vote> addVote(@RequestBody @Valid VoteDto vote) {
         return ResponseEntity.ok(service.addVote(vote));
         
	}

	@PutMapping("/movie")
	public ResponseEntity<Vote> updateVote(/*@RequestParam(name="userId")int userId,*/
			         @RequestParam(name="groupId")int groupId,
			         @RequestParam(name="movieId") int movieId
			){
		return ResponseEntity.ok(service.update(util.returnId(), movieId, groupId));
	}
}
