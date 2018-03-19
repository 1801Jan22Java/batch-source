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
@Table(name="TRACK_BUCKET_LOOKUP")
public class TrackBucketLookup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TRACK_BUCKET_LOOKUP_SEQUENCE")
	@SequenceGenerator(allocationSize=1,name="TRACK_BUCKET_LOOKUP_SEQUENCE",sequenceName="TRACK_BUCKET_LOOKUP_SEQUENCE")
	@Column(name="TRACK_BUCKET_LOOKUP_ID")
	private Integer trackBucketLookupId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TRACK_ID")
	private Track track;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BUCKET_ID")
	private Bucket bucket;
	
	@Column(name="WEIGHT")
	private Double weight;

	public TrackBucketLookup(int trackBucketLookupId, Track track, Bucket bucket, Double weight) {
		super();
		this.trackBucketLookupId = trackBucketLookupId;
		this.track = track;
		this.bucket = bucket;
		this.weight = weight;
	}

	public int getTrackBucketLookupId() {
		return trackBucketLookupId;
	}

	public void setTrackBucketLookupId(int trackBucketLookupId) {
		this.trackBucketLookupId = trackBucketLookupId;
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
