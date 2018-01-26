package com.revature.abstraction;

public enum ClassType {
	
<<<<<<< HEAD
	JAVA("all hail Oracle"),
	CSHARP("our documentation is inferior"),
	SDET("your code is broken");
	
	private String details;
	
	private ClassType(String details) {
		this.details = details;
	}
	
	public String getDetails() {
		return details;
	}
=======
	
	JAVA("all hail Oracle",7),
	CSHARP("our documentation is inferior",8),
	SDET("your code is broken",9);
	
	private String details;
	private int number;
	
	ClassType(String details, int number){
		this.details = details;
		this.number = number;
	}
	
	public String getDetails(){
		return details;
	}
	
	//you don't need any of the extra fields! This is adequate:
	//JAVA, CSHARP, SDET;

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
