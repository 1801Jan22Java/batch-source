package com.revature.hydra.trainee.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Trainee;
import com.revature.hydra.trainee.service.TraineeService;

/**
 * Services requests for Trainer, Trainee, and Batch information
 *
 * @author Patrick Walsh
 *
 */
@RestController
//@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class TraineeController {

	private static final Logger log = Logger.getLogger(TraineeController.class);
	private TraineeService traineeService;

	@Autowired
	public void setTrainingService(TraineeService traineeService) {
		this.traineeService = traineeService;
	}

	/*
	 *******************************************************
	 * TRAINEE SERVICES
	 *
	 *******************************************************
	 */
	@RequestMapping(value = "/all/trainee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) //possibly not used 2/8/18, 10:53am edt
	//@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	//@PreAuthorize("hasAnyRole('VP', 'QC', 'TRAINER', 'STAGING', 'PANEL')")
	public ResponseEntity<List<Trainee>> findAllByBatch(@RequestParam(required = true) Integer batch) {
		log.info("Finding trainees for batch: " + batch);
		List<Trainee> trainees = traineeService.findAllTraineesByBatch(batch);
		return new ResponseEntity<>(trainees, HttpStatus.OK);
	}

	@RequestMapping(value = "/all/trainee/dropped", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	//@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	//@PreAuthorize("hasAnyRole('VP', 'QC', 'TRAINER', 'STAGING', 'PANEL')")
	public ResponseEntity<List<Trainee>> findAllDroppedByBatch(@RequestParam(required = true) Integer batch) {
		log.info("Finding dropped trainees for batch: " + batch);
		List<Trainee> trainees = traineeService.findAllDroppedTraineesByBatch(batch);
		return new ResponseEntity<>(trainees, HttpStatus.OK);
	}

	/**
	 * Create trainee
	 *
	 * @param trainee
	 *            the trainee
	 * @return the response entity
	 */
	@RequestMapping(value = "/all/trainee/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	//@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	//@PreAuthorize("hasAnyRole('VP', 'QC', 'TRAINER', 'PANEL')")
	public ResponseEntity<Trainee> createTrainee(@Valid @RequestBody Trainee trainee) {
		log.info("Saving trainee: " + trainee);
		traineeService.save(trainee);
		return new ResponseEntity<>(trainee, HttpStatus.CREATED);
	}

	/**
	 * Update trainee
	 *
	 * @param trainee
	 *            the trainee
	 * @return the response entity
	 */
	@RequestMapping(value = "/all/trainee/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	//@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	//@PreAuthorize("hasAnyRole('VP', 'QC', 'TRAINER','PANEL')")
	public ResponseEntity<Void> updateTrainee(@Valid @RequestBody Trainee trainee) {
		log.info("Updating trainee: " + trainee);
		traineeService.update(trainee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Delete trainee
	 *
	 * @param id
	 *            the id
	 * @return the response entity
	 */
	@RequestMapping(value = "/all/trainee/delete/{id}", method = RequestMethod.DELETE)
	//@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	//@PreAuthorize("hasAnyRole('VP', 'QC', 'TRAINER','PANEL')")
	public ResponseEntity<Void> deleteTrainee(@PathVariable int id) {
		Trainee trainee = new Trainee();
		trainee.setTraineeId(id);
		log.info("Deleting trainee: " + id);
		traineeService.delete(trainee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@RequestMapping(value = "/all/trainee/search/{searchTerm}", method = RequestMethod.GET)
	//@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	//@PreAuthorize("hasAnyRole('VP', 'QC', 'TRAINER','PANEL')")
	public ResponseEntity<Set<Trainee>> searchTrainee(@PathVariable String searchTerm) {
		Set<Trainee> trainee = traineeService.search(searchTerm);
		if(trainee.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(trainee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all/trainee/getByEmail/{traineeEmail}", method = RequestMethod.GET)
	//@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	//@PreAuthorize("hasAnyRole('VP', 'QC', 'TRAINER', 'PANEL')")
	public ResponseEntity<Trainee> retreiveTraineeByEmail(@PathVariable String traineeEmail) {
		/* 
		 1. at some point, we will have unique constraint on trainee email.
		 	this method will check the database before adding the new trainee
		 2. before we can enable this functionality, we need to allow
		 	trainees to be assigned to more than one batch, or added with a batch at all
		 	(for tech screening feedback functionality)
		 */
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	/**
	 * Convenience method for accessing the Trainer information from the User
	 * Principal.
	 *
	 * @param auth
	 * @return
	 */
/*	private Trainer getPrincipal(Authentication auth) {
		return ((SalesforceUser) auth.getPrincipal()).getCaliberUser();
	}*/
}