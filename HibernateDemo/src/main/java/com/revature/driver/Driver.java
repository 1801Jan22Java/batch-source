package com.revature.driver;

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
		cityInit();

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
	
	static void cityInit() {
		StateDao sd = new StateDaoImpl();
		CityDao cd = new CityDaoImpl();
		City[] cities = {
				new City("New York", 40.6635, -73.9387, sd.getStateByName( "New York") ),
				new City("Los Angeles", 34.0194, -118.4108, sd.getStateByName( "California") ),
				new City("Chicago", 41.8376, -87.6818, sd.getStateByName( "Illinois") ),
				new City("Houston", 29.7866, -95.3909, sd.getStateByName( "Texas") ),
				new City("Phoenix", 33.5722, -112.0901, sd.getStateByName( "Arizona") ),
				new City("Philadelphia", 40.0094, -75.1333, sd.getStateByName( "Pennsylvania") ),
				new City("San Antonio", 29.4724, -98.5251, sd.getStateByName( "Texas") ),
				new City("San Diego", 32.8153, -117.135, sd.getStateByName( "California") ),
				new City("Dallas", 32.7933, -96.7665, sd.getStateByName( "Texas") ),
				new City("San Jose", 37.2967, -121.8189, sd.getStateByName( "California") ),
				new City("Austin", 30.3039, -97.7544, sd.getStateByName( "Texas") ),
				new City("Jacksonville", 30.3369, -81.6616, sd.getStateByName( "Florida") ),
				new City("San Francisco", 37.7272, -123.0322, sd.getStateByName( "California") ),
				new City("Columbus", 39.9852, -82.9848, sd.getStateByName( "Ohio") ),
				new City("Indianapolis", 39.7767, -86.1459, sd.getStateByName( "Indiana") ),
				new City("Fort Worth", 32.7815, -97.3467, sd.getStateByName( "Texas") ),
				new City("Charlotte", 35.2078, -80.831, sd.getStateByName( "North Carolina") ),
				new City("Seattle", 47.6205, -122.3509, sd.getStateByName( "Washington") ),
				new City("Denver", 39.7619, -104.8811, sd.getStateByName( "Colorado") ),
				new City("El Paso", 31.8484, -106.427, sd.getStateByName( "Texas") ),
				new City("Washington", 38.9041, -77.0172, sd.getStateByName( "District of Columbia") ),
				new City("Boston", 42.332, -71.0202, sd.getStateByName( "Massachusetts") ),
				new City("Detroit", 42.383, -83.1022, sd.getStateByName( "Michigan") ),
				new City("Nashville", 36.1718, -86.785, sd.getStateByName( "Tennessee") ),
				new City("Memphis", 35.1028, -89.9774, sd.getStateByName( "Tennessee") ),
				new City("Portland", 45.537, -122.65, sd.getStateByName( "Oregon") ),
				new City("Oklahoma City", 35.4671, -97.5137, sd.getStateByName( "Oklahoma") ),
				new City("Las Vegas", 36.2292, -115.2601, sd.getStateByName( "Nevada") ),
				new City("Louisville", 38.1654, -85.6474, sd.getStateByName( "Kentucky") ),
				new City("Baltimore", 39.3, -76.6105, sd.getStateByName( "Maryland") ),
				new City("Milwaukee", 43.0633, -87.9667, sd.getStateByName( "Wisconsin") ),
				new City("Albuquerque", 35.1056, -106.6474, sd.getStateByName( "New Mexico") ),
				new City("Tucson", 32.1531, -110.8706, sd.getStateByName( "Arizona") ),
				new City("Fresno", 36.7836, -119.7934, sd.getStateByName( "California") ),
				new City("Sacramento", 38.5666, -121.4686, sd.getStateByName( "California") ),
				new City("Mesa", 33.4019, -111.7174, sd.getStateByName( "Arizona") ),
				new City("Kansas City", 39.1251, -94.551, sd.getStateByName( "Missouri") ),
				new City("Atlanta", 33.7629, -84.4227, sd.getStateByName( "Georgia") ),
				new City("Long Beach", 33.8092, -118.1553, sd.getStateByName( "California") ),
				new City("Colorado Springs", 38.8673, -104.7607, sd.getStateByName( "Colorado") ),
				new City("Raleigh", 35.8306, -78.6418, sd.getStateByName( "North Carolina") ),
				new City("Miami", 25.7752, -80.2086, sd.getStateByName( "Florida") ),
				new City("Virginia Beach", 36.78, -76.0252, sd.getStateByName( "Virginia") ),
				new City("Omaha", 41.2644, -96.0451, sd.getStateByName( "Nebraska") ),
				new City("Oakland", 37.7698, -122.2257, sd.getStateByName( "California") ),
				new City("Minneapolis", 44.9633, -93.2683, sd.getStateByName( "Minnesota") ),
				new City("Tulsa", 36.1279, -95.9023, sd.getStateByName( "Oklahoma") ),
				new City("Arlington", 32.7007, -97.1247, sd.getStateByName( "Texas") ),
				new City("New Orleans", 30.0534, -89.9345, sd.getStateByName( "Louisiana") ),
				new City("Wichita", 37.6907, -97.3459, sd.getStateByName( "Kansas") ),
				new City("Cleveland", 41.4785, -81.6794, sd.getStateByName( "Ohio") ),
				new City("Tampa", 27.9701, -82.4797, sd.getStateByName( "Florida") ),
				new City("Bakersfield", 35.3212, -119.0183, sd.getStateByName( "California") ),
				new City("Aurora", 39.688, -104.6897, sd.getStateByName( "Colorado") ),
				new City("Honolulu", 21.3243, -157.8476, sd.getStateByName( "Hawaii") ),
				new City("Anaheim", 33.8555, -117.7601, sd.getStateByName( "California") ),
				new City("Santa Ana", 33.7363, -117.883, sd.getStateByName( "California") ),
				new City("Corpus Christi", 27.7543, -97.1734, sd.getStateByName( "Texas") ),
				new City("Riverside", 33.9381, -117.3932, sd.getStateByName( "California") ),
				new City("Lexington", 38.0407, -84.4583, sd.getStateByName( "Kentucky") ),
				new City("St. Louis", 38.6357, -90.2446, sd.getStateByName( "Missouri") ),
				new City("Stockton", 37.9763, -121.3133, sd.getStateByName( "California") ),
				new City("Pittsburgh", 40.4398, -79.9766, sd.getStateByName( "Pennsylvania") ),
				new City("Saint Paul", 44.9489, -93.1041, sd.getStateByName( "Minnesota") ),
				new City("Cincinnati", 39.1402, -84.5058, sd.getStateByName( "Ohio") ),
				new City("Anchorage", 61.1743, -149.2843, sd.getStateByName( "Alaska") ),
				new City("Henderson", 36.0097, -115.0357, sd.getStateByName( "Nevada") ),
				new City("Greensboro", 36.0951, -79.827, sd.getStateByName( "North Carolina") ),
				new City("Plano", 33.0508, -96.7479, sd.getStateByName( "Texas") ),
				new City("Newark", 40.7242, -74.1726, sd.getStateByName( "New Jersey") ),
				new City("Lincoln", 40.8105, -96.6803, sd.getStateByName( "Nebraska") ),
				new City("Toledo", 41.6641, -83.5819, sd.getStateByName( "Ohio") ),
				new City("Orlando", 28.4166, -81.2736, sd.getStateByName( "Florida") ),
				new City("Chula Vista", 32.6277, -117.0152, sd.getStateByName( "California") ),
				new City("Irvine", 33.6784, -117.7713, sd.getStateByName( "California") ),
				new City("Fort Wayne", 41.0882, -85.1439, sd.getStateByName( "Indiana") ),
				new City("Jersey City", 40.7114, -74.0648, sd.getStateByName( "New Jersey") ),
				new City("Durham", 35.9811, -78.9029, sd.getStateByName( "North Carolina") ),
				new City("St. Petersburg", 27.762, -82.6441, sd.getStateByName( "Florida") ),
				new City("Laredo", 27.5604, -99.4892, sd.getStateByName( "Texas") ),
				new City("Buffalo", 42.8925, -78.8597, sd.getStateByName( "New York") ),
				new City("Madison", 43.0878, -89.4299, sd.getStateByName( "Wisconsin") ),
				new City("Lubbock", 33.5656, -101.8867, sd.getStateByName( "Texas") ),
				new City("Chandler", 33.2829, -111.8549, sd.getStateByName( "Arizona") ),
				new City("Scottsdale", 33.6843, -111.8611, sd.getStateByName( "Arizona") ),
				new City("Glendale", 33.5331, -112.1899, sd.getStateByName( "Arizona") ),
				new City("Reno", 39.5491, -119.8499, sd.getStateByName( "Nevada") ),
				new City("Norfolk", 36.923, -76.2446, sd.getStateByName( "Virginia") ),
				new City("Winston–Salem", 36.1027, -80.261, sd.getStateByName( "North Carolina") ),
				new City("North Las Vegas", 36.2857, -115.0939, sd.getStateByName( "Nevada") ),
				new City("Irving", 32.8577, -96.97, sd.getStateByName( "Texas") ),
				new City("Chesapeake", 36.6794, -76.3018, sd.getStateByName( "Virginia") ),
				new City("Gilbert", 33.3103, -111.7431, sd.getStateByName( "Arizona") ),
				new City("Hialeah", 25.8699, -80.3029, sd.getStateByName( "Florida") ),
				new City("Garland", 32.9098, -96.6303, sd.getStateByName( "Texas") ),
				new City("Fremont", 37.4945, -121.9412, sd.getStateByName( "California") ),
				new City("Baton Rouge", 30.4422, -91.1309, sd.getStateByName( "Louisiana") ),
				new City("Richmond", 37.5314, -77.476, sd.getStateByName( "Virginia") ),
				new City("Boise", 43.6002, -116.2317, sd.getStateByName( "Idaho") ),
				new City("San Bernardino", 34.1416, -117.2936, sd.getStateByName( "California") ),
				new City("Spokane", 47.6669, -117.4333, sd.getStateByName( "Washington") ),
				new City("Des Moines", 41.5726, -93.6102, sd.getStateByName( "Iowa") ),
				new City("Modesto", 37.6375, -121.003, sd.getStateByName( "California") ),
				new City("Birmingham", 33.5274, -86.799, sd.getStateByName( "Alabama") ),
				new City("Tacoma", 47.2522, -122.4598, sd.getStateByName( "Washington") ),
				new City("Fontana", 34.109, -117.4629, sd.getStateByName( "California") ),
				new City("Rochester", 43.1699, -77.6169, sd.getStateByName( "New York") ),
				new City("Oxnard", 34.2023, -119.2046, sd.getStateByName( "California") ),
				new City("Moreno Valley", 33.9233, -117.2057, sd.getStateByName( "California") ),
				new City("Fayetteville", 35.0828, -78.9735, sd.getStateByName( "North Carolina") ),
				new City("Aurora", 41.7635, -88.2901, sd.getStateByName( "Illinois") ),
				new City("Glendale", 34.1814, -118.2458, sd.getStateByName( "California") ),
				new City("Yonkers", 40.9459, -73.8674, sd.getStateByName( "New York") ),
				new City("Huntington Beach", 33.6906, -118.0093, sd.getStateByName( "California") ),
				new City("Montgomery", 32.3472, -86.2661, sd.getStateByName( "Alabama") ),
				new City("Amarillo", 35.1999, -101.8302, sd.getStateByName( "Texas") ),
				new City("Little Rock", 34.7254, -92.3586, sd.getStateByName( "Arkansas") ),
				new City("Akron", 41.0805, -81.5214, sd.getStateByName( "Ohio") ),
				new City("Columbus", 32.5102, -84.8749, sd.getStateByName( "Georgia") ),
				new City("Augusta", 33.3655, -82.0734, sd.getStateByName( "Georgia") ),
				new City("Grand Rapids", 42.9612, -85.6556, sd.getStateByName( "Michigan") ),
				new City("Shreveport", 32.4669, -93.7922, sd.getStateByName( "Louisiana") ),
				new City("Salt Lake City", 40.7769, -111.931, sd.getStateByName( "Utah") ),
				new City("Huntsville", 34.699, -86.673, sd.getStateByName( "Alabama") ),
				new City("Mobile", 30.6684, -88.1002, sd.getStateByName( "Alabama") ),
				new City("Tallahassee", 30.4551, -84.2534, sd.getStateByName( "Florida") ),
				new City("Grand Prairie", 32.6869, -97.0211, sd.getStateByName( "Texas") ),
				new City("Overland Park", 38.889, -94.6906, sd.getStateByName( "Kansas") ),
				new City("Knoxville", 35.9707, -83.9493, sd.getStateByName( "Tennessee") ),
				new City("Port St. Lucie", 27.2806, -80.3883, sd.getStateByName( "Florida") ),
				new City("Worcester", 42.2695, -71.8078, sd.getStateByName( "Massachusetts") ),
				new City("Brownsville", 25.9991, -97.455, sd.getStateByName( "Texas") ),
				new City("Tempe", 33.3884, -111.9318, sd.getStateByName( "Arizona") ),
				new City("Santa Clarita", 34.403, -118.5042, sd.getStateByName( "California") ),
				new City("Newport News", 37.0762, -76.522, sd.getStateByName( "Virginia") ),
				new City("Cape Coral", 26.6432, -81.9974, sd.getStateByName( "Florida") ),
				new City("Providence", 41.8231, -71.4188, sd.getStateByName( "Rhode Island") ),
				new City("Fort Lauderdale", 26.1412, -80.1467, sd.getStateByName( "Florida") ),
				new City("Chattanooga", 35.066, -85.2484, sd.getStateByName( "Tennessee") ),
				new City("Rancho Cucamonga", 34.1233, -117.5642, sd.getStateByName( "California") ),
				new City("Oceanside", 33.2245, -117.3062, sd.getStateByName( "California") ),
				new City("Santa Rosa", 38.4468, -122.7061, sd.getStateByName( "California") ),
				new City("Garden Grove", 33.7788, -117.9605, sd.getStateByName( "California") ),
				new City("Vancouver", 45.6349, -122.5957, sd.getStateByName( "Washington") ),
				new City("Sioux Falls", 43.5383, -96.732, sd.getStateByName( "South Dakota") ),
				new City("Ontario", 34.0394, -117.6042, sd.getStateByName( "California") ),
				new City("McKinney", 33.1985, -96.668, sd.getStateByName( "Texas") ),
				new City("Elk Grove", 38.4146, -121.385, sd.getStateByName( "California") ),
				new City("Jackson", 32.3158, -90.2128, sd.getStateByName( "Mississippi") ),
				new City("Pembroke Pines", 26.021, -80.3404, sd.getStateByName( "Florida") ),
				new City("Salem", 44.9237, -123.0232, sd.getStateByName( "Oregon") ),
				new City("Springfield", 37.1942, -93.2913, sd.getStateByName( "Missouri") ),
				new City("Corona", 33.862, -117.5655, sd.getStateByName( "California") ),
				new City("Eugene", 44.0567, -123.1162, sd.getStateByName( "Oregon") ),
				new City("Fort Collins", 40.5482, -105.0648, sd.getStateByName( "Colorado") ),
				new City("Peoria", 33.7862, -112.308, sd.getStateByName( "Arizona") ),
				new City("Frisco", 33.1554, -96.8226, sd.getStateByName( "Texas") ),
				new City("Cary", 35.7809, -78.8133, sd.getStateByName( "North Carolina") ),
				new City("Lancaster", 34.6936, -118.1753, sd.getStateByName( "California") ),
				new City("Hayward", 37.6287, -122.1024, sd.getStateByName( "California") ),
				new City("Palmdale", 34.591, -118.1054, sd.getStateByName( "California") ),
				new City("Salinas", 36.6902, -121.6337, sd.getStateByName( "California") ),
				new City("Alexandria", 38.8201, -77.0841, sd.getStateByName( "Virginia") ),
				new City("Lakewood", 39.6989, -105.1176, sd.getStateByName( "Colorado") ),
				new City("Springfield", 42.1155, -72.54, sd.getStateByName( "Massachusetts") ),
				new City("Pasadena", 29.6586, -95.1506, sd.getStateByName( "Texas") ),
				new City("Sunnyvale", 37.3858, -122.0263, sd.getStateByName( "California") ),
				new City("Macon", 32.8088, -83.6942, sd.getStateByName( "Georgia") ),
				new City("Pomona", 34.0585, -117.7611, sd.getStateByName( "California") ),
				new City("Hollywood", 26.031, -80.1646, sd.getStateByName( "Florida") ),
				new City("Kansas City", 39.1225, -94.7418, sd.getStateByName( "Kansas") ),
				new City("Escondido", 33.1331, -117.074, sd.getStateByName( "California") ),
				new City("Clarksville", 36.5664, -87.3452, sd.getStateByName( "Tennessee") ),
				new City("Joliet", 41.5177, -88.1488, sd.getStateByName( "Illinois") ),
				new City("Rockford", 42.2588, -89.0646, sd.getStateByName( "Illinois") ),
				new City("Torrance", 33.835, -118.3414, sd.getStateByName( "California") ),
				new City("Naperville", 41.7492, -88.162, sd.getStateByName( "Illinois") ),
				new City("Paterson", 40.9148, -74.1628, sd.getStateByName( "New Jersey") ),
				new City("Savannah", 32.0025, -81.1536, sd.getStateByName( "Georgia") ),
				new City("Bridgeport", 41.1874, -73.1958, sd.getStateByName( "Connecticut") ),
				new City("Mesquite", 32.7629, -96.5888, sd.getStateByName( "Texas") ),
				new City("Killeen", 31.0777, -97.732, sd.getStateByName( "Texas") ),
				new City("Syracuse", 43.041, -76.1436, sd.getStateByName( "New York") ),
				new City("McAllen", 26.2322, -98.2464, sd.getStateByName( "Texas") ),
				new City("Pasadena", 34.1606, -118.1396, sd.getStateByName( "California") ),
				new City("Bellevue", 47.5979, -122.1565, sd.getStateByName( "Washington") ),
				new City("Fullerton", 33.8857, -117.928, sd.getStateByName( "California") ),
				new City("Orange", 33.787, -117.8613, sd.getStateByName( "California") ),
				new City("Dayton", 39.7774, -84.1996, sd.getStateByName( "Ohio") ),
				new City("Miramar", 25.977, -80.3358, sd.getStateByName( "Florida") ),
				new City("Thornton", 39.9194, -104.9428, sd.getStateByName( "Colorado") ),
				new City("West Valley City", 40.6885, -112.0118, sd.getStateByName( "Utah") ),
				new City("Olathe", 38.8843, -94.8195, sd.getStateByName( "Kansas") ),
				new City("Hampton", 37.048, -76.2971, sd.getStateByName( "Virginia") ),
				new City("Warren", 42.4929, -83.025, sd.getStateByName( "Michigan") ),
				new City("Midland", 32.0246, -102.1135, sd.getStateByName( "Texas") ),
				new City("Waco", 31.5601, -97.186, sd.getStateByName( "Texas") ),
				new City("Charleston", 32.8179, -79.959, sd.getStateByName( "South Carolina") ),
				new City("Columbia", 34.0291, -80.898, sd.getStateByName( "South Carolina") ),
				new City("Denton", 33.2166, -97.1414, sd.getStateByName( "Texas") ),
				new City("Carrollton", 32.9884, -96.8998, sd.getStateByName( "Texas") ),
				new City("Surprise", 33.6706, -112.4527, sd.getStateByName( "Arizona") ),
				new City("Roseville", 38.769, -121.3189, sd.getStateByName( "California") ),
				new City("Sterling Heights", 42.5812, -83.0303, sd.getStateByName( "Michigan") ),
				new City("Murfreesboro", 35.8522, -86.416, sd.getStateByName( "Tennessee") ),
				new City("Gainesville", 29.6788, -82.3461, sd.getStateByName( "Florida") ),
				new City("Cedar Rapids", 41.967, -91.6778, sd.getStateByName( "Iowa") ),
				new City("Visalia", 36.3273, -119.3289, sd.getStateByName( "California") ),
				new City("Coral Springs", 26.2707, -80.2593, sd.getStateByName( "Florida") ),
				new City("New Haven", 41.3108, -72.925, sd.getStateByName( "Connecticut") ),
				new City("Stamford", 41.0799, -73.546, sd.getStateByName( "Connecticut") ),
				new City("Thousand Oaks", 34.1933, -118.8742, sd.getStateByName( "California") ),
				new City("Concord", 37.9722, -122.0016, sd.getStateByName( "California") ),
				new City("Elizabeth", 40.6664, -74.1935, sd.getStateByName( "New Jersey") ),
				new City("Lafayette", 30.2074, -92.0285, sd.getStateByName( "Louisiana") ),
				new City("Kent", 47.388, -122.2127, sd.getStateByName( "Washington") ),
				new City("Topeka", 39.0347, -95.6962, sd.getStateByName( "Kansas") ),
				new City("Simi Valley", 34.2669, -118.7485, sd.getStateByName( "California") ),
				new City("Santa Clara", 37.3646, -121.9679, sd.getStateByName( "California") ),
				new City("Athens", 33.9496, -83.3701, sd.getStateByName( "Georgia") ),
				new City("Hartford", 41.7659, -72.6816, sd.getStateByName( "Connecticut") ),
				new City("Victorville", 34.5277, -117.3536, sd.getStateByName( "California") ),
				new City("Abilene", 32.4545, -99.7381, sd.getStateByName( "Texas") ),
				new City("Norman", 35.2406, -97.3453, sd.getStateByName( "Oklahoma") ),
				new City("Vallejo", 38.1079, -122.264, sd.getStateByName( "California") ),
				new City("Berkeley", 37.867, -122.2991, sd.getStateByName( "California") ),
				new City("Round Rock", 30.5252, -97.666, sd.getStateByName( "Texas") ),
				new City("Ann Arbor", 42.2761, -83.7309, sd.getStateByName( "Michigan") ),
				new City("Fargo", 46.8652, -96.829, sd.getStateByName( "North Dakota") ),
				new City("Columbia", 38.9473, -92.3264, sd.getStateByName( "Missouri") ),
				new City("Allentown", 40.5936, -75.4784, sd.getStateByName( "Pennsylvania") ),
				new City("Evansville", 37.9877, -87.5347, sd.getStateByName( "Indiana") ),
				new City("Beaumont", 30.0849, -94.1453, sd.getStateByName( "Texas") ),
				new City("Odessa", 31.8838, -102.3411, sd.getStateByName( "Texas") ),
				new City("Wilmington", 34.2092, -77.8858, sd.getStateByName( "North Carolina") ),
				new City("Arvada", 39.8337, -105.1503, sd.getStateByName( "Colorado") ),
				new City("Independence", 39.0855, -94.3521, sd.getStateByName( "Missouri") ),
				new City("Provo", 40.2453, -111.6448, sd.getStateByName( "Utah") ),
				new City("Lansing", 42.7143, -84.5593, sd.getStateByName( "Michigan") ),
				new City("El Monte", 34.0746, -118.0291, sd.getStateByName( "California") ),
				new City("Springfield", 39.7911, -89.6446, sd.getStateByName( "Illinois") ),
				new City("Fairfield", 38.2593, -122.0321, sd.getStateByName( "California") ),
				new City("Clearwater", 27.9789, -82.7666, sd.getStateByName( "Florida") ),
				new City("Peoria", 40.7515, -89.6174, sd.getStateByName( "Illinois") ),
				new City("Rochester", 44.0154, -92.4772, sd.getStateByName( "Minnesota") ),
				new City("Carlsbad", 33.1239, -117.2828, sd.getStateByName( "California") ),
				new City("Westminster", 39.8822, -105.0644, sd.getStateByName( "Colorado") ),
				new City("West Jordan", 40.6024, -112.0008, sd.getStateByName( "Utah") ),
				new City("Pearland", 29.5558, -95.3231, sd.getStateByName( "Texas") ),
				new City("Richardson", 32.9723, -96.7081, sd.getStateByName( "Texas") ),
				new City("Downey", 33.9382, -118.1309, sd.getStateByName( "California") ),
				new City("Miami Gardens", 25.9489, -80.2436, sd.getStateByName( "Florida") ),
				new City("Temecula", 33.4931, -117.1317, sd.getStateByName( "California") ),
				new City("Costa Mesa", 33.6659, -117.9123, sd.getStateByName( "California") ),
				new City("College Station", 30.5852, -96.2964, sd.getStateByName( "Texas") ),
				new City("Elgin", 42.0396, -88.3217, sd.getStateByName( "Illinois") ),
				new City("Murrieta", 33.5721, -117.1904, sd.getStateByName( "California") ),
				new City("Gresham", 45.5023, -122.4416, sd.getStateByName( "Oregon") ),
				new City("High Point", 35.99, -79.9905, sd.getStateByName( "North Carolina") ),
				new City("Antioch", 37.9791, -121.7962, sd.getStateByName( "California") ),
				new City("Inglewood", 33.9561, -118.3443, sd.getStateByName( "California") ),
				new City("Cambridge", 42.376, -71.1187, sd.getStateByName( "Massachusetts") ),
				new City("Lowell", 42.639, -71.3211, sd.getStateByName( "Massachusetts") ),
				new City("Manchester", 42.9849, -71.4441, sd.getStateByName( "New Hampshire") ),
				new City("Billings", 45.7885, -108.5499, sd.getStateByName( "Montana") ),
				new City("Pueblo", 38.2699, -104.6123, sd.getStateByName( "Colorado") ),
				new City("Palm Bay", 27.9856, -80.6626, sd.getStateByName( "Florida") ),
				new City("Centennial", 39.5906, -104.8691, sd.getStateByName( "Colorado") ),
				new City("Richmond", 37.9523, -122.3606, sd.getStateByName( "California") ),
				new City("Ventura", 34.2678, -119.2542, sd.getStateByName( "California") ),
				new City("Pompano Beach", 26.2416, -80.1339, sd.getStateByName( "Florida") ),
				new City("North Charleston", 32.9178, -80.065, sd.getStateByName( "South Carolina") ),
				new City("Everett", 47.9566, -122.1914, sd.getStateByName( "Washington") ),
				new City("Waterbury", 41.5585, -73.0367, sd.getStateByName( "Connecticut") ),
				new City("West Palm Beach", 26.7464, -80.1251, sd.getStateByName( "Florida") ),
				new City("Boulder", 40.027, -105.2519, sd.getStateByName( "Colorado") ),
				new City("West Covina", 34.0559, -117.9099, sd.getStateByName( "California") ),
				new City("Broken Arrow", 36.0365, -95.781, sd.getStateByName( "Oklahoma") ),
				new City("Clovis", 36.8282, -119.6849, sd.getStateByName( "California") ),
				new City("Daly City", 37.7009, -122.465, sd.getStateByName( "California") ),
				new City("Lakeland", 28.0555, -81.9549, sd.getStateByName( "Florida") ),
				new City("Santa Maria", 34.9332, -120.4438, sd.getStateByName( "California") ),
				new City("Norwalk", 33.9076, -118.0835, sd.getStateByName( "California") ),
				new City("Sandy Springs", 33.9315, -84.3687, sd.getStateByName( "Georgia") ),
				new City("Hillsboro", 45.528, -122.9357, sd.getStateByName( "Oregon") ),
				new City("Green Bay", 44.5207, -87.9842, sd.getStateByName( "Wisconsin") ),
				new City("Tyler", 32.3173, -95.3059, sd.getStateByName( "Texas") ),
				new City("Wichita Falls", 33.9067, -98.5259, sd.getStateByName( "Texas") ),
				new City("Lewisville", 33.0466, -96.9818, sd.getStateByName( "Texas") ),
				new City("Burbank", 34.1901, -118.3264, sd.getStateByName( "California") ),
				new City("Greeley", 40.4153, -104.7697, sd.getStateByName( "Colorado") ),
				new City("San Mateo", 37.5603, -122.3106, sd.getStateByName( "California") ),
				new City("El Cajon", 32.8017, -116.9604, sd.getStateByName( "California") ),
				new City("Jurupa Valley", 34.0026, -117.4676, sd.getStateByName( "California") ),
				new City("Rialto", 34.1118, -117.3883, sd.getStateByName( "California") ),
				new City("Davenport", 41.5541, -90.604, sd.getStateByName( "Iowa") ),
				new City("League City", 29.4901, -95.1091, sd.getStateByName( "Texas") ),
				new City("Edison", 40.504, -74.3494, sd.getStateByName( "New Jersey") ),
				new City("Davie", 26.0791, -80.285, sd.getStateByName( "Florida") ),
				new City("Las Cruces", 32.3264, -106.7897, sd.getStateByName( "New Mexico") ),
				new City("South Bend", 41.6769, -86.269, sd.getStateByName( "Indiana") ),
				new City("Vista", 33.1895, -117.2386, sd.getStateByName( "California") ),
				new City("Woodbridge", 40.5607, -74.2927, sd.getStateByName( "New Jersey") ),
				new City("Renton", 47.4761, -122.192, sd.getStateByName( "Washington") ),
				new City("Lakewood", 40.0771, -74.2004, sd.getStateByName( "New Jersey") ),
				new City("San Angelo", 31.4411, -100.4505, sd.getStateByName( "Texas") ),
				new City("Clinton", 42.5903, -82.917, sd.getStateByName( "Michigan") )
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