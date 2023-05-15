package com.movierating.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.movierating.entity.Movie;
import com.movierating.exception.ResourceNotFoundexception;
import com.movierating.payload.MovieDto;
import com.movierating.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieServices {

	private MovieRepository movieRepo;
	private ModelMapper mapper;
	public MovieServiceImpl(MovieRepository movieRepo,ModelMapper mapper) {
		super();
		this.movieRepo = movieRepo;
		this.mapper=mapper;
	}

	@Override
	public MovieDto createMovie(MovieDto movieDto) {
		Movie movie=maptoEntity(movieDto);
		Movie newMovie=movieRepo.save(movie);
		MovieDto movieResponse=mapToDTO(newMovie);
		return movieResponse;
	}

	
	@Override
	public List<MovieDto> getAllMovies() {
		List<Movie> movies=movieRepo.findAll();
		return movies.stream().map(movie->mapToDTO(movie)).collect(Collectors.toList());
	}

	@Override
	public MovieDto getMovieById(long id) {
		Movie movie=movieRepo.findById(id).orElseThrow(()->new ResourceNotFoundexception("Movie","id",id));
		return mapToDTO(movie);
	}
	
	@Override
	public List<MovieDto> getLongestMovie(long runtimeMinutes) {
		List<Movie> movies=movieRepo.findByTop(runtimeMinutes);
		return movies.stream().map(movie->mapToDTO(movie)).collect(Collectors.toList());
	}
	
	private MovieDto mapToDTO(Movie movie) {
		MovieDto movieDto=mapper.map(movie, MovieDto.class);
		return null;
	}

	private Movie maptoEntity(MovieDto movieDto) {
		Movie movie=mapper.map(movieDto, Movie.class);
		return null;
	}

	

	
}
