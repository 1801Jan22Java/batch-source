package com.revature.dao;import java.util.List;import com.revature.beans.Shelter;public interface ShelterDao {

    public List<Shelter> getShelters();

    public Shelter getShelterById(int id);

    public int addShelter(Shelter f);

    public void deleteShelter(Shelter f);

    public void merge(Shelter f);

    public void saveOrUpdate(Shelter f);

}