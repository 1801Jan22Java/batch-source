package com.revature.hydra.trainee.service;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.revature.beans.SimpleBatch;
/**
 * TraineeCompositionMessagingService
 * Sends messages to Batch's queue to obtain a Batch or list of Batches to build the complex TraineeBean and list of Trainee respectively.
 * Message can be a delete request.
 * 
 * @author Samuel Huang
 */
@Service
public class TraineeCompositionMessagingService {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	private static final String LIST_NOTE_ROUTING_KEY = "cf22J9CGs8V95Rbm";
	private static final String SINGLE_BATCH_ROUTING_KEY = "XLNbCWqQzFHr9JfZ";
	private static final String LIST_BATCH_ROUTING_KEY = "BSVihZkuxwdg9Dxy";
	private static final String LIST_GRADE_ROUTING_KEY = "V6hbpnyZRH8ZQQ9e";
	private static final String LIST_PANEL_ROUTING_KEY = "8AzDbkAUCZn9Z2T3";
	
	/**
	 * Team Data RABBITMQ Exchange Name
	 */
	private static final String RABBIT_REPO_EXCHANGE = "revature.hydra.repos";
	
	/**
	 * sphuang 02/07/2018 
	 * Sending a message string in json notation to Batch's queue containing method name findOne and a specific batch ID.
	 * In return, BatchRepositoryMessagingService will return back a SimpleBatch object that is in that particular batch.
	 * 
	 * @param Integer - Trainee's Batch Id
	 * @return A SimpleBatch object
	*/
	public SimpleBatch sendSingleSimpleBatchRequest(Integer batchId) {
		JsonObject batchRequest = new JsonObject();

		batchRequest.addProperty("methodName", "findOne");
		batchRequest.addProperty("batchId", batchId);

		return (SimpleBatch) rabbitTemplate.convertSendAndReceive(RABBIT_REPO_EXCHANGE, SINGLE_BATCH_ROUTING_KEY,
				batchRequest.toString());
	}

	/**
	 * sphuang 02/07/2018 
	 * Sending a message string in json notation to Batch's queue containing method name findAllByTrainerId and a specific trainer ID.
	 * In return, BatchRepositoryMessagingService will return back a list of SimpleBatch objects that have the same Trainer ID.
	 * 
	 * @param Integer - Trainee's Trainer Id
	 * @return A List of SimpleBatch object
	*/
	public List<SimpleBatch> sendListSimpleBatchRequest(Integer trainerId) {
		JsonObject batchRequest = new JsonObject();
		batchRequest.addProperty("methodName", "findAllByTrainerId");
		batchRequest.addProperty("trainerId", trainerId);

		return (List<SimpleBatch>) rabbitTemplate.convertSendAndReceive(RABBIT_REPO_EXCHANGE, LIST_BATCH_ROUTING_KEY,
				batchRequest.toString());
	}

	/**
	 * sphuang 02/07/2018 
	 * Sending a message string in json notation to Note's queue containing method name delete and a specific trainee ID.
	 * NoteRepositoryMessagingService will delete all notes with that trainee ID.
	 * 
	 * @param Integer - Trainee's Trainee Id
	 */
	public void sendSimpleNoteDeleteRequest(Integer traineeId) {
		JsonObject NoteDeleteRequest = new JsonObject();
		NoteDeleteRequest.addProperty("methodName", "delete");
		NoteDeleteRequest.addProperty("traineeId", traineeId);
		rabbitTemplate.convertSendAndReceive(RABBIT_REPO_EXCHANGE, LIST_NOTE_ROUTING_KEY, NoteDeleteRequest.toString());
	}
	
	/**
	 * sphuang 02/07/2018 
	 * Sending a message string in json notation to Grade's queue containing method name delete and a specific trainee ID.
	 * GradeRepositoryMessagingService will delete all grades with that trainee ID.
	 * 
	 * @param Integer - Trainee's Trainee Id
	 * Create message for Grade to delete Grades associated with a trainee
	 *
	 * @param batchId
	 *
	 * @return 
	 */
	public void sendSimpleGradeDeleteRequest(Integer traineeId) {
		JsonObject GradeDeleteRequest = new JsonObject();
		GradeDeleteRequest.addProperty("methodName", "delete");
		GradeDeleteRequest.addProperty("traineeId", traineeId);
		rabbitTemplate.convertSendAndReceive(RABBIT_REPO_EXCHANGE, LIST_GRADE_ROUTING_KEY, GradeDeleteRequest.toString());
	}
	
	/**
	 * Sending a message string in json notation to Panel's queue containing method name delete and a specific trainee ID.
	 * PanelRepositoryMessagingService will delete all grades with that trainee ID.
	 * 
	 * @param Integer - Trainee's Trainee Id
	 * 
	 * Create message for Panel to delete Panels associated with a trainee
	 *
	 * @param batchId
	 *
	 * @return 
	 */
	public void sendSimplePanelDeleteRequest(Integer traineeId) {
		JsonObject PanelDeleteRequest = new JsonObject();
		PanelDeleteRequest.addProperty("methodName", "delete");
		PanelDeleteRequest.addProperty("traineeId", traineeId);
		rabbitTemplate.convertSendAndReceive(RABBIT_REPO_EXCHANGE, LIST_PANEL_ROUTING_KEY, PanelDeleteRequest.toString());
	}
}
