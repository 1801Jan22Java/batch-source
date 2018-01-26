package com.revature.abstraction;

public enum ClassType {
	JAVA ("all hail java"),
	CSHARP ("something"),
	SDET("nnjnk");
	
	private String details;

	ClassType(String details)
	{
		this.details = details;
	}
}
