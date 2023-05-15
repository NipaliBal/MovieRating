package com.movierating.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movierating.entity.Movie;
import com.movierating.payload.MovieDto;
import com.movierating.services.MovieServices;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

	private MovieServices movieSer;
	
	
	public MovieController(MovieServices movieSer) {
		super();
		this.movieSer = movieSer;
	}

	@PostMapping("")
	public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto){
		return new ResponseEntity<>(movieSer.createMovie(movieDto),HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public List<MovieDto> getAllMovies(){
		return movieSer.getAllMovies();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDto> getMovieById(@PathVariable(name="id") long id){
		return ResponseEntity.ok(movieSer.getMovieById(id));
	}
	
	//@GetMapping("")
	//public ResponseEntity<List<Movie>> getMoviesByGreaterThan(@RequestParam long runtimeMinutes){
		//return new ResponseEntity<List<Movie>>(movieRepo.findByRuntimeGreaterThan(runtimeMinutes,HttpStatus.OK));
		
	//}
	
	@GetMapping("")
	public List<MovieDto> getLongMovies(@PathVariable(name="runtimeMinutes") long runtimeMinutes){
		return movieSer.getLongestMovie(runtimeMinutes);
	}
}
