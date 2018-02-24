package com.revature.dao;

import com.revature.domain.City;

public interface CityDao {

	public City getCityById(int id);
	public int addCity(City c);
}
