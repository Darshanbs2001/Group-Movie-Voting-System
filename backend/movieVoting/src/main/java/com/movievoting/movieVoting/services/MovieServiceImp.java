package com.movievoting.movieVoting.services;

import java.util.List;

import com.movievoting.movieVoting.errors.GroupNotFoundException;
import com.movievoting.movieVoting.errors.MovieNotFoundException;
import com.movievoting.movieVoting.errors.UserNotFoundException;

import org.apache.catalina.startup.UserConfig;
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
          Group group= gr.findById(groupId).orElseThrow(()->new GroupNotFoundException());
          User user =ur.findById(userId).orElseThrow(()->new UserNotFoundException());
          Movie movie=map.map(moviedto, Movie.class);
          movie.setGroup(group);
          movie.setUser(user);
          mr.save(movie);
          group.getMovies().add(movie);
          gr.save(group);
          user.getMovies().add(movie);
          ur.save(user);
         
		return map.map(movie, MovieDto.class);
	}


	@Override
	public List<MovieDto> listMoviesByUserById(int id) {
		// TODO Auto-generated method stub
		 User user=ur.findById(id).get();
		 return mr.findAllByUser(user).stream().map(movie->map.map(movie, MovieDto.class)).toList();
	}

	@Override
	public MovieDto removeMovie(int id) {
		
		Movie movie=mr.findById(id).orElseThrow(()->new MovieNotFoundException());
		mr.delete(movie);
		MovieDto copy=new MovieDto();
		copy.setMovieId(movie.getMovieId());
		copy.setTmdbId(movie.getTmdbId());
		copy.setRating(movie.getRating());
		copy.setCustomNotes(movie.getCustomNotes());
		copy.setDescription(movie.getDescription());
		copy.setTitle(movie.getTitle());
		return copy;
		
	}
}
