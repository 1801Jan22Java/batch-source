package com.revature.dao;

import java.util.List;

import com.revature.domain.City;
import com.revature.domain.State;

public interface CityDao {

	public City getCityById(int id);
	public int addCity(City c);
	public double distanceBetween(City departure, City arrival);
	public City getCityByName(String cityName, State thisState);
	public List<City> getAllCities();
}
