		package com.revature.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.CityDao;
import com.revature.dao.CityDaoImpl;
import com.revature.dao.CommonLookupDaoImpl;
import com.revature.dao.EndUserDao;
import com.revature.dao.FeedbackDao;
import com.revature.dao.FlightDaoImpl;
import com.revature.dao.ReservationDao;
import com.revature.domain.City;
import com.revature.domain.CommonLookup;
import com.revature.domain.EndUser;
import com.revature.domain.Feedback;
import com.revature.domain.Flight;
import com.revature.domain.Reservation;
import com.revature.exception.FullFlightException;
import com.revature.formatted.EmailPass;
import com.revature.formatted.FeedbackInfo;
import com.revature.formatted.FlightDetails;
import com.revature.formatted.FlightID;
import com.revature.formatted.FlightReservation;
import com.revature.formatted.FlightSearchInfo;
import com.revature.formatted.LoginInfo;
import com.revature.formatted.PasswordChange;
import com.revature.formatted.ProfileAutofill;
import com.revature.formatted.ProfileChange;
import com.revature.formatted.RegistrationInfo;
import com.revature.formatted.ReservationDetails;
import com.revature.formatted.UserID;


@Controller("endUserController")
@RequestMapping("/util")
public class EndUserController {
	
	@Autowired
	CommonLookupDaoImpl cldi;
	
	@Autowired
	EndUserDao eudi;
	
	@Autowired
	FeedbackDao fd;
	
	@Autowired
	FlightDaoImpl fdi;
	
	@Autowired
	ReservationDao rdi;
	
	/*
	 * EndUser Controller Methods
	 */
	
	//Returns the EndUser who just registered their account, parsed into JSON
	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<LoginInfo> registerAccount(@RequestBody RegistrationInfo userInfo) {

		EndUser user = userInfo.createUser();
		eudi.addEndUser(user);
		
		return new ResponseEntity<LoginInfo>(user.convertToLoginInfo(), HttpStatus.OK);
	}
	
	@PostMapping("/fillprofile")
	@ResponseBody
	public ResponseEntity<EndUser> profile(@RequestBody ProfileAutofill newId) {
		EndUser user = eudi.getEndUserById(newId.getId());
		return new ResponseEntity<EndUser>(user, HttpStatus.OK);
	}
	
	@PostMapping("/profile")
	@ResponseBody
	public String profile(@RequestBody ProfileChange changes) {

		
		EndUser user = eudi.getEndUserByEmail(changes.getEmail());
		boolean success = true;
		
		//Change info if fields aren't blank
		if(!changes.getFirstname().equals("")) {
			user.setFirstname(changes.getFirstname());
		}
		if(!changes.getLastname().equals("")) {
			user.setLastname(changes.getLastname());
		}
		//If the user entered a NEW email.
		if(!changes.getEmail().equals("") && !user.getEmail().equals(changes.getEmail())) {
			EndUser existingEmailCheck = eudi.getEndUserByEmail(changes.getEmail());
			if(existingEmailCheck == null) {
				user.setEmail(changes.getEmail());
			}
			else {
				success = false;
			}
		}
		if(!changes.getNewpassword().equals("")) {
			user.setPassword(changes.getNewpassword());
		}
		if(!changes.getAnswer1().equals("")) {
			user.setSecretAnswer1(changes.getAnswer1());
		}
		if(!changes.getAnswer2().equals("")) {
			user.setSecretAnswer2(changes.getAnswer2());
		}
		if(!changes.getAnswer3().equals("")) {
			user.setSecretAnswer3(changes.getAnswer3());
		}
		
		if(success) {
			eudi.updateEndUser(user);
			//return new ResponseEntity<EndUser>(user, HttpStatus.OK);
			return "done";
		}
		return "bad";
	}
	
	
	@PostMapping("/reset")
	@ResponseBody
	public ResponseEntity<LoginInfo> profile(@RequestBody PasswordChange newFields) {

		
		EndUser user = eudi.getEndUserById(newFields.getId());
		
		//Change info if fields aren't blank
		if(user.getSecretAnswer1().equals(newFields.getAnswer1()) &&
				user.getSecretAnswer2().equals(newFields.getAnswer2()) &&
				user.getSecretAnswer3().equals(newFields.getAnswer3())) {
			user.setPassword(newFields.getNewpassword());
		}
		
		eudi.updateEndUser(user);
		

		return new ResponseEntity<LoginInfo>(user.convertToLoginInfo(), HttpStatus.OK);
	}
	
	
	@RequestMapping("/login")
	@ResponseBody
	public ResponseEntity<LoginInfo> login(@RequestBody EmailPass user
						/*@RequestParam("email") String email,
						@RequestParam("password") String password*/) {
		LoginInfo thisUser = null;
		
		EndUser toCheck = eudi.getEndUserByEmail(user.getEmail());
		
		if(user.getPassword().equals(toCheck.getPassword())) {
			thisUser = toCheck.convertToLoginInfo();
			return new ResponseEntity<LoginInfo>(thisUser, HttpStatus.OK);
		}
		
		return new ResponseEntity<LoginInfo>(thisUser, HttpStatus.UNAUTHORIZED);
	}
	
	
	//Pending our decision on session management
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout() {
		return null;
	}
	
	
	@RequestMapping("/admin/nofly")
	@ResponseBody
	public ResponseEntity<EndUser> noFly(@RequestBody PasswordChange userID) {
		EndUser user = eudi.getEndUserById(userID.getId());
		
		user.setNoFly(true);
		eudi.updateEndUser(user);


		return new ResponseEntity<EndUser>(user, HttpStatus.OK);
	}
	
	
	/*
	 * Feedback Controller Methods
	 */
	
	@PostMapping("/feedback")
	@ResponseBody
	public ResponseEntity<Feedback> addFeedback(@RequestBody FeedbackInfo fbInfo) {
		Feedback feedback = new Feedback(eudi.getEndUserById(fbInfo.getUserId()), fbInfo.getMessage());
		fd.addFeedback(feedback);
		
		return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
	}
	
	
	// Still needs to be sorted when queried
	
	@PostMapping("/admin/feedback")
	@ResponseBody
	public ResponseEntity<List<Feedback>> getAllFeedback() {
		List<Feedback> feedbackList = fd.getAllFeedback();

		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}
	
	
	@PostMapping("/admin/read")
	@ResponseBody
	public ResponseEntity<Feedback> deleteFeedback(@RequestBody int feedbackID) {
		Feedback feedback = fd.getFeedbackById(feedbackID);
		fd.deleteFeedback(feedback);

		//Can simply return nothing if we want to.
		return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
	}
	

	/*
	 * Flight Controller Methods
	 */
	
	@PostMapping("/flight-search")
	@ResponseBody
	public ResponseEntity<List<Flight>> flightSearch(@RequestBody FlightSearchInfo search) {
		CityDao cd = new CityDaoImpl();
		List<Flight> flightList = null;
		City city = cd.getCityByOnlyName(search.getDestination());

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		String strDate = search.getEarliestDate();
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			
		}
		
		//Parse search.getEarliestDate() into a Date object here.
		flightList = fdi.searchFlight(date, city);
		
		return new ResponseEntity<List<Flight>>(flightList, HttpStatus.OK);
	}
	
	
	@PostMapping("/flight-details")
	@ResponseBody
	public ResponseEntity<FlightDetails> flightDetails(@RequestBody FlightID flightId) {
		Flight flight = fdi.getFlightById(flightId.getId());
		
		//Get the status
		Reservation reservation = rdi.getReservationByFlight(flight);
		CommonLookup cl = null;
		if(reservation != null) {
			cl = reservation.getStatus();
		}
		else {
			cl = cldi.getCommonLookupByName("RESERVATION_STATUS", "Cancelled");
		}
		
		FlightDetails flightDetails = new FlightDetails(flight, cl);

		return new ResponseEntity<FlightDetails>(flightDetails, HttpStatus.OK);
	}
	
	
	@PostMapping("/flight-history")
	@ResponseBody
	public ResponseEntity<List<Flight>> flightHistory(@RequestBody UserID id) {
		List<Flight> flights = fdi.getFlightsByUserId(id.getId());
		
		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
	}
	
	
	/*
	 * Returns a JSON string containing a list of 10 soonest arrivals, followed by 10 soonest departures
	 */
	@PostMapping("/all-flights")
	@ResponseBody
	public ResponseEntity<List<Flight>> allFlights() {
		List<Flight> flightList = fdi.getMostRecent10Arrivals();
		List<Flight> flightListDepartures = fdi.getMostRecent10Departures();
		for(Flight f : flightListDepartures) {
			flightList.add(f);
		}
		
		return new ResponseEntity<List<Flight>>(flightList, HttpStatus.OK);
	}
	
	
	@PostMapping("/reserve")
	@ResponseBody
	public ResponseEntity<ReservationDetails> reserveFlight(@RequestBody FlightReservation newReservation) {
		
		CommonLookup clType = cldi.getCommonLookupByName("RESERVATION_TYPE", newReservation.getType());
		CommonLookup clStatus = cldi.getCommonLookupByName("RESERVATION_STATUS", "Reserved");
		
		EndUser user = eudi.getEndUserById(newReservation.getUserID());
		Flight flight = fdi.getFlightById(newReservation.getFlightID());
		
		
		ReservationDetails rd = new ReservationDetails(flight, clStatus, clType);
		
		try {
			if(clType.getRefValue().equals("First Class")) {
				fdi.makeReservation(user, flight, true);
			}
			else {
				fdi.makeReservation(user, flight, false);
			}
				
		} catch (FullFlightException ffe) {
			clStatus.setRefValue("Cancelled");
			rd.setStatus(clStatus);
			return new ResponseEntity<ReservationDetails>(rd, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ReservationDetails>(rd, HttpStatus.OK);
	}
	
	

	/*
	 * Reservation Controller Methods
	 */
	
	@PostMapping("/checkin")
	@ResponseBody
	public ResponseEntity<ReservationDetails> checkIn(@RequestBody FlightID flightID) {
		Reservation reservation = rdi.checkIn(flightID.getId());
		
		ReservationDetails reservationDetails = new ReservationDetails(reservation.getFlight(), reservation.getStatus(), reservation.getType());
		
		return new ResponseEntity<ReservationDetails>(reservationDetails, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/cancel")
	@ResponseBody
	public ResponseEntity<Reservation> cancel(@RequestBody int flightID) {
		Reservation reservation = rdi.cancel(flightID);

		return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
	}
}
