package com.revature.driver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

		// init();

		// FlashcardDao fd = new FlashcardDaoImpl();

		// saveAndPersist(fd);

		// fd.getFlashcards();

		// updateAndMerge();

		// Category c1 = new Category (1, "coding");
		// funWithNamedQueries(c1);

		// funWithCache();

		// animalInit();

		//stateInit();
		
		
//		CityDao cd = new CityDaoImpl();
//		StateDao sd = new StateDaoImpl();
//		State myState = sd.getStateByName("Alabama");
//		System.out.println(myState.toString());
		//usCityInit();
		//routeInit();
		//allRoutes();
		
		//countryInit();
		intlCityInit();

	}
	
	static void routeInit() {
		StateDao sd = new StateDaoImpl();
		CityDao cd = new CityDaoImpl();
		
		City departureCity = null;
		State departureState = null;
		departureState = sd.getStateByName("Alabama");
		departureCity = cd.getCityByName("Birmingham", departureState);
		
		
		City arrivalCity = null;
		State arrivalState = null;
		arrivalState = sd.getStateByName("Virginia");
		arrivalCity = cd.getCityByName("Richmond", arrivalState);
		
		double distance = cd.distanceBetween(departureCity, arrivalCity);
		System.out.println("Distance between Birmingham and Richmond is " + distance);
		
	}
	
	static void allRoutes() {
		CityDao cd = new CityDaoImpl();
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("routes.csv", true));
			ArrayList<City> cities = (ArrayList<City>) cd.getAllCities();
			for (int i = 0; i < cities.size(); i++) {
				System.out.println("checking " + cities.get(i).getName() + ", " + cities.get(i).getState().getName());
				for (int j = i; j < cities.size(); j++) {
					String line = cd.distanceBetween(cities.get(i), cities.get(j)) + "," + 
								cities.get(i).getName() + "," + 
								cities.get(i).getState().getName() + "," +
								cities.get(j).getName() + "," + 
								cities.get(j).getState().getName();
					bw.write(line);
					bw.newLine();
					
				}
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOEXCEPTION");
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Problem closing Buffered Writer");
				e.printStackTrace();
			}
		}
	}
	
	static void stateInit() {
		StateDao sd = new StateDaoImpl();
		State[] states = {
				new State("Alabama"),
				new State("Alaska"),
				new State("Arizona"),
				new State("Arkansas"),
				new State("California"),
				new State("Colorado"),
				new State("Connecticut"),
				new State("Delaware"),
				new State("District of Columbia"),
				new State("Florida"),
				new State("Georgia"),
				new State("Hawaii"),
				new State("Idaho"),
				new State("Illinois"),
				new State("Indiana"),
				new State("Iowa"),
				new State("Kansas"),
				new State("Kentucky"),
				new State("Louisiana"),
				new State("Maine"),
				new State("Maryland"),
				new State("Massachusetts"),
				new State("Michigan"),
				new State("Minnesota"),
				new State("Mississippi"),
				new State("Missouri"),
				new State("Montana"),
				new State("Nebraska"),
				new State("Nevada"),
				new State("New Hampshire"),
				new State("New Jersey"),
				new State("New Mexico"),
				new State("New York"),
				new State("North Carolina"),
				new State("North Dakota"),
				new State("Ohio"),
				new State("Oklahoma"),
				new State("Oregon"),
				new State("Pennsylvania"),
				new State("Rhode Island"),
				new State("South Carolina"),
				new State("South Dakota"),
				new State("Tennessee"),
				new State("Texas"),
				new State("Utah"),
				new State("Vermont"),
				new State("Virginia"),
				new State("Washington"),
				new State("West Virginia"),
				new State("Wisconsin"),
				new State("Wyoming")
		};
		
		for (State s : states) {
			System.out.println("adding " + s.getName());
			s.setId(sd.addState(s));
		}
	}
	
	static void countryInit() {
		CountryDao cd = new CountryDaoImpl();
		Country[] countries = {
				new Country("Afghanistan"),
				new Country("Algeria"),
				new Country("Angola"),
				new Country("Argentina"),
				new Country("Armenia"),
				new Country("Australia"),
				new Country("Austria"),
				new Country("Azerbaijan"),
				new Country("Bangladesh"),
				new Country("Belarus"),
				new Country("Bolivia"),
				new Country("Brazil"),
				new Country("Bulgaria"),
				new Country("Burkina Faso"),
				new Country("Cambodia"),
				new Country("Cameroon"),
				new Country("Canada"),
				new Country("Chile"),
				new Country("China"),
				new Country("Colombia"),
				new Country("Congo Republic"),
				new Country("Cuba"),
				new Country("Czech Republic"),
				new Country("DR Congo"),
				new Country("Ecuador"),
				new Country("Egypt"),
				new Country("Ethiopia"),
				new Country("France"),
				new Country("Georgia"),
				new Country("Germany"),
				new Country("Ghana"),
				new Country("Guatemala"),
				new Country("Hungary"),
				new Country("India"),
				new Country("Indonesia"),
				new Country("Iran"),
				new Country("Iraq"),
				new Country("Italy"),
				new Country("Ivory Coast"),
				new Country("Japan"),
				new Country("Kazakhstan"),
				new Country("Kenya"),
				new Country("North Korea"),
				new Country("South Korea"),
				new Country("Libya"),
				new Country("Malaysia"),
				new Country("Mexico"),
				new Country("Morocco"),
				new Country("Mozambique"),
				new Country("Myanmar"),
				new Country("Nepal"),
				new Country("New Zealand"),
				new Country("Nicaragua"),
				new Country("Nigeria"),
				new Country("Pakistan"),
				new Country("Peru"),
				new Country("Philippines"),
				new Country("Poland"),
				new Country("Romania"),
				new Country("Russia"),
				new Country("Saudi Arabia"),
				new Country("Senegal"),
				new Country("Serbia"),
				new Country("Singapore"),
				new Country("South Africa"),
				new Country("Spain"),
				new Country("Sudan"),
				new Country("Taiwan"),
				new Country("Tanzania"),
				new Country("Thailand"),
				new Country("Tunisia"),
				new Country("Turkey"),
				new Country("Uganda"),
				new Country("Ukraine"),
				new Country("United Arab Emirates"),
				new Country("United Kingdom"),
				new Country("United States"),
				new Country("Uruguay"),
				new Country("Uzbekistan"),
				new Country("Venezuela"),
				new Country("Vietnam"),
				new Country("Yemen"),
				new Country("Zambia"),
				new Country("Zimbabwe")
		};
		
		for (Country c : countries) {
			System.out.println("adding " + c.getName());
			c.setId(cd.addCountry(c));
		}
	}
	
	static void usCityInit() {
		StateDao sd = new StateDaoImpl();
		CityDao cd = new CityDaoImpl();
		CountryDao cod = new CountryDaoImpl();
		City[] cities = {
				new City("New York", 8537673, 40.6635, -73.9387, sd.getStateByName( "New York"), cod.getCountryByName("United States") ),
				new City("Los Angeles", 3976322, 34.0194, -118.4108, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Chicago", 2704958, 41.8376, -87.6818, sd.getStateByName( "Illinois"), cod.getCountryByName("United States") ),
				new City("Houston", 2303482, 29.7866, -95.3909, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Phoenix", 1615017, 33.5722, -112.0901, sd.getStateByName( "Arizona"), cod.getCountryByName("United States") ),
				new City("Philadelphia", 1567872, 40.0094, -75.1333, sd.getStateByName( "Pennsylvania"), cod.getCountryByName("United States") ),
				new City("San Antonio", 1492510, 29.4724, -98.5251, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("San Diego", 1406630, 32.8153, -117.135, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Dallas", 1317929, 32.7933, -96.7665, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("San Jose", 1025350, 37.2967, -121.8189, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Austin", 947890, 30.3039, -97.7544, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Jacksonville", 880619, 30.3369, -81.6616, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("San Francisco", 870887, 37.7272, -123.0322, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Columbus", 860090, 39.9852, -82.9848, sd.getStateByName( "Ohio"), cod.getCountryByName("United States") ),
				new City("Indianapolis", 855164, 39.7767, -86.1459, sd.getStateByName( "Indiana"), cod.getCountryByName("United States") ),
				new City("Fort Worth", 854113, 32.7815, -97.3467, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Charlotte", 842051, 35.2078, -80.831, sd.getStateByName( "North Carolina"), cod.getCountryByName("United States") ),
				new City("Seattle", 704352, 47.6205, -122.3509, sd.getStateByName( "Washington"), cod.getCountryByName("United States") ),
				new City("Denver", 693060, 39.7619, -104.8811, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("El Paso", 683080, 31.8484, -106.427, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Washington", 681170, 38.9041, -77.0172, sd.getStateByName( "District of Columbia"), cod.getCountryByName("United States") ),
				new City("Boston", 673184, 42.332, -71.0202, sd.getStateByName( "Massachusetts"), cod.getCountryByName("United States") ),
				new City("Detroit", 672795, 42.383, -83.1022, sd.getStateByName( "Michigan"), cod.getCountryByName("United States") ),
				new City("Nashville", 660388, 36.1718, -86.785, sd.getStateByName( "Tennessee"), cod.getCountryByName("United States") ),
				new City("Memphis", 652717, 35.1028, -89.9774, sd.getStateByName( "Tennessee"), cod.getCountryByName("United States") ),
				new City("Portland", 639863, 45.537, -122.65, sd.getStateByName( "Oregon"), cod.getCountryByName("United States") ),
				new City("Oklahoma City", 638367, 35.4671, -97.5137, sd.getStateByName( "Oklahoma"), cod.getCountryByName("United States") ),
				new City("Las Vegas", 632912, 36.2292, -115.2601, sd.getStateByName( "Nevada"), cod.getCountryByName("United States") ),
				new City("Louisville", 616261, 38.1654, -85.6474, sd.getStateByName( "Kentucky"), cod.getCountryByName("United States") ),
				new City("Baltimore", 614664, 39.3, -76.6105, sd.getStateByName( "Maryland"), cod.getCountryByName("United States") ),
				new City("Milwaukee", 595047, 43.0633, -87.9667, sd.getStateByName( "Wisconsin"), cod.getCountryByName("United States") ),
				new City("Albuquerque", 559277, 35.1056, -106.6474, sd.getStateByName( "New Mexico"), cod.getCountryByName("United States") ),
				new City("Tucson", 530706, 32.1531, -110.8706, sd.getStateByName( "Arizona"), cod.getCountryByName("United States") ),
				new City("Fresno", 522053, 36.7836, -119.7934, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Sacramento", 495234, 38.5666, -121.4686, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Mesa", 484587, 33.4019, -111.7174, sd.getStateByName( "Arizona"), cod.getCountryByName("United States") ),
				new City("Kansas City", 481420, 39.1251, -94.551, sd.getStateByName( "Missouri"), cod.getCountryByName("United States") ),
				new City("Atlanta", 472522, 33.7629, -84.4227, sd.getStateByName( "Georgia"), cod.getCountryByName("United States") ),
				new City("Long Beach", 470130, 33.8092, -118.1553, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Colorado Springs", 465101, 38.8673, -104.7607, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("Raleigh", 458880, 35.8306, -78.6418, sd.getStateByName( "North Carolina"), cod.getCountryByName("United States") ),
				new City("Miami", 453579, 25.7752, -80.2086, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Virginia Beach", 452602, 36.78, -76.0252, sd.getStateByName( "Virginia"), cod.getCountryByName("United States") ),
				new City("Omaha", 446970, 41.2644, -96.0451, sd.getStateByName( "Nebraska"), cod.getCountryByName("United States") ),
				new City("Oakland", 420005, 37.7698, -122.2257, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Minneapolis", 413651, 44.9633, -93.2683, sd.getStateByName( "Minnesota"), cod.getCountryByName("United States") ),
				new City("Tulsa", 403090, 36.1279, -95.9023, sd.getStateByName( "Oklahoma"), cod.getCountryByName("United States") ),
				new City("Arlington", 392772, 32.7007, -97.1247, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("New Orleans", 391495, 30.0534, -89.9345, sd.getStateByName( "Louisiana"), cod.getCountryByName("United States") ),
				new City("Wichita", 389902, 37.6907, -97.3459, sd.getStateByName( "Kansas"), cod.getCountryByName("United States") ),
				new City("Cleveland", 385809, 41.4785, -81.6794, sd.getStateByName( "Ohio"), cod.getCountryByName("United States") ),
				new City("Tampa", 377165, 27.9701, -82.4797, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Bakersfield", 376380, 35.3212, -119.0183, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Aurora", 361710, 39.688, -104.6897, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("Honolulu", 351792, 21.3243, -157.8476, sd.getStateByName( "Hawaii"), cod.getCountryByName("United States") ),
				new City("Anaheim", 351043, 33.8555, -117.7601, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Santa Ana", 334217, 33.7363, -117.883, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Corpus Christi", 325733, 27.7543, -97.1734, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Riverside", 324722, 33.9381, -117.3932, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Lexington", 318449, 38.0407, -84.4583, sd.getStateByName( "Kentucky"), cod.getCountryByName("United States") ),
				new City("St. Louis", 311404, 38.6357, -90.2446, sd.getStateByName( "Missouri"), cod.getCountryByName("United States") ),
				new City("Stockton", 307072, 37.9763, -121.3133, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Pittsburgh", 303625, 40.4398, -79.9766, sd.getStateByName( "Pennsylvania"), cod.getCountryByName("United States") ),
				new City("Saint Paul", 302398, 44.9489, -93.1041, sd.getStateByName( "Minnesota"), cod.getCountryByName("United States") ),
				new City("Cincinnati", 298800, 39.1402, -84.5058, sd.getStateByName( "Ohio"), cod.getCountryByName("United States") ),
				new City("Anchorage", 298192, 61.1743, -149.2843, sd.getStateByName( "Alaska"), cod.getCountryByName("United States") ),
				new City("Henderson", 292969, 36.0097, -115.0357, sd.getStateByName( "Nevada"), cod.getCountryByName("United States") ),
				new City("Greensboro", 287027, 36.0951, -79.827, sd.getStateByName( "North Carolina"), cod.getCountryByName("United States") ),
				new City("Plano", 286057, 33.0508, -96.7479, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Newark", 281764, 40.7242, -74.1726, sd.getStateByName( "New Jersey"), cod.getCountryByName("United States") ),
				new City("Lincoln", 280364, 40.8105, -96.6803, sd.getStateByName( "Nebraska"), cod.getCountryByName("United States") ),
				new City("Toledo", 278508, 41.6641, -83.5819, sd.getStateByName( "Ohio"), cod.getCountryByName("United States") ),
				new City("Orlando", 277173, 28.4166, -81.2736, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Chula Vista", 267172, 32.6277, -117.0152, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Irvine", 266122, 33.6784, -117.7713, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Fort Wayne", 264488, 41.0882, -85.1439, sd.getStateByName( "Indiana"), cod.getCountryByName("United States") ),
				new City("Jersey City", 264152, 40.7114, -74.0648, sd.getStateByName( "New Jersey"), cod.getCountryByName("United States") ),
				new City("Durham", 263016, 35.9811, -78.9029, sd.getStateByName( "North Carolina"), cod.getCountryByName("United States") ),
				new City("St. Petersburg", 260999, 27.762, -82.6441, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Laredo", 257156, 27.5604, -99.4892, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Buffalo", 256902, 42.8925, -78.8597, sd.getStateByName( "New York"), cod.getCountryByName("United States") ),
				new City("Madison", 252551, 43.0878, -89.4299, sd.getStateByName( "Wisconsin"), cod.getCountryByName("United States") ),
				new City("Lubbock", 252506, 33.5656, -101.8867, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Chandler", 247477, 33.2829, -111.8549, sd.getStateByName( "Arizona"), cod.getCountryByName("United States") ),
				new City("Scottsdale", 246645, 33.6843, -111.8611, sd.getStateByName( "Arizona"), cod.getCountryByName("United States") ),
				new City("Glendale", 245895, 33.5331, -112.1899, sd.getStateByName( "Arizona"), cod.getCountryByName("United States") ),
				new City("Reno", 245255, 39.5491, -119.8499, sd.getStateByName( "Nevada"), cod.getCountryByName("United States") ),
				new City("Norfolk", 245115, 36.923, -76.2446, sd.getStateByName( "Virginia"), cod.getCountryByName("United States") ),
				new City("Winston–Salem", 242203, 36.1027, -80.261, sd.getStateByName( "North Carolina"), cod.getCountryByName("United States") ),
				new City("North Las Vegas", 238702, 36.2857, -115.0939, sd.getStateByName( "Nevada"), cod.getCountryByName("United States") ),
				new City("Irving", 238289, 32.8577, -96.97, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Chesapeake", 237940, 36.6794, -76.3018, sd.getStateByName( "Virginia"), cod.getCountryByName("United States") ),
				new City("Gilbert", 237133, 33.3103, -111.7431, sd.getStateByName( "Arizona"), cod.getCountryByName("United States") ),
				new City("Hialeah", 236387, 25.8699, -80.3029, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Garland", 234943, 32.9098, -96.6303, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Fremont", 233136, 37.4945, -121.9412, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Baton Rouge", 227715, 30.4422, -91.1309, sd.getStateByName( "Louisiana"), cod.getCountryByName("United States") ),
				new City("Richmond", 223170, 37.5314, -77.476, sd.getStateByName( "Virginia"), cod.getCountryByName("United States") ),
				new City("Boise", 223154, 43.6002, -116.2317, sd.getStateByName( "Idaho"), cod.getCountryByName("United States") ),
				new City("San Bernardino", 216239, 34.1416, -117.2936, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Spokane", 215973, 47.6669, -117.4333, sd.getStateByName( "Washington"), cod.getCountryByName("United States") ),
				new City("Des Moines", 215472, 41.5726, -93.6102, sd.getStateByName( "Iowa"), cod.getCountryByName("United States") ),
				new City("Modesto", 212175, 37.6375, -121.003, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Birmingham", 212157, 33.5274, -86.799, sd.getStateByName( "Alabama"), cod.getCountryByName("United States") ),
				new City("Tacoma", 211277, 47.2522, -122.4598, sd.getStateByName( "Washington"), cod.getCountryByName("United States") ),
				new City("Fontana", 209665, 34.109, -117.4629, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Rochester", 208880, 43.1699, -77.6169, sd.getStateByName( "New York"), cod.getCountryByName("United States") ),
				new City("Oxnard", 207906, 34.2023, -119.2046, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Moreno Valley", 205499, 33.9233, -117.2057, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Fayetteville", 204759, 35.0828, -78.9735, sd.getStateByName( "North Carolina"), cod.getCountryByName("United States") ),
				new City("Aurora", 201110, 41.7635, -88.2901, sd.getStateByName( "Illinois"), cod.getCountryByName("United States") ),
				new City("Glendale", 200831, 34.1814, -118.2458, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Yonkers", 200807, 40.9459, -73.8674, sd.getStateByName( "New York"), cod.getCountryByName("United States") ),
				new City("Huntington Beach", 200652, 33.6906, -118.0093, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Montgomery", 200022, 32.3472, -86.2661, sd.getStateByName( "Alabama"), cod.getCountryByName("United States") ),
				new City("Amarillo", 199582, 35.1999, -101.8302, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Little Rock", 198541, 34.7254, -92.3586, sd.getStateByName( "Arkansas"), cod.getCountryByName("United States") ),
				new City("Akron", 197633, 41.0805, -81.5214, sd.getStateByName( "Ohio"), cod.getCountryByName("United States") ),
				new City("Columbus", 197485, 32.5102, -84.8749, sd.getStateByName( "Georgia"), cod.getCountryByName("United States") ),
				new City("Augusta", 197081, 33.3655, -82.0734, sd.getStateByName( "Georgia"), cod.getCountryByName("United States") ),
				new City("Grand Rapids", 196445, 42.9612, -85.6556, sd.getStateByName( "Michigan"), cod.getCountryByName("United States") ),
				new City("Shreveport", 194920, 32.4669, -93.7922, sd.getStateByName( "Louisiana"), cod.getCountryByName("United States") ),
				new City("Salt Lake City", 193744, 40.7769, -111.931, sd.getStateByName( "Utah"), cod.getCountryByName("United States") ),
				new City("Huntsville", 193079, 34.699, -86.673, sd.getStateByName( "Alabama"), cod.getCountryByName("United States") ),
				new City("Mobile", 192904, 30.6684, -88.1002, sd.getStateByName( "Alabama"), cod.getCountryByName("United States") ),
				new City("Tallahassee", 190894, 30.4551, -84.2534, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Grand Prairie", 190682, 32.6869, -97.0211, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Overland Park", 188966, 38.889, -94.6906, sd.getStateByName( "Kansas"), cod.getCountryByName("United States") ),
				new City("Knoxville", 186239, 35.9707, -83.9493, sd.getStateByName( "Tennessee"), cod.getCountryByName("United States") ),
				new City("Port St. Lucie", 185132, 27.2806, -80.3883, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Worcester", 184508, 42.2695, -71.8078, sd.getStateByName( "Massachusetts"), cod.getCountryByName("United States") ),
				new City("Brownsville", 183823, 25.9991, -97.455, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Tempe", 182498, 33.3884, -111.9318, sd.getStateByName( "Arizona"), cod.getCountryByName("United States") ),
				new City("Santa Clarita", 181972, 34.403, -118.5042, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Newport News", 181825, 37.0762, -76.522, sd.getStateByName( "Virginia"), cod.getCountryByName("United States") ),
				new City("Cape Coral", 179804, 26.6432, -81.9974, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Providence", 179219, 41.8231, -71.4188, sd.getStateByName( "Rhode Island"), cod.getCountryByName("United States") ),
				new City("Fort Lauderdale", 178752, 26.1412, -80.1467, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Chattanooga", 177571, 35.066, -85.2484, sd.getStateByName( "Tennessee"), cod.getCountryByName("United States") ),
				new City("Rancho Cucamonga", 176534, 34.1233, -117.5642, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Oceanside", 175464, 33.2245, -117.3062, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Santa Rosa", 175155, 38.4468, -122.7061, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Garden Grove", 174858, 33.7788, -117.9605, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Vancouver", 174826, 45.6349, -122.5957, sd.getStateByName( "Washington"), cod.getCountryByName("United States") ),
				new City("Sioux Falls", 174360, 43.5383, -96.732, sd.getStateByName( "South Dakota"), cod.getCountryByName("United States") ),
				new City("Ontario", 173212, 34.0394, -117.6042, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("McKinney", 172298, 33.1985, -96.668, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Elk Grove", 169743, 38.4146, -121.385, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Jackson", 169148, 32.3158, -90.2128, sd.getStateByName( "Mississippi"), cod.getCountryByName("United States") ),
				new City("Pembroke Pines", 168587, 26.021, -80.3404, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Salem", 167419, 44.9237, -123.0232, sd.getStateByName( "Oregon"), cod.getCountryByName("United States") ),
				new City("Springfield", 167319, 37.1942, -93.2913, sd.getStateByName( "Missouri"), cod.getCountryByName("United States") ),
				new City("Corona", 166785, 33.862, -117.5655, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Eugene", 166575, 44.0567, -123.1162, sd.getStateByName( "Oregon"), cod.getCountryByName("United States") ),
				new City("Fort Collins", 164207, 40.5482, -105.0648, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("Peoria", 164173, 33.7862, -112.308, sd.getStateByName( "Arizona"), cod.getCountryByName("United States") ),
				new City("Frisco", 163656, 33.1554, -96.8226, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Cary", 162320, 35.7809, -78.8133, sd.getStateByName( "North Carolina"), cod.getCountryByName("United States") ),
				new City("Lancaster", 160106, 34.6936, -118.1753, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Hayward", 158937, 37.6287, -122.1024, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Palmdale", 157356, 34.591, -118.1054, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Salinas", 157218, 36.6902, -121.6337, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Alexandria", 155810, 38.8201, -77.0841, sd.getStateByName( "Virginia"), cod.getCountryByName("United States") ),
				new City("Lakewood", 154393, 39.6989, -105.1176, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("Springfield", 154074, 42.1155, -72.54, sd.getStateByName( "Massachusetts"), cod.getCountryByName("United States") ),
				new City("Pasadena", 153351, 29.6586, -95.1506, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Sunnyvale", 152771, 37.3858, -122.0263, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Macon", 152555, 32.8088, -83.6942, sd.getStateByName( "Georgia"), cod.getCountryByName("United States") ),
				new City("Pomona", 152494, 34.0585, -117.7611, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Hollywood", 151998, 26.031, -80.1646, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Kansas City", 151709, 39.1225, -94.7418, sd.getStateByName( "Kansas"), cod.getCountryByName("United States") ),
				new City("Escondido", 151613, 33.1331, -117.074, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Clarksville", 150287, 36.5664, -87.3452, sd.getStateByName( "Tennessee"), cod.getCountryByName("United States") ),
				new City("Joliet", 148262, 41.5177, -88.1488, sd.getStateByName( "Illinois"), cod.getCountryByName("United States") ),
				new City("Rockford", 147651, 42.2588, -89.0646, sd.getStateByName( "Illinois"), cod.getCountryByName("United States") ),
				new City("Torrance", 147195, 33.835, -118.3414, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Naperville", 147122, 41.7492, -88.162, sd.getStateByName( "Illinois"), cod.getCountryByName("United States") ),
				new City("Paterson", 147000, 40.9148, -74.1628, sd.getStateByName( "New Jersey"), cod.getCountryByName("United States") ),
				new City("Savannah", 146763, 32.0025, -81.1536, sd.getStateByName( "Georgia"), cod.getCountryByName("United States") ),
				new City("Bridgeport", 145936, 41.1874, -73.1958, sd.getStateByName( "Connecticut"), cod.getCountryByName("United States") ),
				new City("Mesquite", 143736, 32.7629, -96.5888, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Killeen", 143400, 31.0777, -97.732, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Syracuse", 143378, 43.041, -76.1436, sd.getStateByName( "New York"), cod.getCountryByName("United States") ),
				new City("McAllen", 142212, 26.2322, -98.2464, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Pasadena", 142059, 34.1606, -118.1396, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Bellevue", 141400, 47.5979, -122.1565, sd.getStateByName( "Washington"), cod.getCountryByName("United States") ),
				new City("Fullerton", 140721, 33.8857, -117.928, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Orange", 140504, 33.787, -117.8613, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Dayton", 140489, 39.7774, -84.1996, sd.getStateByName( "Ohio"), cod.getCountryByName("United States") ),
				new City("Miramar", 138449, 25.977, -80.3358, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Thornton", 136703, 39.9194, -104.9428, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("West Valley City", 136574, 40.6885, -112.0118, sd.getStateByName( "Utah"), cod.getCountryByName("United States") ),
				new City("Olathe", 135473, 38.8843, -94.8195, sd.getStateByName( "Kansas"), cod.getCountryByName("United States") ),
				new City("Hampton", 135410, 37.048, -76.2971, sd.getStateByName( "Virginia"), cod.getCountryByName("United States") ),
				new City("Warren", 135125, 42.4929, -83.025, sd.getStateByName( "Michigan"), cod.getCountryByName("United States") ),
				new City("Midland", 134610, 32.0246, -102.1135, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Waco", 134432, 31.5601, -97.186, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Charleston", 134385, 32.8179, -79.959, sd.getStateByName( "South Carolina"), cod.getCountryByName("United States") ),
				new City("Columbia", 134309, 34.0291, -80.898, sd.getStateByName( "South Carolina"), cod.getCountryByName("United States") ),
				new City("Denton", 133808, 33.2166, -97.1414, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Carrollton", 133351, 32.9884, -96.8998, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Surprise", 132677, 33.6706, -112.4527, sd.getStateByName( "Arizona"), cod.getCountryByName("United States") ),
				new City("Roseville", 132671, 38.769, -121.3189, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Sterling Heights", 132427, 42.5812, -83.0303, sd.getStateByName( "Michigan"), cod.getCountryByName("United States") ),
				new City("Murfreesboro", 131947, 35.8522, -86.416, sd.getStateByName( "Tennessee"), cod.getCountryByName("United States") ),
				new City("Gainesville", 131591, 29.6788, -82.3461, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Cedar Rapids", 131127, 41.967, -91.6778, sd.getStateByName( "Iowa"), cod.getCountryByName("United States") ),
				new City("Visalia", 131074, 36.3273, -119.3289, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Coral Springs", 130059, 26.2707, -80.2593, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("New Haven", 129934, 41.3108, -72.925, sd.getStateByName( "Connecticut"), cod.getCountryByName("United States") ),
				new City("Stamford", 129113, 41.0799, -73.546, sd.getStateByName( "Connecticut"), cod.getCountryByName("United States") ),
				new City("Thousand Oaks", 128888, 34.1933, -118.8742, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Concord", 128726, 37.9722, -122.0016, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Elizabeth", 128640, 40.6664, -74.1935, sd.getStateByName( "New Jersey"), cod.getCountryByName("United States") ),
				new City("Lafayette", 127626, 30.2074, -92.0285, sd.getStateByName( "Louisiana"), cod.getCountryByName("United States") ),
				new City("Kent", 127514, 47.388, -122.2127, sd.getStateByName( "Washington"), cod.getCountryByName("United States") ),
				new City("Topeka", 126808, 39.0347, -95.6962, sd.getStateByName( "Kansas"), cod.getCountryByName("United States") ),
				new City("Simi Valley", 126327, 34.2669, -118.7485, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Santa Clara", 125948, 37.3646, -121.9679, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Athens", 123371, 33.9496, -83.3701, sd.getStateByName( "Georgia"), cod.getCountryByName("United States") ),
				new City("Hartford", 123243, 41.7659, -72.6816, sd.getStateByName( "Connecticut"), cod.getCountryByName("United States") ),
				new City("Victorville", 122265, 34.5277, -117.3536, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Abilene", 122225, 32.4545, -99.7381, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Norman", 122180, 35.2406, -97.3453, sd.getStateByName( "Oklahoma"), cod.getCountryByName("United States") ),
				new City("Vallejo", 121299, 38.1079, -122.264, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Berkeley", 121240, 37.867, -122.2991, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Round Rock", 120892, 30.5252, -97.666, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Ann Arbor", 120782, 42.2761, -83.7309, sd.getStateByName( "Michigan"), cod.getCountryByName("United States") ),
				new City("Fargo", 120762, 46.8652, -96.829, sd.getStateByName( "North Dakota"), cod.getCountryByName("United States") ),
				new City("Columbia", 120612, 38.9473, -92.3264, sd.getStateByName( "Missouri"), cod.getCountryByName("United States") ),
				new City("Allentown", 120443, 40.5936, -75.4784, sd.getStateByName( "Pennsylvania"), cod.getCountryByName("United States") ),
				new City("Evansville", 119477, 37.9877, -87.5347, sd.getStateByName( "Indiana"), cod.getCountryByName("United States") ),
				new City("Beaumont", 118299, 30.0849, -94.1453, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Odessa", 117871, 31.8838, -102.3411, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Wilmington", 117525, 34.2092, -77.8858, sd.getStateByName( "North Carolina"), cod.getCountryByName("United States") ),
				new City("Arvada", 117453, 39.8337, -105.1503, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("Independence", 117030, 39.0855, -94.3521, sd.getStateByName( "Missouri"), cod.getCountryByName("United States") ),
				new City("Provo", 116868, 40.2453, -111.6448, sd.getStateByName( "Utah"), cod.getCountryByName("United States") ),
				new City("Lansing", 116020, 42.7143, -84.5593, sd.getStateByName( "Michigan"), cod.getCountryByName("United States") ),
				new City("El Monte", 115807, 34.0746, -118.0291, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Springfield", 115715, 39.7911, -89.6446, sd.getStateByName( "Illinois"), cod.getCountryByName("United States") ),
				new City("Fairfield", 114756, 38.2593, -122.0321, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Clearwater", 114361, 27.9789, -82.7666, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Peoria", 114265, 40.7515, -89.6174, sd.getStateByName( "Illinois"), cod.getCountryByName("United States") ),
				new City("Rochester", 114011, 44.0154, -92.4772, sd.getStateByName( "Minnesota"), cod.getCountryByName("United States") ),
				new City("Carlsbad", 113952, 33.1239, -117.2828, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Westminster", 113875, 39.8822, -105.0644, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("West Jordan", 113699, 40.6024, -112.0008, sd.getStateByName( "Utah"), cod.getCountryByName("United States") ),
				new City("Pearland", 113570, 29.5558, -95.3231, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Richardson", 113347, 32.9723, -96.7081, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Downey", 113267, 33.9382, -118.1309, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Miami Gardens", 113058, 25.9489, -80.2436, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Temecula", 113054, 33.4931, -117.1317, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Costa Mesa", 112822, 33.6659, -117.9123, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("College Station", 112141, 30.5852, -96.2964, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Elgin", 112123, 42.0396, -88.3217, sd.getStateByName( "Illinois"), cod.getCountryByName("United States") ),
				new City("Murrieta", 111674, 33.5721, -117.1904, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Gresham", 111523, 45.5023, -122.4416, sd.getStateByName( "Oregon"), cod.getCountryByName("United States") ),
				new City("High Point", 111223, 35.99, -79.9905, sd.getStateByName( "North Carolina"), cod.getCountryByName("United States") ),
				new City("Antioch", 110898, 37.9791, -121.7962, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Inglewood", 110654, 33.9561, -118.3443, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Cambridge", 110651, 42.376, -71.1187, sd.getStateByName( "Massachusetts"), cod.getCountryByName("United States") ),
				new City("Lowell", 110558, 42.639, -71.3211, sd.getStateByName( "Massachusetts"), cod.getCountryByName("United States") ),
				new City("Manchester", 110506, 42.9849, -71.4441, sd.getStateByName( "New Hampshire"), cod.getCountryByName("United States") ),
				new City("Billings", 110323, 45.7885, -108.5499, sd.getStateByName( "Montana"), cod.getCountryByName("United States") ),
				new City("Pueblo", 110291, 38.2699, -104.6123, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("Palm Bay", 110104, 27.9856, -80.6626, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Centennial", 109932, 39.5906, -104.8691, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("Richmond", 109813, 37.9523, -122.3606, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Ventura", 109592, 34.2678, -119.2542, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Pompano Beach", 109393, 26.2416, -80.1339, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("North Charleston", 109298, 32.9178, -80.065, sd.getStateByName( "South Carolina"), cod.getCountryByName("United States") ),
				new City("Everett", 109043, 47.9566, -122.1914, sd.getStateByName( "Washington"), cod.getCountryByName("United States") ),
				new City("Waterbury", 108272, 41.5585, -73.0367, sd.getStateByName( "Connecticut"), cod.getCountryByName("United States") ),
				new City("West Palm Beach", 108161, 26.7464, -80.1251, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Boulder", 108090, 40.027, -105.2519, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("West Covina", 107847, 34.0559, -117.9099, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Broken Arrow", 107403, 36.0365, -95.781, sd.getStateByName( "Oklahoma"), cod.getCountryByName("United States") ),
				new City("Clovis", 106583, 36.8282, -119.6849, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Daly City", 106472, 37.7009, -122.465, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Lakeland", 106420, 28.0555, -81.9549, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Santa Maria", 106290, 34.9332, -120.4438, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Norwalk", 106178, 33.9076, -118.0835, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Sandy Springs", 105703, 33.9315, -84.3687, sd.getStateByName( "Georgia"), cod.getCountryByName("United States") ),
				new City("Hillsboro", 105164, 45.528, -122.9357, sd.getStateByName( "Oregon"), cod.getCountryByName("United States") ),
				new City("Green Bay", 105139, 44.5207, -87.9842, sd.getStateByName( "Wisconsin"), cod.getCountryByName("United States") ),
				new City("Tyler", 104798, 32.3173, -95.3059, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Wichita Falls", 104724, 33.9067, -98.5259, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Lewisville", 104659, 33.0466, -96.9818, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Burbank", 104447, 34.1901, -118.3264, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Greeley", 103990, 40.4153, -104.7697, sd.getStateByName( "Colorado"), cod.getCountryByName("United States") ),
				new City("San Mateo", 103959, 37.5603, -122.3106, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("El Cajon", 103768, 32.8017, -116.9604, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Jurupa Valley", 103541, 34.0026, -117.4676, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Rialto", 103314, 34.1118, -117.3883, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Davenport", 102612, 41.5541, -90.604, sd.getStateByName( "Iowa"), cod.getCountryByName("United States") ),
				new City("League City", 102010, 29.4901, -95.1091, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Edison", 101996, 40.504, -74.3494, sd.getStateByName( "New Jersey"), cod.getCountryByName("United States") ),
				new City("Davie", 101871, 26.0791, -80.285, sd.getStateByName( "Florida"), cod.getCountryByName("United States") ),
				new City("Las Cruces", 101759, 32.3264, -106.7897, sd.getStateByName( "New Mexico"), cod.getCountryByName("United States") ),
				new City("South Bend", 101735, 41.6769, -86.269, sd.getStateByName( "Indiana"), cod.getCountryByName("United States") ),
				new City("Vista", 101659, 33.1895, -117.2386, sd.getStateByName( "California"), cod.getCountryByName("United States") ),
				new City("Woodbridge", 101389, 40.5607, -74.2927, sd.getStateByName( "New Jersey"), cod.getCountryByName("United States") ),
				new City("Renton", 100953, 47.4761, -122.192, sd.getStateByName( "Washington"), cod.getCountryByName("United States") ),
				new City("Lakewood", 100758, 40.0771, -74.2004, sd.getStateByName( "New Jersey"), cod.getCountryByName("United States") ),
				new City("San Angelo", 100702, 31.4411, -100.4505, sd.getStateByName( "Texas"), cod.getCountryByName("United States") ),
				new City("Clinton", 100392, 42.5903, -82.917, sd.getStateByName( "Michigan"), cod.getCountryByName("United States") )
		};
		
		for (City c : cities) {
			if ( c == null) {
				System.out.println("no city to add");
			}
			System.out.println("adding " + c.getName());
			c.setId(cd.addCity(c));
		}
		
	}
	
	static void intlCityInit() {
		StateDao sd = new StateDaoImpl();
		CityDao cd = new CityDaoImpl();
		CountryDao cod = new CountryDaoImpl();
		City[] cities = {
				new City("Kabul", 3414100, 34.5553494, 69.207486, null, cod.getCountryByName( "Afghanistan") ),
				new City("Algiers", 3415811, 36.753768, 3.05875609999998, null, cod.getCountryByName( "Algeria") ),
				new City("Oran", 1560329, 35.6970697, -0.630798799999979, null, cod.getCountryByName( "Algeria") ),
				new City("Luanda", 2825311, -8.83998759999999, 13.2894367999999, null, cod.getCountryByName( "Angola") ),
				new City("Buenos Aires", 3054300, -34.6036844, -58.3815591, null, cod.getCountryByName( "Argentina") ),
				new City("Córdoba", 1330023, -31.4200832999999, -64.1887760999999, null, cod.getCountryByName( "Argentina") ),
				new City("Rosario", 1193605, -32.9442426, -60.6505387999999, null, cod.getCountryByName( "Argentina") ),
				new City("Yerevan", 1060138, 40.1791857, 44.4991029, null, cod.getCountryByName( "Armenia") ),
				new City("Melbourne", 135959, -37.8136276, 144.963057599999, null, cod.getCountryByName( "Australia") ),
				new City("Brisbane", 1180285, -27.4697707, 153.0251235, null, cod.getCountryByName( "Australia") ),
				new City("Vienna", 1863881, 48.2081743, 16.3738189, null, cod.getCountryByName( "Austria") ),
				new City("Baku", 3202300, 40.4092616999999, 49.8670924, null, cod.getCountryByName( "Azerbaijan") ),
				new City("Dhaka", 12043977, 23.810332, 90.4125180999999, null, cod.getCountryByName( "Bangladesh") ),
				new City("Chittagong", 2581643, 22.356851, 91.7831819, null, cod.getCountryByName( "Bangladesh") ),
				new City("Minsk", 1959781, 53.9045397999999, 27.5615244, null, cod.getCountryByName( "Belarus") ),
				new City("Santa Cruz de la Sierra", 1453549, -17.8145819, -63.1560852999999, null, cod.getCountryByName( "Bolivia") ),
				new City("Sao Paulo", 12038175, -23.5505199, -46.6333093999999, null, cod.getCountryByName( "Brazil") ),
				new City("Rio de Janeiro", 6429923, -22.9068467, -43.1728964999999, null, cod.getCountryByName( "Brazil") ),
				new City("Salvador", 2902927, -12.9722184, -38.5014135999999, null, cod.getCountryByName( "Brazil") ),
				new City("Fortaleza", 2609716, -3.7319029, -38.5267393, null, cod.getCountryByName( "Brazil") ),
				new City("Brasilia", 2556149, -15.7942287, -47.8821657999999, null, cod.getCountryByName( "Brazil") ),
				new City("Belo Horizonte", 2502557, -19.9245018, -43.9352375999999, null, cod.getCountryByName( "Brazil") ),
				new City("Curitiba", 1879355, -25.4244287, -49.2653818999999, null, cod.getCountryByName( "Brazil") ),
				new City("Recife", 1555039, -8.0475622, -34.8769643, null, cod.getCountryByName( "Brazil") ),
				new City("Porto Alegre", 1476867, -30.0346471, -51.2176584, null, cod.getCountryByName( "Brazil") ),
				new City("Campinas", 1164098, -22.9098833, -47.0625812, null, cod.getCountryByName( "Brazil") ),
				new City("Sofia", 1260120, 42.6977082, 23.3218675, null, cod.getCountryByName( "Bulgaria") ),
				new City("Ouagadougou", 2200000, 12.3714277, -1.51966029999994, null, cod.getCountryByName( "Burkina Faso") ),
				new City("Phnom Penh", 2234566, 11.5448729, 104.8921668, null, cod.getCountryByName( "Cambodia") ),
				new City("Douala", 2446945, 4.0510564, 9.7678687, null, cod.getCountryByName( "Cameroon") ),
				new City("Yaounde", 2440462, 3.8480325, 11.5020752, null, cod.getCountryByName( "Cameroon") ),
				new City("Toronto", 2731571, 43.653226, -79.3831842999999, null, cod.getCountryByName( "Canada") ),
				new City("Montreal", 1649519, 45.5016889, -73.5672559999999, null, cod.getCountryByName( "Canada") ),
				new City("Calgary", 1235171, 51.0486151, -114.0708459, null, cod.getCountryByName( "Canada") ),
				new City("Santiago", 5743719, -33.4488897, -70.6692655, null, cod.getCountryByName( "Chile") ),
				new City("Chongqing", 30165500, 29.4315861, 106.912250999999, null, cod.getCountryByName( "China") ),
				new City("Shanghai", 24256800, 31.2303904, 121.473702099999, null, cod.getCountryByName( "China") ),
				new City("Beijing", 21516000, 39.9041998999999, 116.4073963, null, cod.getCountryByName( "China") ),
				new City("Guangzhou", 14043500, 23.12911, 113.264384999999, null, cod.getCountryByName( "China") ),
				new City("Tianjin", 12784000, 39.3433574, 117.361647599999, null, cod.getCountryByName( "China") ),
				new City("Wenzhou", 9175000, 27.993828, 120.699360999999, null, cod.getCountryByName( "China") ),
				new City("Xi'an", 8705600, 34.341574, 108.939769999999, null, cod.getCountryByName( "China") ),
				new City("Shenzhen", 8378900, 22.543096, 114.057864999999, null, cod.getCountryByName( "China") ),
				new City("Suzhou", 8265050, 31.298974, 120.585288999999, null, cod.getCountryByName( "China") ),
				new City("Nanjing", 8230000, 32.060255, 118.796877, null, cod.getCountryByName( "China") ),
				new City("Dongguan", 8220207, 23.020673, 113.751799, null, cod.getCountryByName( "China") ),
				new City("Quanzhou", 8128533, 24.874132, 118.675674999999, null, cod.getCountryByName( "China") ),
				new City("Shenyang", 8106171, 41.805699, 123.431471999999, null, cod.getCountryByName( "China") ),
				new City("Hong Kong", 7374900, 22.396428, 114.109497, null, cod.getCountryByName( "China") ),
				new City("Fuzhou", 7115369, 26.074478, 119.296481999999, null, cod.getCountryByName( "China") ),
				new City("Changsha", 7044118, 28.228209, 112.938813999999, null, cod.getCountryByName( "China") ),
				new City("Wuhan", 6886253, 30.592849, 114.305538999999, null, cod.getCountryByName( "China") ),
				new City("Qingdao", 6188100, 36.067108, 120.382609, null, cod.getCountryByName( "China") ),
				new City("Foshan", 6151622, 23.021478, 113.121435, null, cod.getCountryByName( "China") ),
				new City("Zunyi", 6127009, 27.725654, 106.927388999999, null, cod.getCountryByName( "China") ),
				new City("Shantou", 5391028, 23.354091, 116.681971999999, null, cod.getCountryByName( "China") ),
				new City("Chengdu", 4741929, 30.572815, 104.066800999999, null, cod.getCountryByName( "China") ),
				new City("Shijiazhuang", 4303700, 38.042805, 114.514893, null, cod.getCountryByName( "China") ),
				new City("Harbin", 4280701, 45.8037749999999, 126.534967, null, cod.getCountryByName( "China") ),
				new City("Zhengzhou", 4122087, 34.746611, 113.625327999999, null, cod.getCountryByName( "China") ),
				new City("Changchun", 3815270, 43.817071, 125.323543999999, null, cod.getCountryByName( "China") ),
				new City("Hangzhou", 3560391, 30.274084, 120.15507, null, cod.getCountryByName( "China") ),
				new City("Xiamen", 3531347, 24.479833, 118.089425, null, cod.getCountryByName( "China") ),
				new City("Ningbo", 3491597, 29.868336, 121.54399, null, cod.getCountryByName( "China") ),
				new City("Hefei", 3352076, 31.820591, 117.227218999999, null, cod.getCountryByName( "China") ),
				new City("Tangshan", 3187171, 39.6308669999999, 118.180193, null, cod.getCountryByName( "China") ),
				new City("Zhongshan", 3121275, 22.517585, 113.392769999999, null, cod.getCountryByName( "China") ),
				new City("Chaozhou", 2669844, 23.656703, 116.622755999999, null, cod.getCountryByName( "China") ),
				new City("Lanzhou", 2177130, 36.061089, 103.834302999999, null, cod.getCountryByName( "China") ),
				new City("Dalian", 2146099, 38.914003, 121.614682, null, cod.getCountryByName( "China") ),
				new City("Jinan", 2009273, 36.6512, 117.120094999999, null, cod.getCountryByName( "China") ),
				new City("Bogota", 7878783, 4.71098859999999, -74.072092, null, cod.getCountryByName( "Colombia") ),
				new City("Medellin", 2441123, 6.244203, -75.5812118999999, null, cod.getCountryByName( "Colombia") ),
				new City("Cali", 2400653, 3.4516467, -76.5319854, null, cod.getCountryByName( "Colombia") ),
				new City("Barranquilla", 1386865, 11.0041072, -74.8069812999999, null, cod.getCountryByName( "Colombia") ),
				new City("Brazzaville", 1827000, -0.228021, 15.827659, null, cod.getCountryByName( "Congo Republic") ),
				new City("Havana", 2106146, 23.1135925, -82.3665955999999, null, cod.getCountryByName( "Cuba") ),
				new City("Prague", 1324000, 50.0755381, 14.4378004999999, null, cod.getCountryByName( "Czech Republic") ),
				new City("Kinshasa", 10130000, -4.4419311, 15.2662930999999, null, cod.getCountryByName( "DR Congo") ),
				new City("Guayaquil", 3600000, -2.1709979, -79.9223592, null, cod.getCountryByName( "Ecuador") ),
				new City("Quito", 2671191, -0.1806532, -78.4678382, null, cod.getCountryByName( "Ecuador") ),
				new City("Cairo", 10230350, 30.0444196, 31.2357116, null, cod.getCountryByName( "Egypt") ),
				new City("Alexandria", 4616625, 31.2000924, 29.9187386999999, null, cod.getCountryByName( "Egypt") ),
				new City("Giza", 4239988, 30.0130557, 31.2088526, null, cod.getCountryByName( "Egypt") ),
				new City("Addis Ababa", 3103673, 8.9806034, 38.7577605, null, cod.getCountryByName( "Ethiopia") ),
				new City("Paris", 2229621, 48.856614, 2.35222190000001, null, cod.getCountryByName( "France") ),
				new City("T'bilisi", 1118035, 41.7151377, 44.8270959999999, null, cod.getCountryByName( "Georgia") ),
				new City("Berlin", 3517424, 52.5200065999999, 13.4049539999999, null, cod.getCountryByName( "Germany") ),
				new City("Hamburg", 1787408, 53.5510846, 9.99368189999995, null, cod.getCountryByName( "Germany") ),
				new City("Munich", 1450381, 48.1351253, 11.5819804999999, null, cod.getCountryByName( "Germany") ),
				new City("Cologne", 1057327, 50.937531, 6.96027860000003, null, cod.getCountryByName( "Germany") ),
				new City("Accra", 2070463, 5.6037168, -0.186964399999965, null, cod.getCountryByName( "Ghana") ),
				new City("Guatemala City", 2110100, 14.6349149, -90.5068824, null, cod.getCountryByName( "Guatemala") ),
				new City("Budapest", 1759407, 47.497912, 19.0402349999999, null, cod.getCountryByName( "Hungary") ),
				new City("Delhi", 21678794, 28.7040592, 77.1024901999999, null, cod.getCountryByName( "India") ),
				new City("Mumbai", 21247844, 19.0759837, 72.8776559, null, cod.getCountryByName( "India") ),
				new City("Hyderabad", 8592500, 17.385044, 78.486671, null, cod.getCountryByName( "India") ),
				new City("Chennai", 8570880, 13.0826802, 80.2707184, null, cod.getCountryByName( "India") ),
				new City("Bengaluru", 8425970, 12.9715987, 77.5945626999999, null, cod.getCountryByName( "India") ),
				new City("Ahmedabad", 5570585, 23.022505, 72.5713620999999, null, cod.getCountryByName( "India") ),
				new City("Kolkata", 4486679, 22.572646, 88.3638949999999, null, cod.getCountryByName( "India") ),
				new City("Surat", 4462002, 21.1702401, 72.8310607, null, cod.getCountryByName( "India") ),
				new City("Pune", 3115431, 18.5204303, 73.8567436999999, null, cod.getCountryByName( "India") ),
				new City("Jaipur", 3073350, 26.9124336, 75.7872709, null, cod.getCountryByName( "India") ),
				new City("Lucknow", 2815601, 26.8466937, 80.9461659999999, null, cod.getCountryByName( "India") ),
				new City("Kanpur", 2768057, 26.449923, 80.3318736, null, cod.getCountryByName( "India") ),
				new City("Nagpur", 2405665, 21.1458004, 79.0881546, null, cod.getCountryByName( "India") ),
				new City("Visakhapatnam", 2035922, 17.6868159, 83.2184815, null, cod.getCountryByName( "India") ),
				new City("Bhopal", 1798218, 23.2599333, 77.4126149999999, null, cod.getCountryByName( "India") ),
				new City("Patna", 1683200, 25.5940947, 85.1375645, null, cod.getCountryByName( "India") ),
				new City("Vijayawada", 1491202, 16.5061743, 80.6480153, null, cod.getCountryByName( "India") ),
				new City("Jakarta", 10075310, -6.17511, 106.865039499999, null, cod.getCountryByName( "Indonesia") ),
				new City("Surabaya", 2765487, -7.2574719, 112.752088299999, null, cod.getCountryByName( "Indonesia") ),
				new City("Bandung", 2575478, -6.9174639, 107.6191228, null, cod.getCountryByName( "Indonesia") ),
				new City("Medan", 2097610, 3.5951956, 98.6722227, null, cod.getCountryByName( "Indonesia") ),
				new City("Palembang", 1708413, -2.9760735, 104.7754307, null, cod.getCountryByName( "Indonesia") ),
				new City("Semarang", 1555984, -7.0051453, 110.438125399999, null, cod.getCountryByName( "Indonesia") ),
				new City("Makassar", 1338633, -5.14766509999999, 119.432731399999, null, cod.getCountryByName( "Indonesia") ),
				new City("Tehran", 8154051, 35.6891975, 51.3889735999999, null, cod.getCountryByName( "Iran") ),
				new City("Mashhad", 3312090, 36.2604623, 59.6167548999999, null, cod.getCountryByName( "Iran") ),
				new City("Isfahan", 2243249, 32.6546275, 51.6679825999999, null, cod.getCountryByName( "Iran") ),
				new City("Karaj", 1973470, 35.8400188, 50.9390905999999, null, cod.getCountryByName( "Iran") ),
				new City("Shiraz", 1869001, 29.5917677, 52.5836982, null, cod.getCountryByName( "Iran") ),
				new City("Tabriz", 1733033, 38.096239, 46.2738013, null, cod.getCountryByName( "Iran") ),
				new City("Baghdad", 7180889, 33.3128057, 44.3614875, null, cod.getCountryByName( "Iraq") ),
				new City("Basra", 2750000, 30.5081033, 47.7834887999999, null, cod.getCountryByName( "Iraq") ),
				new City("Rome", 2877215, 41.9027835, 12.4963655, null, cod.getCountryByName( "Italy") ),
				new City("Milan", 1359905, 45.4642035, 9.18998199999998, null, cod.getCountryByName( "Italy") ),
				new City("Abidjan", 4765000, 5.3599517, -4.00825629999997, null, cod.getCountryByName( "Ivory Coast") ),
				new City("Tokyo", 13513734, 35.6894875, 139.691706399999, null, cod.getCountryByName( "Japan") ),
				new City("Yokohama", 3726167, 35.4437078, 139.6380256, null, cod.getCountryByName( "Japan") ),
				new City("Osaka", 2691742, 34.6937378, 135.502165099999, null, cod.getCountryByName( "Japan") ),
				new City("Nagoya", 2296014, 35.1814464, 136.906397999999, null, cod.getCountryByName( "Japan") ),
				new City("Sapporo", 1918096, 43.0620958, 141.3543763, null, cod.getCountryByName( "Japan") ),
				new City("Kobe", 1536499, 34.690083, 135.1955112, null, cod.getCountryByName( "Japan") ),
				new City("Kawasaki", 1496035, 35.5298198, 139.7024039, null, cod.getCountryByName( "Japan") ),
				new City("Fukuoka", 1483052, 33.5903547, 130.4017155, null, cod.getCountryByName( "Japan") ),
				new City("Kyoto", 1474570, 35.0116363, 135.768029399999, null, cod.getCountryByName( "Japan") ),
				new City("Saitama", 1226656, 35.8617292, 139.6454822, null, cod.getCountryByName( "Japan") ),
				new City("Hiroshima", 1196274, 34.3852029, 132.455292699999, null, cod.getCountryByName( "Japan") ),
				new City("Almaty", 1792549, 43.2220146, 76.8512485, null, cod.getCountryByName( "Kazakhstan") ),
				new City("Astana", 1029556, 51.1605226999999, 71.4703558, null, cod.getCountryByName( "Kazakhstan") ),
				new City("Nairobi", 3138369, -1.2920659, 36.8219461999999, null, cod.getCountryByName( "Kenya") ),
				new City("Pyongyang", 3255388, 39.0392193, 125.7625241, null, cod.getCountryByName( "North Korea") ),
				new City("Seoul", 10197604, 37.566535, 126.977969199999, null, cod.getCountryByName( "South Korea") ),
				new City("Busan", 3510833, 35.1795543, 129.0756416, null, cod.getCountryByName( "South Korea") ),
				new City("Incheon", 2978367, 37.4562557, 126.7052062, null, cod.getCountryByName( "South Korea") ),
				new City("Daegu", 2492994, 35.8714354, 128.601445, null, cod.getCountryByName( "South Korea") ),
				new City("Daejeon", 1535028, 36.3504119, 127.3845475, null, cod.getCountryByName( "South Korea") ),
				new City("Kwangju", 1477780, 35.1595454, 126.852601199999, null, cod.getCountryByName( "South Korea") ),
				new City("Ulsan", 1163690, 35.5383773, 129.3113596, null, cod.getCountryByName( "South Korea") ),
				new City("Tripoli", 1126000, 32.8872094, 13.1913382999999, null, cod.getCountryByName( "Libya") ),
				new City("Kuala Lumpur", 1768000, 3.139003, 101.686854999999, null, cod.getCountryByName( "Malaysia") ),
				new City("Mexico City", 8974724, 19.4326077, -99.1332079999999, null, cod.getCountryByName( "Mexico") ),
				new City("Tijuana", 1696923, 32.5149469, -117.0382471, null, cod.getCountryByName( "Mexico") ),
				new City("Guadalajara", 1495189, 20.6596988, -103.3496092, null, cod.getCountryByName( "Mexico") ),
				new City("Monterrey", 1130960, 25.6866142, -100.3161126, null, cod.getCountryByName( "Mexico") ),
				new City("Casablanca", 5117832, 33.5731104, -7.58984340000006, null, cod.getCountryByName( "Morocco") ),
				new City("Fez", 1112072, 34.0181246, -5.00784509999994, null, cod.getCountryByName( "Morocco") ),
				new City("Maputo", 1766184, -25.891968, 32.6051350999999, null, cod.getCountryByName( "Mozambique") ),
				new City("Yangon", 5214000, 16.8660694, 96.195132, null, cod.getCountryByName( "Myanmar") ),
				new City("Mandalay", 1319452, 21.9588282, 96.0891031999999, null, cod.getCountryByName( "Myanmar") ),
				new City("Kathmandu", 1744240, 27.7172453, 85.3239605, null, cod.getCountryByName( "Nepal") ),
				new City("Auckland", 1495000, -36.8484597, 174.7633315, null, cod.getCountryByName( "New Zealand") ),
				new City("Managua", 2560789, 12.1149926, -86.2361743999999, null, cod.getCountryByName( "Nicaragua") ),
				new City("Lagos", 16060303, 6.5243793, 3.37920570000005, null, cod.getCountryByName( "Nigeria") ),
				new City("Kano", 2153225, 12.0021794, 8.59195610000006, null, cod.getCountryByName( "Nigeria") ),
				new City("Ibadan", 1338659, 7.3775355, 3.94703960000003, null, cod.getCountryByName( "Nigeria") ),
				new City("Abuja", 1235880, 9.0764785, 7.39857400000005, null, cod.getCountryByName( "Nigeria") ),
				new City("Karachi", 14910352, 25.0700428, 67.2847875, null, cod.getCountryByName( "Pakistan") ),
				new City("Lahore", 11126285, 31.5203696, 74.3587473, null, cod.getCountryByName( "Pakistan") ),
				new City("Faisalabad", 3203846, 31.4503661999999, 73.1349605, null, cod.getCountryByName( "Pakistan") ),
				new City("Rawalpindi", 2098231, 33.5651107, 73.0169134999999, null, cod.getCountryByName( "Pakistan") ),
				new City("Gujranwala", 2027001, 32.1876919, 74.1944528999999, null, cod.getCountryByName( "Pakistan") ),
				new City("Peshawar", 1970042, 34.0151366, 71.5249154, null, cod.getCountryByName( "Pakistan") ),
				new City("Hyderabad", 1732693, 25.3959687, 68.357776, null, cod.getCountryByName( "Pakistan") ),
				new City("Islamabad", 1014825, 33.6844202, 73.0478848, null, cod.getCountryByName( "Pakistan") ),
				new City("Lima", 8852000, -12.0463731, -77.042754, null, cod.getCountryByName( "Peru") ),
				new City("Quezon City", 2936116, 14.6760413, 121.043700299999, null, cod.getCountryByName( "Philippines") ),
				new City("Manila", 1780148, 14.5995124, 120.9842195, null, cod.getCountryByName( "Philippines") ),
				new City("Davao City", 1632991, 7.190708, 125.455340999999, null, cod.getCountryByName( "Philippines") ),
				new City("Caloocan", 1583978, 14.7565784, 121.044976799999, null, cod.getCountryByName( "Philippines") ),
				new City("Warsaw", 1753977, 52.2296756, 21.0122287, null, cod.getCountryByName( "Poland") ),
				new City("Bucharest", 1883425, 44.4267674, 26.1025383999999, null, cod.getCountryByName( "Romania") ),
				new City("Moscow", 12197596, 55.755826, 37.6172999, null, cod.getCountryByName( "Russia") ),
				new City("Saint Petersburg", 5191690, 59.9342802, 30.3350986, null, cod.getCountryByName( "Russia") ),
				new City("Novosibirsk", 1567087, 55.0083525999999, 82.9357327, null, cod.getCountryByName( "Russia") ),
				new City("Yekaterinburg", 1428042, 56.8389260999999, 60.6057025, null, cod.getCountryByName( "Russia") ),
				new City("Nizhny Novgorod", 1250619, 56.2965039, 43.936059, null, cod.getCountryByName( "Russia") ),
				new City("Omsk", 1154116, 54.9884804, 73.3242361, null, cod.getCountryByName( "Russia") ),
				new City("Rostov-on-Don", 1119900, 47.2357137, 39.701505, null, cod.getCountryByName( "Russia") ),
				new City("Riyadh", 5676621, 24.7135517, 46.6752956999999, null, cod.getCountryByName( "Saudi Arabia") ),
				new City("Jeddah", 3456259, 21.2854067, 39.2375506999999, null, cod.getCountryByName( "Saudi Arabia") ),
				new City("Dakar", 1146053, 14.716677, -17.4676861, null, cod.getCountryByName( "Senegal") ),
				new City("Belgrade", 1166763, 44.786568, 20.4489215999999, null, cod.getCountryByName( "Serbia") ),
				new City("Singapore", 5535000, 1.352083, 103.819836, null, cod.getCountryByName( "Singapore") ),
				new City("Johannesburg", 4434827, -26.2041028, 28.0473051, null, cod.getCountryByName( "South Africa") ),
				new City("Cape Town", 3740026, -33.9248685, 18.4240552999999, null, cod.getCountryByName( "South Africa") ),
				new City("Durban", 3442361, -29.8586803999999, 31.0218403999999, null, cod.getCountryByName( "South Africa") ),
				new City("Ekurhuleni", 3178470, -26.1777025, 28.3461948, null, cod.getCountryByName( "South Africa") ),
				new City("Suwon", 1202310, 37.2635727, 127.0286009, null, cod.getCountryByName( "South Korea") ),
				new City("Madrid", 3207247, 40.4167754, -3.70379019999995, null, cod.getCountryByName( "Spain") ),
				new City("Barcelona", 1604555, 41.3850639, 2.17340349999994, null, cod.getCountryByName( "Spain") ),
				new City("Khartoum", 3639598, 15.5006544, 32.5598993999999, null, cod.getCountryByName( "Sudan") ),
				new City("New Taipei City", 3954929, 25.0169826, 121.4627868, null, cod.getCountryByName( "Taiwan") ),
				new City("Kaohsiung", 2778918, 22.6272784, 120.301435299999, null, cod.getCountryByName( "Taiwan") ),
				new City("Taichung", 2752413, 24.1477358, 120.6736482, null, cod.getCountryByName( "Taiwan") ),
				new City("Taipei", 2704974, 25.0329694, 121.5654177, null, cod.getCountryByName( "Taiwan") ),
				new City("Tainan", 1885252, 22.9997281, 120.2270277, null, cod.getCountryByName( "Taiwan") ),
				new City("Dar es Salaam", 4364541, -6.792354, 39.2083284, null, cod.getCountryByName( "Tanzania") ),
				new City("Bangkok", 8750600, 13.7563309, 100.5017651, null, cod.getCountryByName( "Thailand") ),
				new City("Tunis", 1056247, 36.8064948, 10.1815315999999, null, cod.getCountryByName( "Tunisia") ),
				new City("Istanbul", 14025000, 41.0082376, 28.9783588999999, null, cod.getCountryByName( "Turkey") ),
				new City("Ankara", 5271000, 39.9333635, 32.8597419, null, cod.getCountryByName( "Turkey") ),
				new City("Izmir", 4168000, 38.423734, 27.142826, null, cod.getCountryByName( "Turkey") ),
				new City("Kampala", 1507080, 0.3475964, 32.5825197, null, cod.getCountryByName( "Uganda") ),
				new City("Kiev", 2908703, 50.4501, 30.5234, null, cod.getCountryByName( "Ukraine") ),
				new City("Kharkiv", 1447881, 49.9935, 36.230383, null, cod.getCountryByName( "Ukraine") ),
				new City("Dubai", 2865560, 25.2048493, 55.2707828, null, cod.getCountryByName( "United Arab Emirates") ),
				new City("Abu Dhabi", 1145000, 24.453884, 54.3773438, null, cod.getCountryByName( "United Arab Emirates") ),
				new City("London", 8787892, 51.5073509, -0.127758299999982, null, cod.getCountryByName( "United Kingdom") ),
				new City("Birmingham", 1111300, 52.4862429999999, -1.89040099999999, null, cod.getCountryByName( "United Kingdom") ),
				new City("New York City", 8537673, 40.7127753, -74.0059728, sd.getStateByName( "New York"), cod.getCountryByName( "United States") ),
				new City("Los Angeles", 3884307, 34.0522342, -118.2436849, sd.getStateByName( "California"), cod.getCountryByName( "United States") ),
				new City("Chicago", 2695598, 41.8781136, -87.6297981999999, sd.getStateByName( "Illinois"), cod.getCountryByName( "United States") ),
				new City("Houston", 2489558, 29.7604267, -95.3698028, sd.getStateByName( "Texas"), cod.getCountryByName( "United States") ),
				new City("Philadelphia", 1567872, 39.9525839, -75.1652215, sd.getStateByName( "Pennsylvania"), cod.getCountryByName( "United States") ),
				new City("Phoenix", 1563025, 33.4483771, -112.074037299999, sd.getStateByName( "Arizona"), cod.getCountryByName( "United States") ),
				new City("San Antonio", 1469845, 29.4241219, -98.4936281999999, sd.getStateByName( "Texas"), cod.getCountryByName( "United States") ),
				new City("San Diego", 1394928, 32.715738, -117.1610838, sd.getStateByName( "California"), cod.getCountryByName( "United States") ),
				new City("Dallas", 1317929, 32.7766642, -96.7969878999999, sd.getStateByName( "Texas"), cod.getCountryByName( "United States") ),
				new City("Montevideo", 1305082, -34.9011127, -56.1645313999999, null, cod.getCountryByName( "Uruguay") ),
				new City("Tashkent", 2309600, 41.2994958, 69.2400734, null, cod.getCountryByName( "Uzbekistan") ),
				new City("Caracas", 1943901, 10.4805937, -66.9036062999999, null, cod.getCountryByName( "Venezuela") ),
				new City("Maracaibo", 1599940, 10.6544509, -71.7147951, null, cod.getCountryByName( "Venezuela") ),
				new City("Ho Chi Minh City", 8426100, 10.8230989, 106.6296638, null, cod.getCountryByName( "Vietnam") ),
				new City("Hanoi", 6844100, 21.0277644, 105.834159799999, null, cod.getCountryByName( "Vietnam") ),
				new City("Sana'a", 1937451, 15.3694451, 44.1910066, null, cod.getCountryByName( "Yemen") ),
				new City("Lusaka", 1742979, -15.3875259, 28.3228165, null, cod.getCountryByName( "Zambia") ),
				new City("Harare", 1606000, -17.8251657, 31.0335099999999, null, cod.getCountryByName( "Zimbabwe") ),
				new City("Bulawayo", 1050000, -20.1325066, 28.626479, null, cod.getCountryByName( "Zimbabwe") )
		};
		
		for (City c : cities) {
			if ( c == null) {
				System.out.println("no city to add");
			}
			System.out.println("adding " + c.getName());
			c.setId(cd.addCity(c));
		}
		
	}

	static void init() {

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		Category c1 = new Category("coding");
		Category c2 = new Category("jokes");

		// create some flashcards to save
		Flashcard f1 = new Flashcard("What is Java?", "The coolest language.", c1);
		Flashcard f2 = new Flashcard("Where are the bears?", "Hibernating", c2);
		Flashcard f3 = new Flashcard("What did the DBA tell his inebriated friend?", "You had one-to-many.", c2);

		s.save(f1);
		s.save(f2);
		s.saveOrUpdate(f3);

		tx.commit();
		s.close();

	}

	static void saveAndPersist(FlashcardDao fd) {
		System.out.println(
				fd.addFlashcard(new Flashcard("What version of Java do we use?", "Java 8", new Category(1, ""))));
	}

	static void getVsLoad(FlashcardDao fd) {
		Flashcard f4 = fd.getFlashcardById(4);

		// get vs load
		if (f4 != null) {
			System.out.println("flashcard 4 exists");
			// f4 is detached
			System.out.println(f4.getQuestion());
			// if Category is lazily fetched, line below throws exception
			// System.out.println(f4.getCategory());
		} else {
			System.out.println("flashcard 4 does not exist");
		}
	}

	static void updateAndMerge() {

		Flashcard f = new Flashcard("Where you stand if you're cold?", "In the corner, it's 90 degrees.",
				new Category(2, "")); // transient

		Session s1 = HibernateUtil.getSession();
		Transaction tx1 = s1.beginTransaction();
		int genId = (int) s1.save(f);
		tx1.commit();
		s1.close();

		// f is detached
		Session s2 = HibernateUtil.getSession();
		Transaction tx2 = s2.beginTransaction();
		try {

			Flashcard f2 = (Flashcard) s2.get(Flashcard.class, genId);
			// f2 is persistent and has same persistence identity (same id) as
			// detached object f
			f.setAnswer("The corner, it's 90 degrees"); // f is still detached
			// s2.update(f);
			// throws NonUniqueObjectException because update attempts to
			// reattach f to s2

			s2.merge(f); // this is fine

			tx2.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx2.rollback();
		}
		s2.close();
	}

	static void funWithNamedQueries(Category c) {

		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("findCardByCategory");
		q.setInteger("categoryVar", c.getId());
		List<Flashcard> cards = q.list();
		System.out.println(cards.size());
		Iterator<Flashcard> itr = cards.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		s.close();

	}

	static void funWithCriteria() {
		Session s = HibernateUtil.getSession();
		// STAY TUNED FOR BEARS
		s.close();

	}

	static void funWithCache() {
		Session s = HibernateUtil.getSession();

		Flashcard f = (Flashcard) s.load(Flashcard.class, 23);
		System.out.println(f.getQuestion());

		// s.evict(f); s.clear() also works for all cached data

		System.out.println(s.contains(f));

		s.close();
	}

	static void caveInit() {

		Cave c1 = new Cave("Reston");
		Cave c2 = new Cave("Herndon");

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		s.persist(c1);
		s.persist(c2);

		tx.commit();
		s.close();
	}

	// THIS SHOULD BE HAPPENING VIA DAO METHODS
	static void animalInit() {

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		Cave c = (Cave) s.get(Cave.class, 2);

		Animal a = new Animal("Mystery", c);
		Bat bat1 = new Bat("Ernie", c, 46);
		Bear bear1 = new Bear("Fred", c, "Grizzly");

		s.save(a);
		s.save(bat1);
		s.save(bear1);

		tx.commit();
		s.close();

	}

	static void moreAnimals() {

		Cave c = new Cave(1, "Reston");

		Bat bat1 = new Bat("Frodo", c, 12);
		Bat bat2 = new Bat("Sam", c, 70);
		Bat bat3 = new Bat("Aragon", c, 140);
		Bear bear1 = new Bear("Gandalf", c, "Wizard");
		Bear bear2 = new Bear("Fred2", c, "Wizard");
		Bear bear3 = new Bear("Saruman", c, "Polar");

		List<Bear> bearList = new ArrayList<>();

		bearList.add(bear1);
		bearList.add(bear2);
		bearList.add(bear3);

		List<Bat> batList = new ArrayList<>();

		batList.add(bat1);
		batList.add(bat2);
		batList.add(bat3);
		
		BearDao bearDao = new BearDaoImpl();
		BatDao batDao = new BatDaoImpl();
		
		bearDao.addBears(bearList);
		batDao.addBats(batList);

	}
}