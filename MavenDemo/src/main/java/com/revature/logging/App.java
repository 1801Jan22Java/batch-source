package com.revature.logging;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		
		LoggingClass lc = new LoggingClass();
		lc.allTheLogs();
		
		try {
			divide(1,0);
		}catch(Exception e) {
			lc.giveFatal(e);
		}
	}
	
	public static int divide(int a,int b) {
		return a/b;
	}

}
