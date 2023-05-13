package com.movierating.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.movierating.entity.Movie;
import com.movierating.payload.MovieDto;
import com.movierating.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepo;
	private ModelMapper mapper;
	
	public MovieServiceImpl(MovieRepository movieRepo) {
		super();
		this.movieRepo = movieRepo;
	}


	@Override
	public MovieDto createMovie(MovieDto movieDto) {
		Movie movie=mapToEntity(movieDto);
		Movie newMovie=movieRepo.save(movie);
		
		MovieDto movieResponse=mapToDTO(newMovie);

		return movieResponse;
	}
	

	@Override
	public List<MovieDto> getAllMovies() {
		List<Movie> movies=movieRepo.findAll();
		return movies.stream().map(movie-> mapToDTO(movie)).collect(Collectors.toList());
	}
	

	@Override
	public List<MovieDto> getLongMovies() {
		List<Movie> movies=movieRepo.findAll();
		return movies.stream().sorted(Comparator.reverseOrder()).limit(10).collect(Collectors.toList()); 
	}


	
	private MovieDto mapToDTO(Movie movie) {
		MovieDto movieDto=mapper.map(movie,MovieDto.class);
		return movieDto;
	}
	
	private Movie mapToEntity(MovieDto movieDto) {
		Movie movie=mapper.map(movieDto,Movie.class);
		return movie;
	}


}
