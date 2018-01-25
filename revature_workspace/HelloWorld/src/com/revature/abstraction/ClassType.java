package com.revature.abstraction;

public enum ClassType {
	
	JAVA("all hail Oracle",3),
	CSHARP("our documentation is inferior",3),
	SDET("your code is broken",1);
	
	private String details;
	private int number;
	
	ClassType(String details,int nummer)
	{
		this.details = details;
		this.number = nummer;
	}
	
	public String getDetails()
	{
		return details +"\n"+ number;
	}
	
	
	

}
