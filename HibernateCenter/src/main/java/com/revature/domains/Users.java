package com.revature.domains;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class Users implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="usersSequence")
	@SequenceGenerator(allocationSize=1,name="usersSequence",sequenceName="SQ_USERS_PK")
	@Column(name="USER_ID")
	private int userID; //pk
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="FIRSTNAME")
	private String firstname;
	@Column(name="LASTNAME")
	private String lastname;
	@Column(name="PHONE_NUMBER")
	private int phonenumber;
	@OneToOne
	@JoinColumn(name="locID")
	private Locations location; //fk to locID of table locations
	@JoinColumn(name="lookupID")
	private LookupTable isEmployee; //fk to lookupID for lookup table
	
	public Users() {}

	public Users(String email, String password, String firstname, String lastname, int phonenumber,
			Locations location, LookupTable isEmployee) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.location = location;
		this.isEmployee = isEmployee;
	}
	
	public Users(int userID, String email, String password, String firstname, String lastname, int phonenumber,
			Locations location, LookupTable isEmployee) {
		super();
		this.userID = userID;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.location = location;
		this.isEmployee = isEmployee;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Locations getLocation() {
		return location;
	}

	public void setLocation(Locations location) {
		this.location = location;
	}

	public LookupTable getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(LookupTable isEmployee) {
		this.isEmployee = isEmployee;
	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", phonenumber=" + phonenumber + ", location=" + location + ", isEmployee="
				+ isEmployee + "]";
	}
}
