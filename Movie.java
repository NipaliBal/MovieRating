package com.movierating.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table( name="movies", uniqueConstraints= {@UniqueConstraint(columnNames= {"primaryTitle"})})

public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long tconst;
	
	@Column(name="titleType")
	private String titleType;
	
	@Column(name="primaryTitle", unique=true)
	private String primaryTitle;
	
	@Column(name="runtimeMinutes")
	private long runtimeMinutes;
	
	@Column(name="genres")
	private String genres;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Rating rating;
}
