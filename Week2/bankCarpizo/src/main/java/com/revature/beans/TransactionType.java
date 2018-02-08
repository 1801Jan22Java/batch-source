package com.revature.beans;

public class TransactionType 
{
	private int id;
	private String name;
	
	public TransactionType()
	{
		super();
	}
	
	public TransactionType(String name)
	{
		super();
		this.name = name;
	}
	
	public TransactionType(int id,String name)
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
		return "Transaction Type Info:\n\tID: " + id + "\n\tName: " + name;
	}
}
