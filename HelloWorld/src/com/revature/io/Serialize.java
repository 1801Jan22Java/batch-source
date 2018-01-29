package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.revature.collections.*;

public class Serialize 
{
	public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Book b1 = new Book("Anthony Burgess", "Clockwork Orange", 1962,"Social Commentary");
		String filename = "src/serializedThings/MediaDemo";
		writeObject (filename, b1);
		
		readObject(filename);
		Movie m1 = new Movie("Stanly Kubric","A Clock Work Orange", 1971,"Social Commentary");
		//Even though the parent class is serializable and the mavie class is not, it is able to see things that are not available
		//This is because it uses reflection to see Movie's details
		m1.setMovieId(666);
		writeObject (filename, m1);
		
		readObject(filename);
	}
	static void writeObject(String filename, Serializable o ) throws FileNotFoundException, IOException
	{
		//try with resources
		//a try block that you can pass resources into
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
		{
			oos.writeObject(o);
			System.out.println("wrote to file: "+o.toString());
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	static Serializable readObject(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Serializable s = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
		{
			s = (Serializable) ois.readObject();
			System.out.println("read object: "+s.toString());
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return s;
	}
}
