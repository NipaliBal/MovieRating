package com.movierating.service;

import java.util.List;

import com.movierating.payload.MovieDto;

public interface MovieService {
	MovieDto createMovie(MovieDto movieDto);
	
	List<MovieDto> getAllMovies();

	List<MovieDto> getLongMovies();

}
