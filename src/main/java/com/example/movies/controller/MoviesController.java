/**
 * 
 */
package com.example.movies.controller;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.model.Movies;
import com.example.movies.model.SearchMovieResponse;
import com.example.movies.services.MovieService;
/**
 * @author ronneyismael
 *
 */
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MoviesController {
	
	@Autowired
	MovieService movieServiceRef;
	@RequestMapping("/welcome")
	public String welcomeMovies() {
		return  "Hello Movies";
	}
	@RequestMapping("/movies")
	public List<Movies> getAllMovies(){
		return movieServiceRef.getAllMovies();
		
	}
	@RequestMapping("/movies/{moviesId}")
	public Movies getMoviesById(@PathVariable int moviesId) {
		
		return movieServiceRef.getMoviesById(moviesId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="/movies")
	public void addMovies(@RequestBody Movies movies) throws IOException {
		movieServiceRef.addMovies(movies);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value ="/movies/{moviesId}")
	public void updateMovies(@RequestBody Movies movies,@PathVariable int moviesId) throws IOException {
			movieServiceRef.updateMovies(movies,moviesId);
	}
	@RequestMapping(method= RequestMethod.DELETE,value="/movies/{moviesId}")
	public void deleteMovies(@PathVariable int moviesId) throws IOException {
		movieServiceRef.deleteMovies(moviesId);
	}
	
	@RequestMapping("/movies/search")
	public SearchMovieResponse getMovies(@RequestParam(value = "query") String query) throws IOException, ParseException  {
		
		return movieServiceRef.search(query);
	}
	
	@RequestMapping(value="/movies/query",method = RequestMethod.GET)
	public Page<Movies> fetchByPage(Pageable page) {
		return movieServiceRef.findAllByPage(page);
	}
	
	@RequestMapping("/movies/dump")
	public String dumpMovies(){
		 movieServiceRef.dumpMovies();
		 
		 return "Success";
		
	}
	
	
	


}
