package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.model.Location;

@WebService 
public interface Globe {

	public void addLocation(Location l);
	public void addTwoLocations(Location l1, Location l2);
	public List<Location> getLocations();
	
}
