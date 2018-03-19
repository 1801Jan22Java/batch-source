package com.revature.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SkillType implements Serializable{
	@JsonProperty("J2EE")
	J2EE("J2EE"),
	@JsonProperty(".NET")
	NET(".NET"),
	@JsonProperty("SDET")
	SDET("SDET"),
	@JsonProperty("BPM")
	BPM("BPM"),
	@JsonProperty("Other")
	OTHER("Other");
	
	private String type;

	private SkillType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return type;
	}

}
