package com.revature.logging;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello World");
		Logging l = new Logging();
		l.allTheLogs();
		try {
			divide(2, 0);
		} catch (Exception e) {
			l.giveFatal(e);
		}
	}
	
	public static int divide(int a, int b) {
		return a / b;
	}

}
