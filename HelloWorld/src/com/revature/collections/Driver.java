package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

import com.revature.media.*;

public class Driver {

	public static void main(String[] args) {
		// funWithLists();

		funWithMaps();
	}

	public static void funWithLists() {
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "Fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishmeht", 1866, "Fiction");

		Movie m1 = new Movie("Toy Story", "Pixar", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "Science Fiction");

		// It is a List, so we can have duplicates
		Collections.addAll(mediaList, b1, b2, m1, m2);

		// Use instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
			}
			if (m instanceof Movie) {
				((Movie) m).watch();
			}
		}

		// Print out list of elements with Iterator and while-loop
		// Remove any elements published before 1870
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

		// We get a new iterator every time we create one, even if it's the same type
		// They do point to the same mediaList list, however, so edits will affect both
		Iterator<Media> it2 = mediaList.iterator();

		System.out.println(it == it2);

	}

	public static void funWithMaps() {
		// Create a new hashmap with key-value pairs
		// Could include <Integer, Media> on the RHS
		Map<Integer, Media> hashMap = new HashMap<>();

		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "Fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishmeht", 1866, "Fiction");

		Movie m1 = new Movie("Toy Story", "Pixar", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "Science Fiction");

		// Use put() to insert things into a HashMap
		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);
		
		System.out.println(hashMap);
		
		// We CANNOT have duplicate keys, since they're part of a set
		// If we try to put a new object in with an existing key, it will replace it.
		
		System.out.println("size of hashMap: " + hashMap.size());
		
		//while Maps are not Collections, the EntrySet of a Map is a Collection
		for (Entry<Integer, Media> entry : hashMap.entrySet()){
			System.out.println(entry.getKey() + "\t" + entry.getValue());
			System.out.println(entry.toString());
		}
	}
}
