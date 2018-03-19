package com.revature.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Determines if notes are created by Trainer or QC 
 * and where they are applied (to the trainee or batch).
 * Public notes are made by QC that are not visible to trainers and below.
 * 
 * @author Patrick Walsh
 *
 */
public enum NoteType implements Serializable{
	@JsonProperty("TRAINEE")
	TRAINEE,
	@JsonProperty("BATCH")
	BATCH,
	@JsonProperty("QC_TRAINEE")
	QC_TRAINEE,
	@JsonProperty("QC_BATCH")
	QC_BATCH
}
