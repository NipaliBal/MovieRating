package com.movierating.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="movies", uniqueConstraints= {@UniqueConstraint(columnNames= {"pimaryTitle"})})
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title_type",nullable=false)
	private String titleType;
	
	@Column(name="primary_title",nullable=false)
	private String primarytitle;
	
	@Column(name="runtimeMinutes",nullable=false)
	private long runtimeMinutes;
	
	@Column(name="genres",nullable=false)
	private String genres;
	
	@OneToOne(mappedBy="post",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Rating> ratings=new HashSet<>();
}
