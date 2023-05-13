package com.movierating.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movierating.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long>{

}
