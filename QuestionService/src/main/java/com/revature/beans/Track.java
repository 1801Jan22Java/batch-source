package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="TRACK")
public class Track {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TRACK_SEQUENCE")
	@SequenceGenerator(name="TRACK_SEQUENCE",sequenceName="TRACK_SEQUENCE")
	@Column(name="TRACK_ID")
	private Integer trackId;
	
	@Column(name="TRACK_NAME")
	private String trackName;
	
	@Column(name="IS_ACTIVE")
	private Boolean isActive;

	public Track(Integer trackId, String trackName, Boolean isActive) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
		this.isActive = isActive;
	}

	public Integer getTrackId() {
		return trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
