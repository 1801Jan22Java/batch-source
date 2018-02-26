package com.revature.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TANK_ANIMALS")
@PrimaryKeyJoinColumn(name="TANK_ANI_ID")
public class TankAnimal extends Animal implements Serializable{

	/*
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tankAnimalSequence")
	@SequenceGenerator(allocationSize=1,name="tankAnimalSequence",sequenceName="SQ_Tank_Animals_PK")
    @Column(name = "TANK_ANI_ID")
	private int tankAnimalID; //pk
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
	
	public TankAnimal(List<LookupTable> lookup) {
		super();
		this.lookup = lookup;
	}

	public TankAnimal() {}

	
	/*
	public int getTankAnimalID() {
		return tankAnimalID;
	}

	public void setTankAnimalID(int tankAnimalID) {
		this.tankAnimalID = tankAnimalID;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public LookupTable getSpecies() {
		return species;
	}

	public void setSpecies(LookupTable species) {
		this.species = species;
	}

	public LookupTable getWatertype() {
		return watertype;
	}

	public void setWatertype(LookupTable watertype) {
		this.watertype = watertype;
	}

	/*
	@Override
	public String toString() {
		return "TankAnimals [tankAnimalID=" + tankAnimalID + ", animal=" + animal + ", species=" + species + ", watertype=" + watertype
				+ "]";
	}
	*/
}
