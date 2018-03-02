package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.TRex;

@Repository
public interface TrexDao extends JpaRepository<TRex,Integer>{
	
	public List<TRex> findTRexByFeatherColor(String featherColor);
	
	//not a thing (in this version) 
	//public void deleteTRexByName(String name);
	
	

}
