package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

import com.revature.media.*;

public class Driver {

	public static void main(String[] args) {

		funWithLists();
		funWithMaps();

	}

	public static void funWithLists() {
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Chrichton", "Jurassic Park", 1993, "science fiction");
		Collections.addAll(mediaList, b1, b2, m1, m2);

		// use instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
			}
		}
		// print out list elements with iterator and while loop
		// remove any elements published before 1870
		Iterator<Media> it = mediaList.iterator();
		while (it.hasNext()) {
			Media m = it.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("Removed " + m.getTitle());
				it.remove();
			} else {
				System.out.println(m.toString());
			}
		}
	}

	public static void funWithMaps() {

		// new hashmap with key value pairs
		Map<Integer, Media> hashMap = new HashMap<>();

		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Chrichton", "Jurassic Park", 1993, "science fiction");

		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);
		
		System.out.println(hashMap);
		
		// no duplicate keys
		hashMap.put(2, new Book("Dr. Seuss", "The Lorax", 1971, "allegory"));
		// will replace the value with the same key
		System.out.println(hashMap.get(2));
		
		System.out.println("Size of hashMap: " + hashMap.size());
		
		// while maps are not Collections, the EntrySet of a Map IS
		for(Entry<Integer,Media> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
			System.out.println(entry.toString());
		}
	}
}
