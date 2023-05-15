package com.movierating.services;

import java.util.List;

import com.movierating.payload.MovieDto;

public interface MovieServices {

	MovieDto createMovie(MovieDto movieDto);
	
	List<MovieDto> getAllMovies();
	
	MovieDto getMovieById(long id);
	
	public List<MovieDto> getLongestMovie(long runtimeMinutes);
}
