package com.revature.io;

import java.io.*;

import com.revature.media.Book;
import com.revature.media.Movie;

public class Serialize {

	public static void main(String[] args) {

		Book b1 = new Book("Anthony Burgess", "A Clockwork Orange", 1962, "Social Commentary", "Penguin Books");
		String filename = "src/serializedThings/mediaDemo/b1";
		writeObject(filename, b1);
		Book b2 = (Book) readObject(filename);
		System.out.println(b2.toString());

		Movie m1 = new Movie("Stanley Kubrik", "A Clockwork Orange", 1971, "Social Commentary");
		filename = "src/serializedThings/mediaDemo/m1";
		writeObject(filename, m1);
		Movie m2 = (Movie) readObject(filename);
		System.out.println(m2.toString());

	}

	static void writeObject(String filename, Serializable s) {
		// try with resources
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(s);
			System.out.println("Wrote to file: " + s.toString());
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static Serializable readObject(String filename) {
		Serializable s = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

			s = (Serializable) ois.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return s;
	}

}
