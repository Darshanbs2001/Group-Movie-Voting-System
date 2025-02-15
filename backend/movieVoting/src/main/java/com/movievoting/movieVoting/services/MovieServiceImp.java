package com.movievoting.movieVoting.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movievoting.movieVoting.dto.MovieDto;
import com.movievoting.movieVoting.entities.Group;
import com.movievoting.movieVoting.entities.Movie;
import com.movievoting.movieVoting.entities.User;
import com.movievoting.movieVoting.repos.GroupRepo;
import com.movievoting.movieVoting.repos.MovieRepo;
import com.movievoting.movieVoting.repos.UserRepo;
@Service
public class MovieServiceImp implements MoviesServices {

	@Autowired
	 MovieRepo mr;
	@Autowired
	 GroupRepo gr;
	@Autowired
	 UserRepo ur;
	@Autowired
	 ModelMapper map;
	@Override
	public MovieDto addMovie(MovieDto moviedto,int userId,int groupId) {
          Group group= gr.findById(groupId).get();
          User user =ur.findById(userId).get();
          Movie movie=map.map(moviedto, Movie.class);
          movie.setGroup(group);
          movie.setUser(user);
          mr.save(movie);
          
		return map.map(movie, MovieDto.class);
	}

	@Override
	public List<MovieDto> listMoviesByUserById(int id) {
		// TODO Auto-generated method stub
		 User user=ur.findById(id).get();
		 return mr.findAllByUser(user).stream().map(movie->map.map(movie, MovieDto.class)).toList();
	}

	@Override
	public boolean removeMovie(int id) {
		if(mr.existsById(id)) {
			mr.deleteById(id);
			return true;
		}
		return false;
	}
}
