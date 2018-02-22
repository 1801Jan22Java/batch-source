package com.revature.dao;import java.util.List;

import com.revature.beans.Cat;

public interface CatDao {

    public List<Cat> getCats();

    public Cat getCatById(int id);

    public int addCat(Cat f);

    public void deleteCat(Cat f);

    public void merge(Cat f);

    public void saveOrUpdate(Cat f);

}