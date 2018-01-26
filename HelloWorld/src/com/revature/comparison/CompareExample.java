package com.revature.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;

public class CompareExample {

	public static void main(String[] args) {
		List<Movie> movieList = new ArrayList<>();
		Movie b3 = new Movie("Leo Tolstoy", "Anna Karenina", 1877, "fiction");
		Movie b2 = new Movie("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Steven Spielburg", "Jurrasic Park", 1993, "science fiction");

	}
	
	public static List<Movie> sortWithComparable(List<Movie> l) {
		Collections.sort(l);
		System.out.println("Movies after sort");
		for (Movie m : l) {
			System.out.println(m);
		}
		return l;
	}

}
