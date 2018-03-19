package com.revature.model;

public class Location {

	private String name;
	private String country;
	private int latitude;
	private int longitude;
	
	public Location() {
		
	}

	public Location(String name, String country, int latitude, int longitude) {
		super();
		this.name = name;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", country=" + country + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}
	
}
