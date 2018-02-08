package com.revature.beans;

public abstract class User
{
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private UserType userType;
	
	public User(){}

	public User(String firstName, String lastName, String username, String password, UserType userType)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userType = userType;
		
	}

	public User(int id, String firstName, String lastName, String username, String password, UserType userType)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public UserType getUserType() 
	{
		return userType;
	}

	public void setUserType(UserType userType) 
	{
		this.userType = userType;
	}

	public String toString()
	{
		if(id!=0)
			return "User info:\n\tFirst Name: " + firstName + "\n\tLast Name: " + lastName + "\n\tUsername: " + username + "\n\tPassword: " + password + "\n\t" + userType;
		else
			return "User info:\n\tUser ID: " + id + "\n\tFirst Name: " + firstName + "\n\tLast Name: " + lastName + "\n\tUsername: " + username + "\n\tFirst Name: " + firstName + "\n\tLast Name: " + lastName + "\n\tPassword: " + password + "\n\tType of user: " + userType;

	}

}
