package beans;

import java.sql.Date;

public class UserInfo 
{
	public UserInfo(String firstName, String lastName, String state, String zip,Date birthDay, String address, String ssn, int userId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		State = state;
		this.birthDay = birthDay;
		this.address = address;
		this.ssn = ssn;
		this.userId = userId;
		this.zip=zip;
	}
	private String firstName;
	private String lastName;
	private String State;
	private Date birthDay;
	private String address;
	private String ssn;
	private int userId;
	private String zip;
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
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String toString()
	{
		return this.firstName+" "+this.lastName;
				
	}
}
