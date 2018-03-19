package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="TRACK_BUCKET")
public class TrackBucket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="trackBucketSequence")
	@SequenceGenerator(allocationSize=1,name="trackBucketSequence",sequenceName="TRACK_BUCKET_S1")
	@Column(name="TRACK_BUCKET_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TRACK_ID")
	private Track track;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BUCKET_ID")
	private Bucket bucket;
	
	@Column(name="WEIGHT")
	Double weight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Bucket getBucket() {
		return bucket;
	}

	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
}
