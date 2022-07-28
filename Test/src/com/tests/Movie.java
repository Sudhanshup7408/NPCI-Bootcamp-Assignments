package com.tests;

public class Movie {
	 private String name; 
	 private String director_name;
	 private int duration;
	 private int releasedYear;
	 
	public Movie(String name, String director_name, int duration, int releasedYear) {
		
		this.name = name;
		this.director_name = director_name;
		this.duration = duration;
		this.releasedYear = releasedYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector_name() {
		return director_name;
	}

	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(int releasedYear) {
		this.releasedYear = releasedYear;
	}
}
