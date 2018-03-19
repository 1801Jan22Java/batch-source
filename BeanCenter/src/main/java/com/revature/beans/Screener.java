package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="SCREENER")
public class Screener {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="screenerSequence")
	@SequenceGenerator(allocationSize=1,name="screenerSequence",sequenceName="SCREENER_S1")
	@Column(name="SCREENER_ID")
	private Integer id;
	
	@Column(name="FIRSTNAME")
	String firstName;
	
	@Column(name="LASTNAME")
	String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
}
