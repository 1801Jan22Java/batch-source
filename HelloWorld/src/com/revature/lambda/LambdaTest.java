package com.revature.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;

public class LambdaTest {
	
	public static void main(String[] args) {
		
	List<Media> mediaList = new ArrayList<Media>();
	Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "fiction");
	Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
	Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
	Movie m2 = new Movie("Michael Chrichton", "Jurassic Park", 1993, "science fiction");
	Collections.addAll(mediaList, b1, b2, m1, m2);
	
	
	mediaList.forEach(media -> System.out.println(media.toString()));
	
	}
	
}
