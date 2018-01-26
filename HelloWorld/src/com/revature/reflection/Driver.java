package com.revature.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;


public class Driver {
	public static void main(String[] args) {
		try {
			
			Class myClass = Class.forName("com.revature.media.Media");
			System.out.println(myClass.getFields());
			Field[] myFields = myClass.getDeclaredFields();
			for (Field f : myFields) {
				System.out.println(f.getName());
			}
			
			Class myClass2 = Class.forName("com.revature.media.Book");
			Book b1 = (Book) myClass2.newInstance();
			
			
			Field creator = myClass2.getDeclaredField("publisher");
			creator.setAccessible(true);
			creator.set(b1, "Michael Bay");
			System.out.println(b1);
			
			List<Media> mediaList = new ArrayList<>();
			Book b3 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "fiction");
			Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
			Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
			Movie m2 = new Movie("Steven Spielburg", "Jurrasic Park", 1993, "science fiction");
			Collections.addAll(mediaList, b3, b2, m1, m2);
			System.out.println(genericReflections(mediaList));
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static <T> T genericReflections(List<T> l) {
		for (T item : l) {
			if (item.getClass().getName().equals("com.revature.media.Book")) {
				return item;
			}
		}
		return null;
	}
}
