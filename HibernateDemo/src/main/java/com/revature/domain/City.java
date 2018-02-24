package com.revature.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity 
@Table(name="CITY")
public class City implements Serializable {

	public City(String name, double latitude, double longitude, State state) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.state = state;
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
	
	@Column(name="LONGITUDE")
	private double longitude;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STATE_ID")
	private State state;

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

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + ", state="
				+ state + "]";
	}
}
