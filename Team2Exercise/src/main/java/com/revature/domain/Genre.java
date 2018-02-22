package com.revature.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "GENRE")
public class Genre  implements Serializable {

	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genre(String name) {
		super();
		this.name = name;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genreSequence")
	@SequenceGenerator(allocationSize = 1, name = "genreSequence", sequenceName = "SQ_GENRE_PK")
	@Column(name = "GENRE_ID")
	private int id;
	
	@Column(name = "GENRE_NAME", unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "genres")
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
		return "Genre [name=" + name + "]";
	}
}
