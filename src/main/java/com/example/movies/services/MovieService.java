package com.example.movies.services;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.movies.model.Movies;
import com.example.movies.model.SearchMovieResponse;


public interface MovieService {
	

	List<Movies> getAllMovies();
	Movies getMoviesById(int moviesId);
	void addMovies(Movies movies) throws IOException;
	void updateMovies(Movies movies, int moviesId) throws IOException;
	void deleteMovies(int moviesId) throws IOException;
	SearchMovieResponse search(String query) throws IOException, ParseException;
	Page<Movies> findAllByPage(Pageable page);
	 void dumpMovies();
	
	
	


}
