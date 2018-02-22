package com.revature.dao;
import java.util.List;
import com.revature.beans.CatLover;
public interface UserDao {

    public List<CatLover> getUsers();

    public CatLover getUserById(int id);

    public int addUser(CatLover f);

    public void deleteUser(CatLover f);

    public void merge(CatLover f);

    public void saveOrUpdate(CatLover f);

}