package com.revature.beans;

public class AccountType 
{
	private int id;
	private String name;
	
	public AccountType()
	{
		super();
	}
	
	public AccountType(String name)
	{
		super();
		this.name = name;
	}
	
	public AccountType(int id,String name)
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
		return "Account Type Info:\n\tID: " + id + "\n\tName: " + name;
	}
}
