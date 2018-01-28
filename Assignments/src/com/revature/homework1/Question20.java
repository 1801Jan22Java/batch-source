package com.revature.homework1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Question20 {
	public static void main(String[] args) {
		//This line will look within our package to find the resource called Data.txt
		//From the URL object, we call getPath to find the specific path to the file on system
		//It's a good way to make this not break when run and compiled on another machine.
		URL url = Question20.class.getResource("Data.txt");
		try(BufferedReader br = new BufferedReader(new FileReader(url.getPath()))){
			
			String line;
			
			while((line = br.readLine()) != null) {
				String[] allTheThings = line.split(":");
				
				System.out.println("Name: " + allTheThings[0] + " " + allTheThings[1]
						+ "\nAge: " + allTheThings[2]
						+ "\nState: " + allTheThings[3]);
			}
			
		}catch(IOException e) {
			System.out.println("There was no file found.");
		}
	}
}
