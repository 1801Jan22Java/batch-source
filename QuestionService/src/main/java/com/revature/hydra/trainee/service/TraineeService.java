package com.revature.hydra.trainee.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Trainee;

/**
 * Provides logic concerning trainer and trainee data. Application logic has no
 * business being in a DAO nor in a Controller. This is the ideal place for
 * calculations
 *
 * @author Patrick Walsh
 *
 */
@Service
public class TraineeService {

	private static final Logger log = Logger.getLogger(TraineeService.class);
	
	@Autowired
	private TraineeCompositionService traineeDAO;

	/*
	 *******************************************************
	 * TRAINEE SERVICES
	 *
	 *******************************************************
	 */
	/**
	 * SAVE TRAINEE
	 *
	 * @param trainee
	 */
	public void save(Trainee trainee) {
		log.debug("Save trainee: " + trainee);
		traineeDAO.save(trainee);
		
	}

	/**
	 * FIND ALL TRAINEES
	 *
	 * @return
	 */
	public List<Trainee> findAllTrainees() {
		log.debug("Find all trainees");
		return traineeDAO.findAll();
	}

	/**
	 * FIND ALL TRAINEES BY BATCH ID
	 *
	 * @param batchId
	 * @return
	 */
	public List<Trainee> findAllTraineesByBatch(Integer batchId) {
		log.debug("Find trainees by batch");
		return traineeDAO.findAllByBatch(batchId);
	}

	/**
	 * FIND ALL DROPPED TRAINEES BY BATCH ID
	 *
	 * @param batchId
	 * @return
	 */
	public List<Trainee> findAllDroppedTraineesByBatch(Integer batchId) {
		log.debug("Find dropped trainees by batch");
		return traineeDAO.findAllDroppedByBatch(batchId);
	}

	/**
	 * FIND ALL TRAINEES BY TRAINER ID
	 *
	 * @param trainerId
	 * @return
	 */
	public List<Trainee> findAllTraineesByTrainer(int trainerId) {
		log.debug("Find trainees by trainer id: " + trainerId);
		return traineeDAO.findAllByTrainer(trainerId);
	}

	/**
	 * FIND TRAINEE BY ID
	 *
	 * @param traineeId
	 * @return
	 */
	public Trainee findTrainee(Integer traineeId) {
		log.debug("Find trainee by id: " + traineeId);
		return traineeDAO.findOne(traineeId);
	}

	/**
	 * FIND TRAINEE BY EMAIL ADDRESS
	 *
	 * @param email
	 * @return
	 */
	public Set<Trainee> search(String searchTerm) {
		log.debug("Find trainee : " + searchTerm);
		Set<Trainee> result = new HashSet<>();
		List<Trainee> traineeByEmail = traineeDAO.findByEmail(searchTerm);
		result.addAll(traineeByEmail);
		List<Trainee> traineeByName = traineeDAO.findByName(searchTerm);
		result.addAll(traineeByName);
		List<Trainee> traineeBySkypeId = traineeDAO.findBySkypeId(searchTerm);
		result.addAll(traineeBySkypeId);
		return result;
	}
	

	/**
	 * DELETE TRAINEE
	 *
	 * @param trainee
	 */
	public void delete(Trainee trainee) {
		log.debug("Delete trainee " + trainee);
		traineeDAO.delete(trainee);
	}

	/**
	 * UPDATE TRAINEE
	 *
	 * @param trainee
	 */
	public void update(Trainee trainee) {
		log.debug("Update trainee " + trainee);
		traineeDAO.update(trainee);
	}

}
