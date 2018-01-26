package com.revature.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Media;
import com.revature.media.Movie;

public class CompareExample {
	
	public static void main(String[] args) {
		
		List<Movie> movieList = new ArrayList<Movie>();
		Movie b1 = new Movie("Leo Tolstoy", "Anna Karenina", 1877, "Action");
		Movie b2 = new Movie("Fryodor Dostoyevesky", "Crime and Punishment", 1866, "Romance");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "Science Fiction");
		Movie m3 = new Movie("Disney", "Star Wars VIII", 2017, "Science Fiction");
		Collections.addAll(movieList, b1, b2, m1, m2, m3);
		
		System.out.println("Movies before sorting");
		for(Movie m: movieList) {
			System.out.println(m);
		}
		
		Collections.shuffle(movieList);
		movieList = sortWithComparable(movieList);
		Collections.shuffle(movieList);
		System.out.println("Movies before sorting by year");
		for(Movie m: movieList) {
			System.out.println(m);
		}
		movieList = sortWithComparator(movieList);
		System.out.println("Movies after sorting by year");
		for(Movie m: movieList) {
			System.out.println(m);
		}
		
		
		
	}
	
	public static List<Movie> sortWithComparator(List<Movie> l){
		YearCompare yc = new YearCompare();
		Collections.sort(l, yc);
		return l;
	}
	
	public static List<Movie> sortWithComparable(List<Movie> l){
		
		Collections.sort(l);
		System.out.println("Movies after sort with comparable");
		for(Movie m: l) {
			System.out.println(m);
		}
		
		return l;
	}

}
