package com.reveature.reflection;

import java.lang.reflect.Field;

import com.revature.media.Book;

public class Driver {
	public static void main(String[] args) {

		try {
			
			//get our class
			Class clazz = Class.forName("com.revature.media.Media");
			System.out.println(clazz.getName());
			
			//print fields
			Field[] fields = clazz.getDeclaredFields();
			
			for (Field f : fields) {
				System.out.println(f.getName() + " with a datatype of " + f.getType());
			}
			
			//new instance of book
			Class clazz2 = Class.forName("com.revature.media.Book");
			Book b1 = (Book) clazz2.newInstance();
			System.out.println(b1);
			
			Field publisher = clazz2.getDeclaredField("publisher");
			publisher.setAccessible(true);
			publisher.set(b1, "Michael Bay");
			System.out.println(b1);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
	}
}
