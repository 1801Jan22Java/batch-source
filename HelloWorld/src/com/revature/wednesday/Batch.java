package com.revature.wednesday;

import java.util.Arrays;

public class Batch {
	
<<<<<<< HEAD
=======
	public Batch() {
		super();
	}

	public Batch(String id, String topic, String[] members) {
		super();
		this.id = id;
		this.topic = topic;
		this.members = members;
	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	private String id;
	
	private String topic;
	
	private String[] members;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String[] getMembers() {
		return members;
	}

	public void setMembers(String[] members) {
		this.members = members;
	}

<<<<<<< HEAD
	public Batch(String id, String topic, String[] members) {
		super();
		this.id = id;
		this.topic = topic;
		this.members = members;
	}

	public Batch() {
		super();
	}

	@Override
=======
	/*@Override
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(members);
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		return result;
	}

<<<<<<< HEAD
	/*@Override
=======
	@Override
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batch other = (Batch) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
<<<<<<< HEAD
		
=======
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}*/
<<<<<<< HEAD
	
	
	
=======

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
