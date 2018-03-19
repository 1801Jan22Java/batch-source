package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Location;

@RestController
public class LocationController {

	@GetMapping("/getLocs")
	public List<Location> getLocs() {
		List<Location> locs = new ArrayList<Location>();
		locs.add(new Location("place", "country", 0, 0));
		locs.add(new Location("place2", "country2", 1, 1));
		return locs;
	}
	
}

// cf apps
// cf stop cf-trex
// cf delete cf-trex
// cf push
// cf app cf-trex
// cf scale cf-trex -i 2