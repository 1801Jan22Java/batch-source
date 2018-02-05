package com.revature.beans;

public class Beehive {
	private int id;
	private int weight;

	public Beehive(int weight) {
		super();
		this.weight = weight;
	}

	public Beehive(int id, int weight) {
		super();
		this.id = id;
		this.weight = weight;
	}

	public Beehive() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Beehive [id=" + id + ", weight=" + weight + "]";
	}

}