package com.revature.abstraction;

public enum ClassType {
	JAVA("Oracle has nice documentation"),
	CSHARP("Our documentation is inferior"),
	SDET("Your code is broken");
	
	private String details;
	
	ClassType(String details)
	{
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
