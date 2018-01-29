package com.revature.homework1;

import java.io.*;

class Question20{
	public static void main(String[] args) throws Exception{
	File file = new File("C:\\Users\\Documents\\Data.txt");
	BufferedReader br = new BufferedReader(new FileReader(file));
	String st;
	while ( (st = br.readLine()) != null) {
		printOutput(st);
	 }
	}
	
	static void printOutput(String unformatted) {
		String[] data = unformatted.split(":");
		System.out.println("Name: "+ data[0]+" "+ data[1]);
		System.out.println("Age: "+ data[2]+" years");
		System.out.println("State: "+ data[3]+ " State \n" );
	}
}