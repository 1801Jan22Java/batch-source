package com.revature.caliber.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.revature.caliber.model.Bucket;
import com.revature.caliber.model.SimpleBucket;

@Service
public class BucketService {

	private static final Logger log = Logger.getLogger(BucketService.class);
	
	@Autowired
	private BucketCompositionService bucketDAO;
	
	/*
	 *******************************************************
	 * BUCKET SERVICES
	 *******************************************************
	 */
	
	
	public void save(Bucket bucket) {
		log.debug("save Bucket");
		bucketDAO.save(bucket);
	}
	
	public List<SimpleBucket> findAllBuckets(){
		log.debug("Find all Buckets");
		List<SimpleBucket> buckets  = bucketDAO.findAll();
		return buckets;
	}
	
	public SimpleBucket findBucketByBucketId(Integer bucketId) {
		log.debug("Find Bucket By BucketId");
		return bucketDAO.findByBucketId(bucketId);
	}
	
}
