package com.revature.homework1;

import java.util.*;

public class Question13 {
	
	public static void triangle() {
		
		boolean printZero = true;
		
		for(int i = 0; i < 5; i++) {
			String str = "";
			for(int j = 0; j < i; j++) {
				if(printZero) {
					str += (0 + " ");
					
					printZero = !printZero;
				}
				else {
					str += (1 + " ");
					
					printZero = !printZero;
					
				}
			
			}
			System.out.println(str);
		}
			
	}
	
	public static void main(String[] args) {
		triangle();
	}

}
