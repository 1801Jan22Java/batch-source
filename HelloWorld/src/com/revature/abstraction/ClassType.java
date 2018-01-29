package com.revature.abstraction;
//ENUMs are a collection of constants
public enum ClassType 
{
	JAVA("all hail Oracle"),
	CSHARP("our documentation is inferior"),
	SDET("your code is broken");
	
	private String details;
	
	ClassType(String details)
	{
		this.details = details;
	}
	
	public String getDetails()
	{
		return details;
	}
}
