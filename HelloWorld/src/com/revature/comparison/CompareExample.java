package com.revature.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;

public class CompareExample {

	public static void main(String[] args) {
		List<Movie> movieList = new ArrayList<Movie>();
		Movie b1 = new Movie("Leo TolStoy", "Anna Karenina", 1877, "action");
		Movie b2 = new Movie("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "romance");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Chrichton", "Jurassic Park", 1993, "science fiction");

		Collections.addAll(movieList,  b1, b2, m1, m2);
		System.out.println("Movies before sortedWIthComparable");
		for (Movie m : movieList) {
			System.out.println(m);
		}
		//sortWithComparable(movieList);
		
		sortWithComparator(movieList);
	}
	
	public static List<Movie> sortWithComparable(List<Movie> l) {
		Collections.sort(l);
		System.out.println("Movies after sortWithComparable: ");
		for (Movie m : l) {
			System.out.println(m);
		}
		return l;
	}
	
	
	public static List<Movie> sortWithComparator(List<Movie> l) {
		YearCompare yc = new YearCompare();		// using default constructor here
		Collections.sort(l, yc);	// could write multiple Comparators and swap them out
		System.out.println("Movies after sortWithComparator: ");
		for (Movie m : l) {
			System.out.println(m);
		}
		return l;
	}
}
