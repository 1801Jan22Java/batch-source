package com.Practice_work.Generics;

public class Movie implements Comparable<Movie> {
	private double rating;
	private String name;
	private int year;
	
	public int compareTo(Movie m) {
		return this.year -m.year;
	}
	
	public Movie(String name,double rating,int year) {
		super();
		this.name = name;
		this.rating = rating;
		this.year = year;
	}
	public Movie() {
		super();
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
