package com.revature.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Designates if the associate passed/failed the panel
 * or passed/failed a particular topic.
 * @author Patrick Walsh
 *
 */
public enum PanelStatus implements Serializable{
		@JsonProperty("Pass")
		Pass,
		@JsonProperty("Repanel")
		Repanel
}
