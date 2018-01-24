package com.revature.abstraction;

public enum ClassType {
	
	JAVA("all hail oracle"),
	CSHARP("our documentation is inferior"),
	SDET("your code is broken");
	
	private String details;
	
	ClassType(String details){
		this.details = details;
	}
	
	public String getDetails() {
		return details;
	}
	
}
