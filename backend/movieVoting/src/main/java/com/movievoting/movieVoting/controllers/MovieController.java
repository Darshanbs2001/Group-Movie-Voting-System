package com.movievoting.movieVoting.controllers;

import com.movievoting.movieVoting.dto.MovieDto;
import com.movievoting.movieVoting.services.MoviesServices;
import com.movievoting.movieVoting.utility.UtilityMethods;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MoviesServices ms;

    @Autowired
    UtilityMethods util;
    @PostMapping("/add")
    public ResponseEntity<MovieDto> addMoviesToGroups(@RequestBody @Valid MovieDto movieDto, @RequestParam("groupId")int groupId){//,@RequestParam("userId") int userId){
       return  ok(ms.addMovie(movieDto,util.returnId(),groupId));
    }
    @DeleteMapping("/remove")
    public ResponseEntity<MovieDto> removeMovie(@RequestParam(name="movieId") int movieId){
    	return ok(ms.removeMovie(movieId));
    }
}
