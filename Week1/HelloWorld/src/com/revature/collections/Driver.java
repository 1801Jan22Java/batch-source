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
		// TODO Auto-generated method stub

	}

	public static void funWithLists()
	{
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("S.E. Hilton", "The Outsiders", 1967, "fiction", "Viking Press, Dell Publishing");
		Book b2 = new Book("Ray Bradbury", "The Illustrated Man", 1951, "fiction", "Doubleday & Company" );
		Movie m1 = new Movie("Ron Howard", "A Beautiful Mind", 2001, "biographical drama");
		Movie m2 = new Movie("Woody Allen", "Midnight in Paris", 2011, "Comedy, Fantasy, Romance");
		Collections.addAll(mediaList, b1, b2, m1, m2);

		//use instanceof
		for(Media m : mediaList)
		{
			if(m instanceof Book)
				((Book) m).read();
		}

		//remove elements created after 1966
		Iterator<Media> it = mediaList.iterator();
		Media temp = null;
		while(it.hasNext())
		{
			temp = it.next();
			if(temp.getYearPublished() > 1966)
			{
				System.out.println("Removed " + temp.getTitle());
				it.remove();
			}
		}
	}

	public static void funWithMaps()
	{
		Map<Integer, Media> map = new HashMap<Integer, Media>();

		Book b1 = new Book("S.E. Hilton", "The Outsiders", 1967, "fiction", "Viking Press, Dell Publishing");
		Book b2 = new Book("Ray Bradbury", "The Illustrated Man", 1951, "fiction", "Doubleday & Company" );
		Movie m1 = new Movie("Ron Howard", "A Beautiful Mind", 2001, "biographical drama");
		Movie m2 = new Movie("Woody Allen", "Midnight in Paris", 2011, "Comedy, Fantasy, Romance");

		map.put(1, b1);
		map.put(2, b2);
		map.put(3, m1);
		map.put(4, m2);
		
		System.out.println(map);
		
		//putting a new value with a key matching a key already in the hashmap will
		//replace the previous key's value with the new value.
		map.put(2, new Book("Dr.Seuss", "The Lorax", 1971, "Allegory", "Seuss books"));
		System.out.println(map);
		
		System.out.println("HashMap size: " + map.size());
		
		//Note: while maps are not Collections, the EntrySet of a Map IS.
		for(Entry<Integer, Media> entry : map.entrySet())
			System.out.println("Key: " + entry.getKey() + "\tValue: "+entry.getValue() + "\t" +entry.toString());
	}
	
	
}