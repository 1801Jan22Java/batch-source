package com.revature.homework1;

public class Question13 {
	
	public static void printTriangle() {
		String str = "0";
		for(int j = 0; j < 4; j++) {
			System.out.println(str);
			String[] strArray = str.split(" ");
			
			if(strArray.length % 2 == 0) {
				str = str + " 1";
			} else if(strArray[0] == "0"){
				str = "1 " + str;
			} else {
				str = "0 " + str;
			}
		}
	}
}
