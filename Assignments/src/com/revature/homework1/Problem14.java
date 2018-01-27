package com.revature.homework1;

import java.util.Calendar;

public class Problem14 {
	
	public static void Switcheroo(int number) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		switch(number) {
			case 1:{
				Math.sqrt(4);
				break;
			}
			case 2: {
				System.out.println(today.getTime());
				break;
				
			}
			case 3:{
				String stuff = "I am Learning Core Java";
				String[] more_stuff = stuff.split(" ");
				for(String s: more_stuff) {
					System.out.println(s);
				}
				break;
				
			}
			default : System.out.println("Error 404 Code Not Found !!"); break;
		}
	}
	
	public static void main(String args[]) {
		Switcheroo(2);
	}

}
