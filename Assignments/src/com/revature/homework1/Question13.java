package com.revature.homework1;

public class Question13 {

	public static void main(String[] args) {

		int lines = 0;
		StringBuilder string = new StringBuilder();
		boolean booleanVal = true;
		
		
		while (lines != 4) {
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


