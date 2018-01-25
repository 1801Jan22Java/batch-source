package com.revature.collections;

import java.util.*;

import com.revature.media.*;

public class Driver {

	public static void main(String[] args) {
		
		funWithLists();

	}

	public static void funWithLists(){
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy","Anna Karenina",1877,"fiction");
		Book b2 = new Book("Fyodor Dostoyevsky","Crime and Punishment",1866,"fiction");
		Movie m1 = new Movie("Pixar","Toy Story",1995,"cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "science fiction");
		Collections.addAll(mediaList, b1,b2,m1,m2);
		
		//use instanceof
		for (Media m : mediaList){
			if (m instanceof Book){
				((Book) m).read();;
			}
		}
		
		//print out list elements with iterator and while loop 
		//remove any elements published before 1870
		Iterator<Media> it = mediaList.iterator();
		while(it.hasNext()){
			Media m = it.next();
			if(m.getYearPublished() <= 1870){
				System.out.println("removed "+m.getTitle());
				it.remove();
			} else {
				System.out.println(m.toString());
			}
		}
		
		Iterator<Media> it2 = mediaList.iterator();
		
		while(it2.hasNext()){
			Media m = it2.next();
			if(m.getYearPublished() <= 1870){
				System.out.println("removed "+m.getTitle());
				it2.remove();
			} else {
				System.out.println(m.toString());
			}
		}
		
		
		
	}

}
