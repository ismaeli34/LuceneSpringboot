package com.example.movies.model;

import java.util.List;

public class SearchMovieResponse {
	private String duration;
	private List<Movies> result;
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public List<Movies> getResult() {
		return result;
	}
	public void setResult(List<Movies> result) {
		this.result = result;
	}
	public SearchMovieResponse() {
		super();
	}
	
	

}
