package com.revature.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity 
@Table(name="STATE")
public class State implements Serializable {

	public State(String name) {
		super();
		this.name = name;
	}

	public State() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="stateSequence")
	@SequenceGenerator(allocationSize=1,name="stateSequence",sequenceName="STATE_S1")
	@Column(name="STATE_ID")
	private int id;
	
	@Column(name="STATE_NAME", unique = true)
	private String name;
	
	@OneToMany(mappedBy="state",fetch=FetchType.EAGER)
	private List<City> cities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", cities=" + cities + "]";
	}
}
