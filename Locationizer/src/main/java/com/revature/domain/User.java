package com.revature.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="USER")
public class User implements Serializable {
	
	public User() {super();}
	
	public User(int username, int password) {
		this();
		this.username = username;
		this.password = password;
	}


	public User(int id, int username, int password) {
		this(username, password);
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userSequence")
	@SequenceGenerator(allocationSize=1,name="userSequence",sequenceName="SQ_USER_PK")
	@Column(name="U_ID")
	int id;
	
	@Column(name="USERNAME")
	int username;
	
	@Column(name="PASS")
	int password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
