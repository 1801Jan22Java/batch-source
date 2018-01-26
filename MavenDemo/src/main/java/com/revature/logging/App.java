package com.revature.logging;

public class App {

	public static void main(String[] args) {
		
		System.out.println("hello world");
<<<<<<< HEAD
	
		LoggingClass lc = new LoggingClass();
		lc.allTheLogs();
		
		try {
			divide(1, 0);
			
		} catch (Exception e) {
			lc.giveFatal(e);
		}
		
	}
	
	
	public static int divide(int a, int b) {
		return a/b;
	}
=======
		
		LoggingClass lc = new LoggingClass();
		lc.allTheLogs();
		
		try{
			divide(1,0);
		} catch (Exception e){
			lc.giveFatal(e);
		}

	}
	
	public static int divide(int a, int b){
		return a/b;
	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
