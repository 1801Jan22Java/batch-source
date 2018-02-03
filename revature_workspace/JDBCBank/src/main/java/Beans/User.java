package Beans;


public class User {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String ssn;
	private int superUser;
	private boolean loggedIn;
	
	
	public User()
	{}
	
	public User(String username, String password,String fname, String lname, String ssn)
	{
		this.username =username;
		this.password=password;
		this.firstname=fname;
		this.lastname=lname;
		this.ssn=ssn;
		this.loggedIn=false;
		this.superUser=0;
	}

	public void logIn(String username,String password)
	{
		if(username.equals(this.username)&&password.equals(this.password))
		{
			loggedIn=true;
		}
		else
		{
			loggedIn=false;
		}
	}
	
	public boolean getLoginStatus()
	{
		return loggedIn;
	}
	public String getUserName()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	
	public String getFirstName()
	{
		return firstname;
	}
	
	public String getLastName()
	{
		return lastname;
	}
	
	public void setFirstName(String fName)
	{
		firstname= fName;
	}
	
	public void setLastName(String lName)
	{
		lastname=lName;
	}
	
	public String getSSN()
	{
		return ssn;
	}
	
	public int getSuperUser(){
		return superUser;
	}
	
	public CheckingAccount createCheckingAccount(float initialBalance)
	{
		CheckingAccount ca = new CheckingAccount(initialBalance);
		return ca;
	}
	
	public SavingsAccount createSavingsAccount(float initialBalance)
	{
		SavingsAccount sa = new SavingsAccount(initialBalance);
		return sa;
	}
	
	

}
