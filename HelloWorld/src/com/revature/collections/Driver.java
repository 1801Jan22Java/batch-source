package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;

public class Driver {

	public static void main(String[] args) {
		
		//funWithLists();
		
		funWithMaps();
	}
	
	public static void funWithLists() {
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo TolStoy", "Anna Karenina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Chrichton", "Jurassic Park", 1993, "science fiction");
		// note: better convention to write out book1, book2, movie1, movie2 for variable names
		
		//mediaList.add(book1);
		//mediaList.add(book2);
		Collections.addAll(mediaList, b1, b2, m1, m2);
		
		// using a for-each loop, use instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
			}
		}
		
		// print out list elements with iterator and while loop
		// remove any elements published before 1870
		Iterator<Media> it = mediaList.iterator();	// this makes code cleaner instead of
													// constantly calling mediaList.iterator() in loop
													// each instance of a collection has an iterator
		while (it.hasNext()) {
			Media m = it.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("removied " + m.getTitle());
				it.remove();
			} else {
				System.out.println(m.toString());
			}
		}
		
		// this shows that we created a new instance of the iterator of it and it2
		Iterator<Media> it2 = mediaList.iterator();
		System.out.println(it == it2);
		
		// Note that since both iterators are pointing to the same object, 
		// so Crime and Punishment is not removed again
		while (it2.hasNext()) {
			Media m = it2.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("removed " + m.getTitle());
				it2.remove();
			} else {
				System.out.println(m.toString());
			}
		}
	}
	
	// A map is not a collection so it is not iterable (note though that the keys are iterable)
	public static void funWithMaps() {
		
		// new hashmap with key-value pairs
		Map<Integer, Media> hashMap = new HashMap<>();
		
		Book b1 = new Book("Leo TolStoy", "Anna Karenina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Chrichton", "Jurassic Park", 1993, "science fiction");
	
		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);

		System.out.println(hashMap);
		
		// no duplicate keys
		System.out.println(hashMap.get(2));
		hashMap.put(2, new Book("Dr. Seuss", "The Lorax", 1971, "allegory"));
		System.out.println(hashMap.get(2));
		
		System.out.println("size of hashMap: " + hashMap.size());
		
		// while Maps are not collections, the EntrySet of a Map IS
		for (Entry<Integer, Media> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
			System.out.println(entry.toString());
		}
		
	}
	
}
