package com.revature.caliber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.revature.caliber.model.Bucket;
import com.revature.caliber.model.SimpleBucket;
import com.revature.caliber.repository.BucketRepository;

@Service
public class BucketCompositionService {

	@Autowired
	private BucketRepository bucketRepository;
	
	/*
	 * Saving a simple Bucket beean.
	 */
	public void save (Bucket bucket) {
		//SimpleBucket simpleBucket = new SimpleBucket(bucket);
		//bucketRepository.save(simpleBucket);
	}
	
	public List<SimpleBucket> findAll (){
		List<SimpleBucket> buckets = bucketRepository.findAll();
		return buckets;
	}
	
	public SimpleBucket findByBucketId(Integer bucketId) {
		SimpleBucket bucket = bucketRepository.findByBucketId(bucketId);
		return bucket;
	}
	
}
