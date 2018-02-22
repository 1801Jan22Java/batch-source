package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="CATLOVER")
public class CatLover implements Serializable{
	
	public CatLover(int catLoverID, String name, String email, String password) {
		super();
		this.catLoverID = catLoverID;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public CatLover(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public CatLover() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="catLoverSequence")
	@SequenceGenerator(allocationSize=1,name="catLoverSequence",sequenceName="SQ_CATLOVER_PK")	//sequenceName - how it shows up on SQL side
	@Column(name="CATLOVER_ID")
	private int catLoverID;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;

	@Column(name="PASSWORD")
	private String password;
	
	
	
	public int getCatLoverID() {
		return catLoverID;
	}
	public void setCatLoverID(int catLoverID) {
		this.catLoverID = catLoverID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "User [catLoverID=" + catLoverID + ", name=" + name + ", email=" + email + ", password=" + password
				+ "]";
	}
}
