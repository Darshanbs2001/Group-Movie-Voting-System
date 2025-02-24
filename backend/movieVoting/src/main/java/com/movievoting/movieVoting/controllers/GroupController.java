package com.movievoting.movieVoting.controllers;

import java.util.List;

import com.movievoting.movieVoting.dto.UserDto;
import com.movievoting.movieVoting.utility.MovieWithVotes;
import com.movievoting.movieVoting.utility.UtilityMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movievoting.movieVoting.dto.GroupDto;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.response.MemberAddedSuccessfully;
import com.movievoting.movieVoting.services.GroupService;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping("group")
@RestController
public class GroupController {
    @Autowired
    GroupService gs;

    @Autowired 
    UtilityMethods util;
    @PostMapping("/create")
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto groupDto){//, @RequestParam(name = "id", required = true) int userId) {
        System.out.println(groupDto.getName());

        return ok(gs.createGroup(groupDto, util.returnId()));
    }

    @GetMapping("/user-groups")
    public ResponseEntity<List<GroupDto>> getAll(){//@RequestParam(name = "id") int userId) {
        return ok(gs.listOfGroupsByUser(util.returnId()));
    }

    @PutMapping("/join")
    public ResponseEntity<String> joinGroup(@RequestParam(name = "groupId") int groupId, @RequestParam(name = "userId") int userId) {
        gs.addToGroup(userId, groupId);

        return ok("added the user");
    }
    @PutMapping("/joinByCode")
    public ResponseEntity<MemberAddedSuccessfully> joinGroup(/*@RequestParam(name="userId")int userId,*/@RequestParam(name = "inviteCode") String code)
    {
    	return ok(gs.addToGroupByCode(code, util.returnId()));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GroupDto>> getGroups() {
        return ok(gs.listOfGroup());
    }

    @GetMapping("/getmembers/group")
    public ResponseEntity<List<UserDto>> membersOfGroup(@RequestParam(name = "groupId") int groupId) {
        return ok(gs.listOfMembers(groupId));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieWithVotes>> getMovies(@RequestParam(name = "groupId") int groupId){//, @RequestParam(name = "userId") int userId) {
        return ok(gs.findMovieVote(groupId,util.returnId()));
    }
    @GetMapping("/results")
    public ResponseEntity<List<MovieWithVotes>> getWinner(@RequestParam(name = "groupId") int groupId){
        return ok(gs.findWinner(groupId));
    }
    @PutMapping("/leave")
    public ResponseEntity<String> leaveGroup(@RequestParam(name="groupId")int groupId){
    	return ok(gs.leaveGroup(groupId));
    }

   
}
