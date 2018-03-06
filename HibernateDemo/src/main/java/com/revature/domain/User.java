package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;


//Creating Users table 
@Entity
@Table(name="USERS", uniqueConstraints=
@UniqueConstraint (columnNames= {"ID","USERNAME"}))
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//Generating UserId
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="UserSequence")
	@SequenceGenerator(allocationSize=1,name="UserSequence",sequenceName="SQ_USER_PK")
	@Column (name="ID")
	private int id;
	@Column (name="USERNAME", length=20)
	private String username;
	@Column (name="PASSWORD", length=20)
	private String password;
	@Column (name="EMAIL_ADDRESS", length=100)
	private String emailAddress;
	@Column (name="IMAGE_ID")
	private int imageId;
	@Column (name="IS_ADMIN")
	private boolean isAdmin;
	@Column (name="IS_ACTIVE")
	private boolean isActive;
	
	
	public User(String username, String password, String emailAddress, int imageId, boolean isAdmin,
			boolean isActive) {
		super();
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.imageId = imageId;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}
	public User(int id, String username, String password, String emailAddress, int imageId, boolean isAdmin,
			boolean isActive) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.imageId = imageId;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getProfileImageURL() {
		return imageId;
	}
	public void setProfileImageURL(int imageId) {
		this.imageId = imageId;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UserID=" + id + ", Username=" + username + ", Email Address=" + emailAddress
				+ ", Image ID=" + imageId + ", Is admin? " + isAdmin + ", Active? " + isActive + "]";
	}
	
}
