package com.revature.domain;

import java.io.Serializable;
import javax.persistence.*;

public class Location implements Serializable {

	public Location() {super();}
	
	public Location(String name) {
		this();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="locationSequence")
	@SequenceGenerator(allocationSize=1,name="locationSequence",sequenceName="SQ_LOCATION_PK")
	@Column(name="L_ID")
	int id;
	
	@Column(name="NAME")
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + "]";
	}
	
}
