package com.revature.reflections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.collections.Book;
import com.revature.collections.Media;
import com.revature.collections.Movie;

public class Driver {

	public static void main(String[] args) {
		funWithReflection();
		List<Media> mediaList = new ArrayList<Media>();

		Book b1 = new Book(1877, "fiction", "Leo Tolstoy", "Anna Karenina");
		Book b2 = new Book(1877, "fiction", "Fyodor Dostayevsky", "Crime and Punishment");
		Movie m1 = new Movie(1995, "animation", "Pixar", "Toy Story");
		Movie m2 = new Movie(1993, "science fiction", "Michael Crichton", "Jurassic Park");

		Collections.addAll(mediaList, b1, b2, m1, m2);
		System.out.println(genericReflactions(mediaList));
		Collections.shuffle(mediaList);
		System.out.println(genericReflactions(mediaList));

	}
	
	public static <T> T genericReflactions(List<T> l) {
		for (T item : l) {
			if(item.getClass().getName().equals("com.revature.collections.Book")) {
				return item;
			}
		}
		return null;
	}
	
	public static void funWithReflection() {
		try {
			//get our class
			Class clazz = Class.forName("com.revature.collections.Media");
			System.out.println(clazz.getSimpleName());
			
			Field [] fields = clazz.getDeclaredFields();
			for(Field field : fields) {
				System.out.println(field.getName() + " which a datatype of " + field.getType());
			}
			
			//new instance of book
			Class clazz2 = Class.forName("com.revature.collections.Book");
			Book b1 = (Book) clazz2.newInstance();
			System.out.println(b1);
			Field publisher = clazz2.getDeclaredField("publisher");
			publisher.setAccessible(true);
			publisher.set(b1, "Michael Bay");
		}
		catch(ClassNotFoundException e) {
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

}
