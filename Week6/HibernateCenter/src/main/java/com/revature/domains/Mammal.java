package com.revature.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="MAMMALS")
@PrimaryKeyJoinColumn(name="MAMMAL_ID")
public class Mammal extends Animal implements Serializable{
	
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mammalsSequence")
	@SequenceGenerator(allocationSize=1,name="mammalsSequence",sequenceName="SQ_MAMMAL_PK")
    @Column(name = "MAMMAL_ID")
	private int mID; //pk
	
	//@OneToOne
	//@JoinColumn(name="animalID")
	//private Animal animal; //fk to aID from table Animals
	@OneToOne
	@JoinColumn(name="lookupID")
	private LookupTable animalType; //fk to lookupID for lookup table
	@OneToOne
	@JoinColumn(name="lookupID")
	private LookupTable breed; //fk to lookupID for lookup table
	@OneToOne
	@JoinColumn(name="lookupID")
	private LookupTable hairlength; //fk to lookupID for lookup table
	*/
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lookupID")
	private List<LookupTable> lookup; //fk to lookupID for lookup table
	
	
	
	public List<LookupTable> getLookup() {
		return lookup;
	}

	public void setLookup(List<LookupTable> lookup) {
		this.lookup = lookup;
	}

	
	/*
	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}
*/
	/*
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public LookupTable getAnimalType() {
		return animalType;
	}

	public void setAnimalType(LookupTable animalType) {
		this.animalType = animalType;
	}

	public LookupTable getBreed() {
		return breed;
	}

	public void setBreed(LookupTable breed) {
		this.breed = breed;
	}

	public LookupTable getHairlength() {
		return hairlength;
	}

	public void setHairlength(LookupTable hairlength) {
		this.hairlength = hairlength;
	}

	/*
	@Override
	public String toString() {
		return "Mammals [mID=" + mID + ", animalType=" + animalType + ", breed=" + breed
				+ ", hairlength=" + hairlength + "]";
	}
	*/
}
