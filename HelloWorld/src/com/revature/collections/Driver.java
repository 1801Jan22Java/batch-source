package com.revature.collections;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.revature.media.Media;

public class Driver {

	public static void main(String[] args) {
		// funWithLists();

		funWithMaps();
	}

	public static void funWithLists() {
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy", "Anna Kareina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "science fiction");
		// Use Collections Framework
		Collections.addAll(mediaList, b1, b2, m1, m2);

		// Use instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
			}
		}

		// Print list elements iwth iterator
		// remove any elements published before 1870
		Iterator<Media> it = mediaList.iterator();
		while (it.hasNext()) {
			Media m = (Media) it.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("removed " + m.getTitle());
				it.remove();
			} else {
				System.out.println(m.toString());
			}
		}

		// Iterators are different objects when created
		Iterator<Media> it2 = mediaList.iterator();
		System.out.println(it == it2);

		while (it2.hasNext()) {
			Media m = (Media) it2.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("removed " + m.getTitle());
				it2.remove();
			} else {
				System.out.println(m.toString());
			}
		}
	}

	public static void funWithMaps() {

		// new hashmap with key-value pairs
		Map<Integer, Media> hashMap = new HashMap<>();

		Book b1 = new Book("Leo Tolstoy", "Anna Kareina", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "science fiction");

		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);
		
		// This will replace b1 with m2.
		// hashMap.put(1, m2);
		
		System.out.println(hashMap);
		
		System.out.println(hashMap.get(2));
		
		System.out.println("Hashmap size: "+hashMap.size());
		
		// Maps are not Collection, but the EntrySet of a map IS
		// To iterate through map, we have to use Entry
		for(Entry<Integer,Media> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
			System.out.println(entry.toString());
		}
	}
	
	

}
