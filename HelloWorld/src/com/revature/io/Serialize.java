package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.revature.collections.Book;

public class Serialize {

	public static void main(String[] args) {
		
		Book b1 = new Book("William Heinemann","Anthony Burgess","A Clockwork Orange", 1962, "social commentary");
		String filename = "src/SerializedThings/MediaDemo";
		writeObject(filename,b1);
		readObject(filename);
	}
	
	static void writeObject(String filename, Serializable s) {
		//try with resources
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(s);
			System.out.println("Wrote to file."+s.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Serializable readObject(String filename) {
		Serializable s = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			s = (Serializable) ois.readObject();
			System.out.println("read object: "+s.toString());
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
