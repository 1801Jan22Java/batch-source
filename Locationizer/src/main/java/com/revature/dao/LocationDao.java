package com.revature.dao;

import java.util.List;

import com.revature.domain.Location;

public interface LocationDao {

	public List<Location> getLocations();

	public Location getLocationById(int id);

	public int createLocation(Location u);

	public int updateLocation(Location u);

	public int deleteLocation(Location u);

}
