package com.revature.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity 
@Table(name="CITY")
public class City implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public City(String name, int population, double latitude, double longitude, State state, Country country) {
		super();
		this.name = name;
		this.population = population;
		this.latitude = latitude;
		this.longitude = longitude;
		this.state = state;
		this.country = country;
	}

	public City() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="citySequence")
	@SequenceGenerator(allocationSize=1,name="citySequence",sequenceName="CITY_S1")
	@Column(name="CITY_ID")
	private int id;
	
	@Column(name="CITY_NAME")
	private String name;
	
	@Column(name="LATITUDE")
	private double latitude;
	
	@Column(name="POPULATION")
	private int population;
	
	@Column(name="LONGITUDE")
	private double longitude;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STATE_ID")
	private State state;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", latitude=" + latitude + ", population=" + population
				+ ", longitude=" + longitude + ", state=" + state + ", country=" + country + "]";
	}

	

}
