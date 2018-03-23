package com.revature.caliber.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import com.revature.caliber.model.Bucket;
import com.revature.caliber.model.SimpleBucket;
import com.revature.caliber.service.BucketService;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

@RestController
@CrossOrigin("*")
public class BucketController {

	private static final Logger log = Logger.getLogger(BucketController.class);
	private BucketService bucketService;
	
	@Autowired 
	public void setBucketService(BucketService bucketService) {
		this.bucketService = bucketService;
	}
	
	@RequestMapping(value="/getBuckets", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SimpleBucket>> getAllBuckets(){
		List<SimpleBucket> buckets = bucketService.findAllBuckets();
		return new ResponseEntity<>(buckets, HttpStatus.OK);
	}
	
	@RequestMapping(value="/createBucket", method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bucket> createNewBucket(@Valid @RequestBody Bucket bucket){
		log.info("Saving bucket:" + bucket);
		bucketService.save(bucket);
		
		return new ResponseEntity<>(bucket, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/bucket/{id}", method=RequestMethod.GET)
	public ResponseEntity<SimpleBucket> getBucketByBucketId(@PathVariable int id){
		SimpleBucket bucket = bucketService.findBucketByBucketId(id);
		return new ResponseEntity<>(bucket, HttpStatus.CREATED);
	}
	
	
	
}
