package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import com.revature.media.*;

public class Serialize {
	public static void main(String[] args) {
		Book b1 = new Book("Anthony Burgess", "A Clockwork Orange", 1962, "Social Commentary");
		String filename = "src/serializedThings/MediaDemo";
		writeObject(filename,b1);
		readObject(filename);
		
		Movie m1 = new Movie("Stanley Kubrick", "A Clockwork Orange", 1971, "Social Commentary");
		writeObject(filename, m1);
		readObject(filename);
		
	}
	
	static void writeObject(String filename, Serializable o) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(o);
			System.out.println("wrote to file: " + o.toString());;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Serializable readObject(String filename) {
		Serializable s = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			s  = (Serializable) ois.readObject();
			System.out.println("read object: " + s.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}
