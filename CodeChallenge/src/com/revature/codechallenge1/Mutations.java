package com.revature.codechallenge1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Mutations {

	private static String begin;
	private static String current = "";
	private static String end;
	private static MutationBank bank = new MutationBank();

	public Mutations() {
	}

	public Mutations(String begin, String end) {
		this.begin = begin;
		this.end = end;
	}

	// reading in from file
	public static void addBank(String filename) {

		FileInputStream fin;
		try {

			fin = new FileInputStream(filename);
			BufferedInputStream bin = new BufferedInputStream(fin);

			int ch;
			String str = "";
			while ((ch = bin.read()) != -1) {
				if ((char) ch == ' ') {
					System.out.println(str);
					bank.addMutation(str);
					str = "";
					continue;
				}
				str += Character.toString((char) ch);
			}
			if(str != "") {
				System.out.println(str);
				bank.addMutation(str);
			}
			fin.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public int searchMutation(String[] strList) {
		
		return -1;
	}
	
	// algorithm to check if you have a valid mutation between the two
	public int validMutation() {
		
		current = "";
		// if the ending gene string is within the gene bank it is possible
		if (bank.isValid(end)) {
			
			int valid = -1;
			// 
			for(int i = 0; i < end.length(); i++) {
				//where there is a difference you look to see if the mutation is available
				// doesnt matter everything after, just check if it is available within the bank
				// keep building the current string until it is the same as the begin string
				if(end.charAt(i) != begin.charAt(i)) {
					current += Character.toString(begin.charAt(i));
					//check if valid
				}
				
				//build the current string
				else {
					current += Character.toString(end.charAt(i));
				}
				
			}
			
			
		}
		// the mutation cannot occur so return -1
		return -1;
	}

}
