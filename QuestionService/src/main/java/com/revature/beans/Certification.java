package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Certification
 */

@Entity
@Table(name = "HYDRA_CERTIFICATION")
public class Certification implements Serializable{
	private static final long serialVersionUID = -6414050602514475604L;

	@Id
	@Column(name="CERT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CERT_ID_SEQUENCE")
	@SequenceGenerator(name = "CERT_ID_SEQUENCE", sequenceName = "CERT_ID_SEQUENCE")
	@JsonProperty
	private int certId;
	
	@NotEmpty
	@Column(name = "URL", nullable = false)
	@JsonProperty
	private String url;
	
	@NotEmpty
	@Column(name = "Name", nullable = false)
	@JsonProperty
	private String name;
	
	public Certification() {
		super();
	}

	public Certification(String url, String name, Integer trainer) {
		super();
		this.url = url;
		this.name = name;
	}
	
	// AssignForce has this pair of setter and getter as getFile
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Certification [File=" + url + ", name=" + name + "]";
	}
}
