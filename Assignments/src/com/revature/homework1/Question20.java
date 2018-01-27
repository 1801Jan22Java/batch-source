package com.revature.homework1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


public class Question20 {
	public static void main(String[] args) {
		// Test file reading
		// System.out.println(readFirstLine("Data.txt")+"\n");
		
		// Actual output
		System.out.println(formatString(readFirstLine("Data.txt")));
	}
	
	public static String readFirstLine(String filename) {
		
		BufferedReader br = null;
		// Try-catch to catch FileNotFoundException
		try {
			
			// get the url from the same directory the class is in
			URL url = Question20.class.getResource(filename);
			
			// create a File using the path 
			File file = new File(url.getPath());
			
			// Intantiate a new BufferedReader, input file into FileReader 
			br = new BufferedReader(new FileReader(file));
			
			// Read one line.
			String output = br.readLine();
			br.close();
			return output;
		} catch (FileNotFoundException e) {
			// Return nothing if file not found
			e.printStackTrace();
			return "";
		} catch(IOException e){
			e.printStackTrace();
			return "";
		}
	}
	
	public static String formatString(String input) {
		String[] pieces = new String[30];
		
		pieces = input.split(":");
		
		String output = "Name: "+pieces[0]+" "+pieces[1]+"\n"+
		"Age: "+pieces[2]+" years"+"\n"+
		"State: "+pieces[3]+" State";
		
		return output;
	}
}
