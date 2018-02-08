package com.revature.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;

public class CompareExample {
	public static void main(String[] args)
	{
		List<Movie> movieList = new ArrayList<Movie>();
		Movie b1 = new Movie("S.E. Hilton", "The Outsiders", 1967, "fiction");
		Movie b2 = new Movie("Ray Bradbury", "The Illustrated Man", 1951, "fiction");
		Movie m1 = new Movie("Ron Howard", "A Beautiful Mind", 2001, "biographical drama");
		Movie m2 = new Movie("Woody Allen", "Midnight in Paris", 2011, "Comedy, Fantasy, Romance");
		Collections.addAll(movieList, b1, b2, m1, m2);
		for(Movie m : movieList)
			System.out.println(m);
		sortWithComparable(movieList);
	}
	
	public static List<Movie> sortWithComparable(List<Movie> l)
	{
		Collections.sort(l);
		System.out.println("Movies after sortWithComparable: ");
		for(Movie m : l)
			System.out.println(m);
		return l;
	}
	
	public static List<Movie> sortWithComparator(List<Movie> l)
	{
		YearCompare yc = new YearCompare();
		Collections.sort(l, yc);
		System.out.println("Movies after sortWithComparator: ");
		for(Movie m : l)
			System.out.println(m);
		return l;
	}
}
