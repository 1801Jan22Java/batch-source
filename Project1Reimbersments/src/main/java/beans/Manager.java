package beans;

import java.io.File;

public class Manager 
{
	public Manager(int managerId, int manager, int employeeId, String firstName, String lastName, String email,
			String userName, String passWord, File profilePicture) {
		super();
		this.managerId = managerId;
		this.manager = manager;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.passWord = passWord;
		this.profilePicture = profilePicture;
	}
	private int managerId;
	private int manager;
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String passWord;
	private File profilePicture;
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public File getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(File profilePicture) {
		this.profilePicture = profilePicture;
	}
}
