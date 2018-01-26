package com.revature.homework1;

import java.io.*;
public class Question20 {

	public static void main(String[] args) {
		
		String filename = "src/Data.txt";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String[] s = new String[4];
			for(int i=0; i<4; i++) {
				s[i] = br.readLine();
				String[] result = s[i].split(":");
				System.out.println("Name: "+result[0]+" "+result[1]);
				System.out.println("Age: "+result[2]);
				System.out.println("State: "+result[3]);
				System.out.println();
			}
			br.close();
			
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
}
