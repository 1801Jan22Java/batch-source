package com.revature.hydra.trainee.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.SimpleTrainee;
import com.revature.beans.TrainingStatus;
/**
 * TraineeRepository
 * Data Access Object with various methods to search database.
 * 
 * @author Samuel Huang
 */
@Repository
public interface TraineeRepository extends JpaRepository<SimpleTrainee, Integer> {

	SimpleTrainee findOneByResourceId(String resourceId);
	
	/**
	 * Find a Trainee by traineeId and without this status
	 *
	 * @param traineeId, status
	 *
	 * @return SimpleTrainee
	 */
  
	SimpleTrainee findOneByTraineeIdAndTrainingStatusNot(Integer traineeId, TrainingStatus status);
	
	/**
	 * find a list of SimpleTrainee by email and without this status
	 *
	 * @param email, status
	 *
	 * @return List of SimpleTrainee
	 */
	List<SimpleTrainee> findAllByEmailLikeAndTrainingStatusNot(String email, TrainingStatus status);

	/**
	 * find a list of SimpleTrainee by name and without this status
	 *
	 * @param name, status
	 *
	 * @return List of SimpleTrainee
	 */
	List<SimpleTrainee> findAllByNameLikeAndTrainingStatusNot(String name, TrainingStatus status);

	/**
	 * find a list of SimpleTrainee by skypeId and without this status
	 *
	 * @param skypeId, status
	 *
	 * @return List of SimpleTrainee
	 */
	List<SimpleTrainee> findAllBySkypeIdLikeAndTrainingStatusNot(String skypeId, TrainingStatus status);

	/**
	 * find a list of SimpleTrainee by batchId and without this status
	 *
	 * @param batchId, status
	 *
	 * @return List of SimpleTrainee
	 */
	List<SimpleTrainee> findAllByBatchIdAndTrainingStatusNot(Integer batchId, TrainingStatus status);
	
	/**
	 * find a list of SimpleTrainee by batchId and status
	 *
	 * @param batchId, status
	 *
	 * @return List of SimpleTrainee
	 */
	List<SimpleTrainee> findAllByBatchIdAndTrainingStatus(Integer batchId, TrainingStatus status);
	
	/**
	 * find a list of SimpleTrainee without this status
	 *
	 * @param status
	 *
	 * @return List of SimpleTrainee
	 */
	List<SimpleTrainee> findAllByTrainingStatusNot(TrainingStatus status);
	
	/**
	 * find a list of SimpleTrainee with this batchId
	 *
	 * @param batchId
	 *
	 * @return List of SimpleTrainee
	 */
	List<SimpleTrainee> findAllByBatchId(Integer batchId);
	
}
