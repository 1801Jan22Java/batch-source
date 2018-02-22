package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="CAT")
public class Cat implements Serializable {
	
	
	public Cat() {
		super();
	}
	public Cat(String name, String species, Shelter shelter) {
		super();
		this.name = name;
		this.species = species;
		this.shelter = shelter;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="catSequence")
	@SequenceGenerator(allocationSize=1,name="catSequence", sequenceName="SQ_CAT_PK" )
	@Column(name="CAT_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="SPECIES")
	private String species;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CATLOVER_ID")
	private CatLover catLover;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="SHELTER_ID")
	private Shelter shelter;

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
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public CatLover getCatLover() {
		return catLover;
	}
	public void setCatLover(CatLover catLover) {
		this.catLover = catLover;
	}
	public Shelter getShelter() {
		return shelter;
	}
	public void setShelter(Shelter shelter) {
		this.shelter = shelter;
	}
	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", species=" + species + ", catLover=" + catLover + ", shelter="
				+ shelter + "]";
	}
	
	
	
	
	
}
