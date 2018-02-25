package com.revature.domains;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name="MEETUPS")
public class Meetups implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="meetupsSequence")
	@SequenceGenerator(allocationSize=1,name="meetupsSequence",sequenceName="SQ_MEETUPS_PK")
    @Column(name = "MEETUP_ID")
	private int meetupID; //pk
	@OneToOne
	@JoinColumn(name = "userID")
	private Users user; //fk to uID of users table
	@OneToOne
	@JoinColumn(name = "animalID")
	private Animals animal; //fk to uID of animals table
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lookupID")
	private LookupTable statusID; //fk to lookupID for lookup table
	@Column(name="MEET_DATE")
	private LocalDateTime date;
	
	public Meetups() {}

	public Meetups(int meetupID, Users user, Animals animal, LookupTable statusID, LocalDateTime date) {
		super();
		this.meetupID = meetupID;
		this.user = user;
		this.animal = animal;
		this.statusID = statusID;
		this.date = date;
	}
	
	public Meetups(Users user, Animals animal, LookupTable statusID, LocalDateTime date) {
		super();
		this.user = user;
		this.animal = animal;
		this.statusID = statusID;
		this.date = date;
	}

	public int getMeetupIDID() {
		return meetupID;
	}

	public void setMeetupIDID(int meetupID) {
		this.meetupID = meetupID;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Animals getAnimal() {
		return animal;
	}

	public void setAnimal(Animals animal) {
		this.animal = animal;
	}

	public LookupTable getStatusID() {
		return statusID;
	}

	public void setStatusID(LookupTable statusID) {
		this.statusID = statusID;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Meetups [meetupID=" + meetupID + ", user=" + user + ", animal=" + animal + ", statusID=" + statusID
				+ ", date=" + date + "]";
	}
}
