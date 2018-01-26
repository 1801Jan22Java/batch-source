package com.review_thursday.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.review_thursday.media.*;

public class CompareExample {
	
	public static void main(String[] args) {
		List<Movie> movieList = new ArrayList<Movie>();
		Movie b1 = new Movie("Leo Tolstoy","Anna Karenia",1877,"action");
		Movie b2 = new Movie("Fyodor Dostoyevsky","Crime and Punishment",1866,"romcom");
		Movie m1 = new Movie("Pixar","Toy Story",1955,"cartoon");
		Movie m2 = new Movie("Michael Crichton","Jurassic Park",1993,"science fiction");
		
		Collections.addAll(movieList,b1,b2,m1,m2);
		
		for(Movie m:movieList) {
			System.out.println(m);
		}
		Collections.sort(movieList);
		System.out.println("hopefully this sorted \n");
		for(Movie m:movieList) {
			System.out.println(m);
		}
		

	}
	
	/*public static List<Movie> sortWithComparable(List<Movie> l){
		
	}*/

}
