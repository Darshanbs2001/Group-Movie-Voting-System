package com.movievoting.movieVoting.services;

import java.util.List;

import com.movievoting.movieVoting.dto.MovieDto;

public interface MoviesServices {
  public MovieDto addMovie(MovieDto movie, int userId,int groupId);
  public List<MovieDto> listMoviesByUserById(int id);
  public boolean removeMovie(int id);
}
