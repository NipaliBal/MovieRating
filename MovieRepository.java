package com.movierating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movierating.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {

	//List<Movie> findByRuntimeMinutesGreaterThan(long runtimeMinutes);
	@Query("select top 10 m from Movie m where m.runtimeMinutes<='?1' order by m.runtimeMinutes desc")
	List<Movie> findByTop(long runtimeMinutes);
}
