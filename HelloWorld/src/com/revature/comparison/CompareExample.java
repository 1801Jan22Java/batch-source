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
		Movie b1 = new Movie("Leo Tolstoy", "Anna Karenina", 1877, "Action");
		Movie b2 = new Movie("Fyodor Dostoyevsky", "Crime and Punishmeht", 1866, "Romcom");

		Movie m1 = new Movie("Toy Story", "Pixar", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "Science Fiction");
		
		Collections.addAll(movieList, b1, b2, m1, m2);

		System.out.println("Movies before sortWithComparable: ");
		for (Movie m : movieList) {
			System.out.println(m);
		}
		
		//sortWithComparable(movieList);
		
		sortWithComparator(movieList);
	}
	
	public static List<Movie> sortWithComparable(List<Movie> l){
		Collections.sort(l);
		System.out.println("Movies after sortWithComparable: ");
		for (Movie m : l) {
			System.out.println(m);
		}
		
		return l;
	}
	
	public static List<Movie> sortWithComparator(List<Movie> l){
		YearCompare yc = new YearCompare();
		Collections.sort(l,yc);	//Could write multiple Comparators and swap them out
		
		System.out.println("Movies after sortWithComparable: ");
		for (Movie m : l) {
			System.out.println(m);
		}
		
		return l;
	}
	
}
