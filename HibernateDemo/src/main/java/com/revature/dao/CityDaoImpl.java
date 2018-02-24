package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.domain.*;
import com.revature.util.HibernateUtil;

public class CityDaoImpl implements CityDao {

	@Override
	public City getCityById(int id) {
		Session s = HibernateUtil.getSession();
		City thisCity = (City) s.get(City.class, id);
		s.close();
		return thisCity;
	}
	
	@Override
	public List<City> getAllCities() {
		Session s = HibernateUtil.getSession();
		List<City> cities = s.createQuery("from City").list();
		s.close();
		return cities;
	}
	
	@Override
	public City getCityByName(String cityName, State thisState) {
		
		Session s = HibernateUtil.getSession();
		
		City thisCity = null;
		if (thisState != null ) {
			try {
				Criteria c = s.createCriteria(City.class);
				c.add(Restrictions.eq("name", cityName));
				c.add(Restrictions.eq("state", thisState));
				List<City> cities = c.list();
				thisCity = (City) cities.get(0);
			} catch (Exception e) {
				// This state could not be found
				thisState = null;
				thisCity = null;
			}
		}
		s.close();
		return thisCity;
	}

	@Override
	public int addCity(City thisCity) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(thisCity);
		try {
			tx.commit();
		} catch (Exception e) {
			result = 0;
			tx.rollback();
		}
		return result;
	}
	
	@Override
	public double distanceBetween(City departure, City arrival) {
		/** @author David George
		 * Calculate distance between two points in latitude and longitude taking
		 * into account height difference. If you are not interested in height
		 * difference pass 0.0. Uses Haversine method as its base.
		 * 
		 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
		 * el2 End altitude in meters
		 * @returns Distance in Meters
		 */
		double lat1 = departure.getLatitude();
		double lat2 = arrival.getLatitude();
		double lon1 = departure.getLongitude();
		double lon2 = arrival.getLongitude();
		double el1 = 0.0;
		double el2 = 0.0;

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    double distanceInMeters = Math.sqrt(distance);
	    double distanceInKilometers = distanceInMeters / 1000.0;
	    double distanceInMiles = (distanceInKilometers / 2) + ( (distanceInKilometers / 2) / 4);
	    return distanceInMiles;
		
	}

}
