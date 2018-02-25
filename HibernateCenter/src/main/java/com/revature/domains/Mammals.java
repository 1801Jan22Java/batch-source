package com.revature.domains;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="MAMMALS")
public class Mammals extends Animals implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mammalsSequence")
	@SequenceGenerator(allocationSize=1,name="mammalsSequence",sequenceName="SQ_MAMMAL_PK")
    @Column(name = "MAMMAL_ID")
	private int mID; //pk
	@OneToOne
	@JoinColumn(name="animalID")
	private Animals animal; //fk to aID from table Animals
	@OneToOne
	@JoinColumn(name="lookupID")
	private LookupTable animalType; //fk to lookupID for lookup table
	@OneToOne
	@JoinColumn(name="lookupID")
	private LookupTable breed; //fk to lookupID for lookup table
	@OneToOne
	@JoinColumn(name="lookupID")
	private LookupTable hairlength; //fk to lookupID for lookup table
	
	public Mammals(int mID, Animals animal, LookupTable animalType, LookupTable breed, LookupTable hairlength) {
		super();
		this.mID = mID;
		this.animal = animal;
		this.animalType = animalType;
		this.breed = breed;
		this.hairlength = hairlength;
	}
	
	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}

	public Animals getAnimal() {
		return animal;
	}

	public void setAnimal(Animals animal) {
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

	@Override
	public String toString() {
		return "Mammals [mID=" + mID + ", animal=" + animal + ", animalType=" + animalType + ", breed=" + breed
				+ ", hairlength=" + hairlength + "]";
	}
}
