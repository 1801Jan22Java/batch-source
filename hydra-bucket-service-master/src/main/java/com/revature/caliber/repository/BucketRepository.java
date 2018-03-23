package com.revature.caliber.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.caliber.model.SimpleBucket;

public interface  BucketRepository extends JpaRepository<SimpleBucket, Integer> {

	/*
	 * find a list of SimpleBucket
	 * @return List of SimpleBucket
	 */
	List<SimpleBucket> findAll();
	
	/*
	 * find a SimpleBucket by bucketId
	 * @param bucketId
	 * @return SimpleBucket
	 */
	SimpleBucket findByBucketId(Integer bucketId);
}
