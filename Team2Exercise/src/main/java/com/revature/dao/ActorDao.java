package com.revature.dao;

import com.revature.domain.Actor;

public interface ActorDao {
	public Actor getActorById(int id);
	public int addActor(Actor a);
}
