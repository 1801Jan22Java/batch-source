package com.revature.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.*;

public class CompareExample {

	public static void main(String[] args) {

		List<Movie> movieList = new ArrayList<Movie>();
		Movie b1 = new Movie("Leo Tolstoy", "Anna Karenina", 1877, "action");
		Movie b2 = new Movie("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "romcom");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Chricton", "Jurassic Park", 1993, "science fiction");
		Collections.addAll(movieList, b1, b2, m1, m2);
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
		YearCompare yc = new YearCompare();
		Collections.sort(l, yc); // could write multiple comparators 
		System.out.println("Movies after sortWithComparator: ");
		for(Movie m : l) {
			System.out.println(m);
		}
		return l;
	}
	
}
