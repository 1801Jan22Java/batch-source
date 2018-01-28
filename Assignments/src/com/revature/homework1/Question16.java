package com.revature.homework1;

/*
 * Write a program to display the number of characters for a string input. The string should
be entered as a command line argument using (String [ ] args).
 */

public class Question16 {

	public Question16(String str) {
		super();
		this.str = str;
	}

	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	public void doThing() {
		System.out.println("Length of " + str + " is " + str.length());
	}
	
}
