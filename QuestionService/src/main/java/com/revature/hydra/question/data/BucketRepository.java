package com.revature.hydra.question.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Bucket;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Integer> {

}
