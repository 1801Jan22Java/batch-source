package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

public class Driver {

	public static void main(String[] args) {

		funWithMaps();

	}

	public static void funWithLists() {
		List<Media> mediaList = new ArrayList<>();
		Book b1 = new Book("Leo Tolstory", "Anna Karenia", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichon", "Jurassic Park", 1993, "science fiction");
		Collections.addAll(mediaList, b1, b2, m1, m2);

		// use instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				((Book) m).read();
			}
		}

		// print put list of elements with iterator and while loop
		// remove any elements published before 1870
		Iterator<Media> it = mediaList.iterator();
		Media m;
		while (it.hasNext()) {
			m = it.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("removed " + m.getTitle());
				it.remove();
			} else {
				System.out.println(m.toString());
			}

		}
		Iterator<Media> it2 = mediaList.iterator();
		while (it2.hasNext()) {
			m = it2.next();
			if (m.getYearPublished() <= 1870) {
				System.out.println("removed " + m.getTitle());
				it2.remove();
			} else {
				System.out.println(m.toString());
			}

		}
		System.out.println(it2 == it);

	}

	public static void funWithMaps() {

		// new hashmap with key-value pairs
		Map<Integer, Media> hashMap = new HashMap<>();

		Book b1 = new Book("Leo Tolstory", "Anna Karenia", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichon", "Jurassic Park", 1993, "science fiction");

		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);

		System.out.println(hashMap);
		
		//no duplicate keys
		System.out.println(hashMap.get(2));
		hashMap.put(2, new Book("Dr. Suess", "The Lorax", 1971, "allegory"));
		System.out.println(hashMap.get(2));
		
		System.out.println("size of hash map = " + hashMap.size());
		
		//while maps are not Collection, the EntrySet of a map is
		
		for (Entry<Integer, Media> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
			System.out.println(entry.toString());
		}
		
	}

}
