package com.revature.dao;

import java.util.List;

import com.revature.domains.Location;

public interface LocationDao {
	public List<Location> getAll();
	public Location getById(int id);
	public int add(Location location);
	public void delete(Location location);
	public void merge(Location location);
	public void saveOrUpdate(Location location);
}
