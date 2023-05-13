package com.movierating.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movierating.payload.MovieDto;
import com.movierating.service.MovieService;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

	private MovieService movieSer;

	public MovieController(MovieService movieSer) {
		super();
		this.movieSer = movieSer;
	}
	
	@PostMapping("/new-Movie")
	public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto){
		
		return new ResponseEntity<>(movieSer.createMovie(movieDto),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<MovieDto> getAllMovies(){
		return movieSer.getAllMovies();
	}
	
	@GetMapping("/longest-duration-movies")
	public List<MovieDto> getMoviesWithLongestRuntime(){
		return movieSer.getLongMovies();
	}
}
