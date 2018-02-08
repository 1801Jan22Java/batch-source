package com.revature.beans;

public class UserType 
{
	private int id;
	private String name;
	
	public UserType()
	{
		super();
	}
	
	public UserType(String name)
	{
		super();
		this.name = name;
	}
	
	public UserType(int id,String name)
	{
		super();
		this.id = id;
		this.name =name;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name =name;
	}
	
	public String toString() 
	{
		return "User Type Info:\n\tID: " + id + "\n\tName: " + name;
	}
}
