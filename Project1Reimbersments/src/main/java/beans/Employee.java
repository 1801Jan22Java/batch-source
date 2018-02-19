package beans;

import java.io.File;
import java.sql.Blob;

public class Employee 
{
	public Employee(int employeeId, String firstName, String lastName, String email, String userName, String password,
			int managerId, byte[] profilePic) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.managerId = managerId;
		this.profilePic = profilePic;
	}
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private int managerId;
	private byte[] profilePic;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public byte[] getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}
	public String toString()
	{
		return this.getFirstName()+" "+this.getLastName()+" "+this.getProfilePic();
	}
}
