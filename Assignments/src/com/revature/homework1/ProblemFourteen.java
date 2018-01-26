package com.revature.homework1;

import java.util.Calendar;
import java.util.Date;

public class ProblemFourteen {
	
	@SuppressWarnings("deprecation")
	public static void Switcheroo(int number) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		switch(number) {
			case 1:{
				Math.sqrt(4);
			}
			case 2: {
				System.out.println(today.getTime());
				
			}
			case 3:{
				String stuff = "I am Learning Core Java";
				String[] more_stuff = stuff.split(" ");
				
			}
		}
	}
	
	public static void main(String args[]) {
		Switcheroo(2);
	}

}
