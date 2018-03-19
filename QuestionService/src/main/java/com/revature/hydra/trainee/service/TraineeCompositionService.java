package com.revature.hydra.trainee.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Batch;
import com.revature.beans.SimpleBatch;
import com.revature.beans.SimpleTrainee;
import com.revature.beans.Trainee;
import com.revature.beans.TrainingStatus;
import com.revature.hydra.trainee.data.TraineeRepository;
/**
 * TraineeCompositionService
 * Implemented all the methods to achieve composition of complex Trainee.
 *  
 * 
 */
@Service
public class TraineeCompositionService {
	@Autowired
	private TraineeRepository traineeRepository;
	@Autowired
	private TraineeCompositionMessagingService traineeCompositionMessagingService;
	
	/**
	 * 
	 * Saving a simple Trainee bean.
	 * 
	 * @param Trainee - Trainee to save
	 * 
	 */
	public void save(Trainee trainee) {
		SimpleTrainee simpleTrainee = new SimpleTrainee(trainee);
		traineeRepository.save(simpleTrainee);
	}
	
	/**
	 * 
	 * Updating a simple Trainee bean to become a complex Trainee bean?.
	 * 
	 * @param Trainee - Trainee to update
	 * 
	 */
	public void update(Trainee trainee) {
		save(trainee);
	}
	
	/**
	 * 
	 * Deleting a Trainee bean.
	 * 
	 * @param Trainee - Trainee to delete
	 * 
	 */
	public void delete(Trainee trainee) {
		traineeRepository.delete(trainee.getTraineeId());

		traineeCompositionMessagingService.sendSimpleNoteDeleteRequest(trainee.getTraineeId());
		traineeCompositionMessagingService.sendSimpleGradeDeleteRequest(trainee.getTraineeId());
		traineeCompositionMessagingService.sendSimplePanelDeleteRequest(trainee.getTraineeId());
	}
	
	/**
	 * 
	 * Obtain list of SimpleTrainees from traineeRepository.
	 * Then obtain a list of Complex Trainee beans from composition.
	 * 
	 * 
	 * @return List<Trainee> - List of complex Trainees
	 */
	public List<Trainee> findAll() {
		List<SimpleTrainee> basis = traineeRepository.findAll();
		List<Trainee> trainees = composeListOfTrainees(basis);

		return trainees;
	}
	
	/**
	 * Obtain list of SimpleTrainees from traineeRepository that have training status not dropped.
	 * Then obtain a list of Complex Trainee beans from composition.
	 * 
	 * 
	 * @return List<Trainee> - List of complex Trainees
	 */
	public List<Trainee> findAllNotDropped() {
		List<SimpleTrainee> basis = traineeRepository.findAllByTrainingStatusNot(TrainingStatus.Dropped);
		List<Trainee> trainees = composeListOfTrainees(basis);

		return trainees;
	}
	
	/**
	 * Obtain list of SimpleTrainees from traineeRepository that have training status not dropped and part of a particular batch.
	 * Then obtain a list of Complex Trainee beans from composition.
	 * 
	 * @param Integer - batchId
	 * @return List<Trainee> - List of complex Trainees
	 */
	public List<Trainee> findAllByBatch(Integer batchId) {
		List<SimpleTrainee> basis = traineeRepository.findAllByBatchIdAndTrainingStatusNot(batchId,
				TrainingStatus.Dropped);
		List<Trainee> trainees = composeListOfTrainees(basis);

		return trainees;
	}
	
	/**
	 * Obtain list of SimpleTrainees from traineeRepository that have training status dropped and part of a particular batch.
	 * Then obtain a list of Complex Trainee beans from composition.
	 * 
	 * @param Integer - batchId
	 * @return List<Trainee> - List of complex Trainees
	 */
	public List<Trainee> findAllDroppedByBatch(Integer batchId) {
		List<SimpleTrainee> basis = traineeRepository.findAllByBatchIdAndTrainingStatus(batchId,
				TrainingStatus.Dropped);
		List<Trainee> trainees = composeListOfTrainees(basis);

		return trainees;
	}
	
	/**
	 * Obtain list of SimpleTrainees from traineeRepository that have training status not dropped and part of a particular batch.
	 * Then obtain a list of Complex Trainee beans from composition.
	 * 
	 * @param Integer - trainerId
	 * @return List<Trainee> - List of complex Trainees
	 */
	public List<Trainee> findAllByTrainer(Integer trainerId) {
		List<SimpleBatch> trainerBatches = traineeCompositionMessagingService.sendListSimpleBatchRequest(trainerId);
		List<SimpleTrainee> basis = new LinkedList<SimpleTrainee>();// traineeRepository.findAllByBatchIdAndTrainingStatusNot(trainerId,
														// TrainingStatus.Dropped);
		System.out.println(basis);
		List<Trainee> trainees = null;

		for (SimpleBatch b : trainerBatches) {
			List<SimpleTrainee> batchTrainees = traineeRepository.findAllByBatchIdAndTrainingStatusNot(b.getBatchId(),
					TrainingStatus.Dropped);
			basis.addAll(batchTrainees);
		}

		trainees = composeListOfTrainees(basis);

		return trainees;
	}
	/**
	 * sphuang 02/08/2018 
	 * Obtain a SimpleTrainee from traineeRepository that have it's training status not dropped and matches the traineeId.
	 * Then obtain a Complex Trainee from composition.
	 * 
	 * @param Integer - traineeId
	 * @return List<Trainee> - List of complex Trainees
	 */
	public Trainee findOne(Integer traineeId) {
		SimpleTrainee basis = traineeRepository.findOneByTraineeIdAndTrainingStatusNot(traineeId,
				TrainingStatus.Dropped);
		Trainee result = composeTrainee(basis);

		return result;
	}
	
	/**
	 * Obtain a List of SimpleTrainees from traineeRepository that have it's training status not dropped and matches the email.
	 * Then obtain a List of Complex Trainee from composition.
	 * 
	 * @param String - email
	 * @return List<Trainee> - List of complex Trainees
	 */
	public List<Trainee> findByEmail(String email) {
		List<SimpleTrainee> basis = traineeRepository.findAllByEmailLikeAndTrainingStatusNot(email,
				TrainingStatus.Dropped);
		List<Trainee> trainees = composeListOfTrainees(basis);

		return trainees;
	}
	/**
	 * Obtain a List of SimpleTrainees from traineeRepository that have it's training status not dropped and matches the name.
	 * Then obtain a List of Complex Trainees from composition.
	 * 
	 * @param String - name
	 * @return List<Trainee> - List of complex Trainees
	 */
	public List<Trainee> findByName(String name) {
		List<SimpleTrainee> basis = traineeRepository.findAllByNameLikeAndTrainingStatusNot(name,
				TrainingStatus.Dropped);
		List<Trainee> trainees = composeListOfTrainees(basis);

		return trainees;
	}
	
	/**
	 * Obtain a List of SimpleTrainees from traineeRepository that have it's training status not dropped and matches the skypeId.
	 * Then obtain a List of Complex Trainees from composition.
	 * 
	 * @param String - skypeId
	 * @return List<Trainee> - List of complex Trainees
	 */
	public List<Trainee> findBySkypeId(String skypeId) {
		List<SimpleTrainee> basis = traineeRepository.findAllBySkypeIdLikeAndTrainingStatusNot(skypeId,
				TrainingStatus.Dropped);
		List<Trainee> trainees = composeListOfTrainees(basis);

		return trainees;
	}
	
	/**
	 * Composing a list of Complex Trainees.
	 * 
	 * 
	 * @param List<SimpleTrainee> - List of SimpleTrainees
	 * @return List<Trainee> - List of complex Trainees
	 */
	private List<Trainee> composeListOfTrainees(List<SimpleTrainee> simpleTrainees) {
		List<Trainee> trainees = new LinkedList<Trainee>();

		for (SimpleTrainee simpleTrainee : simpleTrainees) {
			Trainee trainee = composeTrainee(simpleTrainee);
			trainees.add(trainee);
		}

		return trainees;
	}
	
	/**
	 * Composing a complex Trainee from a simpleTrainee. Obtains a batch to build the complex Trainee.
	 * 
	 * 
	 * @param SimpleTrainee - simpleTrainee
	 * @return trainee - complex Trainee
	 */
	private Trainee composeTrainee(SimpleTrainee simpleTrainee) {
		Trainee trainee = new Trainee(simpleTrainee);

		SimpleBatch simpleBatch = traineeCompositionMessagingService
				.sendSingleSimpleBatchRequest(simpleTrainee.getBatchId());
		Batch batch = new Batch(simpleBatch);
		trainee.setBatch(batch);

		return trainee;
	}
}