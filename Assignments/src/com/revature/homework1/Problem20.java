package com.revature.homework1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Problem20 {
	public static void main(String[] args) {
		File file = new File("test.txt");
		String line = "";
		String [] words;
		//System.out.print(file.getAbsolutePath());
		
		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
			while(in.hasNextLine()) {
				line =in.nextLine();
				words = line.split(":");
				System.out.println("Name: "+ words[0]+ " " +words[1]+"\n"
						+"Age: "+words[2]+"\n"+
						"State: "+words[3]+"\n");
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
