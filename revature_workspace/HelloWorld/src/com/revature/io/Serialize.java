package com.revature.io;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.revature.media.*;

public class Serialize {
	
	public static void main(String [] args )
	{
		Book b1 = new Book("Anthony Burgess","A Clockwork Orange",1962,"Social commentary");
		Movie m1 = new Movie("A Clockwork Orange","Stanley Kubrick",1971,"Social commentary");
		String filename = "src/serializedThings/MediaDemo";
		//writeObject(filename,b1);
		//readObject(filename);
		//writeObject(filename,m1);
		readObject(filename);
	}
	
	static void writeObject(String filename, Serializable s)
	{
		// try with resources 
		/*
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(s);
			System.out.println("Wrote to file: " +s.toString());
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}*/
	/*	try (FileOutputStream fos = new FileOutputStream((filename))){
		//	BufferedOutputStream bos = new BufferedOutputStream(fos);
		//	fos.write(bos);
			System.out.println("Wrote to file: " +s.toString());
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
		*/
	}
	
	static Serializable readObject(String filename)
	{
		Serializable s= null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			s = (Serializable)ois.readObject();
			System.out.println("Read object: "+ s.toString());
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return s;
		
	}
}
