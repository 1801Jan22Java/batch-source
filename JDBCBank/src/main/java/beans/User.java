package beans;

import java.sql.Date;

public class User 
{
	public User(int userId, int SuperUser, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.setPassword(password);
		this.superUser = SuperUser;
	}
	private int userId;
	private String userName;
	private int superUser;
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String toString()
	{
		return this.userName +" "+this.password;
	}
	public int getSuperUser() {
		return superUser;
	}
	public void setSuperUser(int superUser) {
		this.superUser = superUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
