package com.revature.dao;

import java.util.List;

import com.revature.domains.Meetup;

public interface MeetupDao {
	public List<Meetup> getAll();
	public Meetup getById(int id);
	public int add(Meetup m);
	public void delete(Meetup m);
	public void merge(Meetup m);
	public void saveOrUpdate(Meetup m);
}
