package com.revature.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ACTOR")
public class Actor  implements Serializable {

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Actor(String name) {
		super();
		this.name = name;
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actorSequence")
	@SequenceGenerator(allocationSize = 1, name = "actorSequence", sequenceName = "SQ_ACTOR_PK")
	@Column(name = "ACTOR_ID")
	private int id;
	
	@Column(name = "ACTOR_NAME", unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "actors")
    private List<Movie> movies = new ArrayList<>();
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Actor [name=" + name + "]";
	}
}
