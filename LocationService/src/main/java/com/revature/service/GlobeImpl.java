package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Location;

public class GlobeImpl implements Globe {
	
	List<Location> locations = new ArrayList<>();

	@Override
	public void addLocation(Location l) {
		locations.add(l);
	}

	@Override
	public void addTwoLocations(Location l1, Location l2) {
		this.addLocation(l1);
		this.addLocation(l2);
	}
	
	@Override
	public List<Location> getLocations() {
		return new ArrayList<>(locations);
	}

}
