package com.revature.domains;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="TANK_ANIMALS")
public class TankAnimals extends Animals implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tankAnimalSequence")
	@SequenceGenerator(allocationSize=1,name="tankAnimalSequence",sequenceName="SQ_Tank_Animals_PK")
    @Column(name = "TANK_ANI_ID")
	private int tankAnimalID; //pk
	@OneToOne
	@JoinColumn(name="animalID")
	private Animals animal; //fk to aID from table Animals
	@OneToOne
	@JoinColumn(name="lookupID")
	private LookupTable species; //fk to lookupID for lookup table
	@OneToOne
	@JoinColumn(name="lookupID")
	private LookupTable watertype; //fk to lookupID for lookup table
	
	public TankAnimals(int tankAnimalID, Animals animal, LookupTable species, LookupTable watertype) {
		super();
		this.tankAnimalID = tankAnimalID;
		this.animal = animal;
		this.species = species;
		this.watertype = watertype;
	}
	
	public TankAnimals(Animals animal, LookupTable species, LookupTable watertype) {
		super();
		this.animal = animal;
		this.species = species;
		this.watertype = watertype;
	}
	
	public TankAnimals() {}

	public int getTankAnimalID() {
		return tankAnimalID;
	}

	public void setTankAnimalID(int tankAnimalID) {
		this.tankAnimalID = tankAnimalID;
	}

	public Animals getAnimal() {
		return animal;
	}

	public void setAnimal(Animals animal) {
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

	@Override
	public String toString() {
		return "TankAnimals [tankAnimalID=" + tankAnimalID + ", animal=" + animal + ", species=" + species + ", watertype=" + watertype
				+ "]";
	}
}
