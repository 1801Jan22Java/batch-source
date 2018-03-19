package com.revature.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TrainingType implements Serializable {
	@JsonProperty("Revature")
	Revature,
	@JsonProperty("Corporate")
	Corporate,
	@JsonProperty("University")
	University,
	@JsonProperty("Other")
	Other
}
