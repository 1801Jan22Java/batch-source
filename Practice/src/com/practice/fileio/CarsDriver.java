package com.practice.fileio;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CarsDriver {
	public static StringBuilder work(StringBuilder a , StringBuilder b) {
		a= new StringBuilder("a");
		b.append("b");
		
		return a;
	}
	
	public static void main(String[] args) {
		StringBuilder s1 = new StringBuilder("s1");
		StringBuilder s2 = new StringBuilder("s2");
		StringBuilder s3 = work(s1,s2);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		Cars c1 = new Cars(4,"nissan","murano");
		String filename = "src/test.txt";
		
		writeObject(filename,c1);
		
	}
	
	static void writeObject(String filename,Serializable s) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(s);
			System.out.println(s.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
