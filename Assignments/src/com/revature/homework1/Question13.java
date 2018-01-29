package com.revature.homework1;

public class Question13 {

	public static void main(String[] args) {

		int lines = 0;
		StringBuilder string = new StringBuilder();
		boolean booleanVal = true;
		
		// starts at the 0th line and increments "lines" variable each time a 0 or 1 is added to the string
		
		while (lines != 4) {
			// these two while loops go back and forth calling each other
			while(booleanVal) {
				string.append("0 ");
				System.out.println(string.toString());
				lines += 1;
				booleanVal = false;
			}
			while(booleanVal == false) {
				string.append("1 ");
				System.out.println(string.toString());
				lines += 1;
				booleanVal = true;
			}
		}

			
		}

	}


