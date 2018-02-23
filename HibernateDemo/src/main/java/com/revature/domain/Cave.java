package com.revature.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="CAVE")
public class Cave implements Serializable {
	
	public Cave(String name) {
		super();
		this.name = name;
	}
	public Cave(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Cave() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="caveSequence")
	@SequenceGenerator(allocationSize=1,name="caveSequence",sequenceName="SQ_CAVE_PK")
	@Column(name="CAVE_ID")
	private int id;
	@Column(name="CAVE_NAME")
	private String name;
	
	//bidirectional mapping, lazily fetched 
	@OneToMany(mappedBy="cave",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Animal> animals;
	
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

	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + "]";
	}
	public List<Animal> getAnimals() {
		return animals;
	}

}
