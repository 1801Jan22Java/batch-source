package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.TRex;
import com.revature.repository.TRexDao;

@Service("realTRexService")
public class RealTRexService implements TRexService {
	
	@Autowired
	private TRexDao tRexRepository;

	@Override
	public List<TRex> getAllTRexes() {
		return tRexRepository.getAllTRex();
	}

	@Override
	public void addTRex(TRex tRex) {
		tRexRepository.createTRex(tRex);
	}

}
