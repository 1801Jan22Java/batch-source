package com.revature.hydra.trainee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.beans.SimpleTrainee;
import com.revature.beans.Trainee;
import com.revature.hydra.trainee.data.TraineeRepository;
/**
 * TraineeRepositoryRequestDispatcher
 * Changes JsonObject requests into strings. Depending on the message, different TraineeRepository methods are called to return
 * back a SimpleTrainee, List of SimpleTrainee, or List of ComplexTrainee.
 *
 * 
 * 
 */
@Service
public class TraineeRepositoryRequestDispatcher {
	@Autowired
	private TraineeRepository traineeRepository;
	
	@Autowired
	private TraineeCompositionService traineeCompositionService;
	
	/**
	 * 
	 * Process Single Simple Trainee Request
	 * Depending on methodName, can return either a trainee that matches a traineeId,
	 * or delete a trainee, or persists a SimpleTrainee to database.
	 * 
	 * 
	 * @param JsonObject - request
	 * @return SimpleTrainee
	 */
	public SimpleTrainee processSingleSimpleTraineeRequest(JsonObject request) {
		SimpleTrainee result = null;
		String methodName = request.get("methodName").getAsString();
		Gson gson = new Gson();
		
		if(methodName.equals("findOne")) {
			Integer traineeId = request.get("traineeId").getAsInt();
			result = traineeRepository.findOne(traineeId);
		} else if(methodName.equals("delete")) {
			traineeRepository.delete(request.get("traineeId").getAsInt());
		} else if(methodName.equals("save")) {
			SimpleTrainee trainee = gson.fromJson(request.get("trainee").getAsString(), SimpleTrainee.class);
			result = traineeRepository.save(trainee);
		} else if(methodName.equals("findOneByResourceId")) {
			result = traineeRepository.findOneByResourceId(request.get("resourceId").getAsString());
		}
		
		return result;
	}
	
	/**
	 * sphuang 02/08/2018 
	 * Process List Simple Trainee Request
	 * Depending on methodName, can return either a list of all trainees, or a list of trainees that all 
	 * are part of the same batch, or delete all trainees that have the same batchId.
	 * 
	 * 
	 * @param JsonObject - request
	 * @return List of SimpleTrainee 
	 */
	public List<SimpleTrainee> processListSimpleTraineeRequest(JsonObject request) {
		System.out.println("Hey hello");
		List<SimpleTrainee> result = null;
		String methodName = request.get("methodName").getAsString();
		
		if(methodName.equals("findAll")) {
			System.out.println("find all");
			result = traineeRepository.findAll();
		} else if(methodName.equals("findAllByBatchId")){
			System.out.println("find batch");
			result = traineeRepository.findAllByBatchId(request.get("batchId").getAsInt());
		} else if(methodName.equals("delete")) {
			System.out.println("delete");
			result = traineeRepository.findAllByBatchId(request.get("batchId").getAsInt());
			for(SimpleTrainee t : result) {
				System.out.println(t);
				traineeRepository.delete(t.getTraineeId());
			}
			result = null;
		}
		
		System.out.println("return");
		
		return result;
	}
	
	/**
	 * sphuang 02/08/2018 
	 * Process List Trainee Request
	 * Returns a List of complex Trainees of the same batch Id.
	 * 
	 * 
	 * @param JsonObject - request
	 * @return List of Trainees 
	 */
	public List<Trainee> processListTraineeRequest(JsonObject request) {
		List<Trainee> result = null;
		String methodName = request.get("methodName").getAsString();
		
		if(methodName.equals("findAllByBatch")) {
			result = traineeCompositionService.findAllByBatch(request.get("batchId").getAsInt());
		}
		
		return result;
	}
}
