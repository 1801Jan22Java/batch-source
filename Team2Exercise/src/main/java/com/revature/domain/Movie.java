package com.revature.domain;
import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "MOVIE")
public class Movie  implements Serializable {
	
	public Movie(String name, List<Genre> genres, List<Actor> actors) {
		super();
		this.name = name;
		this.genres = genres;
		this.actors = actors;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String name) {
		super();
		this.name = name;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieSequence")
	@SequenceGenerator(allocationSize = 1, name = "movieSequence", sequenceName = "SQ_MOVIE_PK")
	@Column(name = "MOVIE_ID")
	private int id;
	
	@Column(name = "MOVIE_NAME")
	private String name;
	
	
	@ManyToMany
    @JoinTable(
        name = "MOVIE_GENRE", 
        joinColumns = { @JoinColumn(name = "MOVIE_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "GENRE_ID") }
    )
	List <Genre> genres = new ArrayList<>();
	
	@ManyToMany
    @JoinTable(
        name = "MOVIE_ACTOR", 
        joinColumns = { @JoinColumn(name = "MOVIE_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "ACTOR_ID") }
    )
	List <Actor> actors = new ArrayList<>();

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
		return "Movie [name=" + name + "]";
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
}
