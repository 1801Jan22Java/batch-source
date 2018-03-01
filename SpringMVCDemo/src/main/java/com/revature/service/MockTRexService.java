package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.TRex;

@Service("mockTRexService")
public class MockTRexService implements TRexService {
	
	public List<TRex> getAllTRexes(){
		
		List<TRex> tRexList = new ArrayList<>();
		
		tRexList.add(new TRex(1,"Susan","gold"));
		tRexList.add(new TRex(2,"Timmy","blue"));
		tRexList.add(new TRex(3,"Barney","purple"));
		
		return tRexList;
	}

	@Override
	public void addTRex(TRex tRex) {
		//do something 
		
	}

}
