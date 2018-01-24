package com.revature.wednesday;

import java.util.Arrays;

public class Batch {
	
	private String id;
	
	private String topic;
	
	private String[] members;

	public Batch(String id, String topic, String[] members) {
		super();
		this.id = id;
		this.topic = topic;
		this.members = members;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Batch)) {
			return false;
		}
		Batch other = (Batch) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		//if (!Arrays.equals(members, other.members)) {
			//return false;
		//}
		if (topic == null) {
			if (other.topic != null) {
				return false;
			}
		} else if (!topic.equals(other.topic)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(members);
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		return result;
	}

	
	
}
