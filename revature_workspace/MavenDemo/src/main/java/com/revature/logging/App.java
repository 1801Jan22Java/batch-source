package com.revature.logging;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Hello world");
		
		LoggingClass lc = new LoggingClass();
		lc.allTheLogs();
		try {
			divide(5,0);
		}
		catch(LoggingClass lc){
			lc.giveFatal();
		}
	}
	
	public static int divide(int a, int b)
	{
		return a/b;
	}

}
