package com.revature.hello;

public class SwitchStatementExample {
	public static void main(String[] args) {
		String color = "purple";
		String components;
		
		switch (color) {
			case "green":
				components = "yellow and blue";
				break;
			
			case "purple":
				components = "red and blue";
				break;
				
			case "orange":
				components = "yellow and red";
				break;
				
			default:
				components = "undefined";
				break;
		}
	}
}
