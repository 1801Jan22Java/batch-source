package com.revature.domains;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="LOCATIONS")
public class Locations implements Serializable{

	public Locations() {}
	
	public Locations(String street, String city, String state, int zipcode, List<Animals> animals) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.animals = animals;
	}
	
	public Locations(int locID, String street, String city, String state, int zipcode, List<Animals> animals) {
		super();
		this.locID = locID;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.animals = animals;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="locationsSequence")
	@SequenceGenerator(allocationSize=1,name="locationsSequence",sequenceName="SQ_LOCATIONS_PK")
	private int locID; //pk
	@Column(name = "STREET")
	private String street;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "ZIPCODE")
	private int zipcode;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "animalID")
	private List<Animals> animals;
	
	public int getLocID() {
		return locID;
	}

	public void setLocID(int locID) {
		this.locID = locID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	
	public List<Animals> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animals> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "Locations [locID=" + locID + ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", animals=" + animals + "]";
	}
}
