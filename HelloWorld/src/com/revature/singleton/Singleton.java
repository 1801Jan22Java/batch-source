package com.revature.singleton;

public class Singleton {
	private String hi = "This object has been stored in main memory for global access.\n";
	private static Singleton instance = null;
	private Singleton() {}
	public static Singleton getInstance() {
		if (instance == null) {
			System.out.println("Object Not Instantiated... Instantiating.");
			instance = new Singleton();
		} else {
			System.out.println("Sorry, object is already instantiated.");
		}
		return instance;
	}
	
	public String getHi() {
		return hi;
	}
	public void setHi(String hi) {
		this.hi = hi;
	}
	   
}