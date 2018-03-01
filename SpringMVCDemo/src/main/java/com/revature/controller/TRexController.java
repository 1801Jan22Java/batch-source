package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.TRex;
import com.revature.service.TRexService;

@Controller("tRexController")
@RequestMapping("/trex")
public class TRexController {

	@Autowired
	private TRexService mockTrexService;

	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<List<TRex>> getAllTRexes() {
		return new ResponseEntity<>(mockTrexService.getAllTRexes(), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<TRex> getTRexById(@PathVariable int id){
		ResponseEntity<TRex> resp = null;
		for (TRex t : mockTrexService.getAllTRexes()){
			if (id == t.getId()){
			resp = new ResponseEntity<>(t,HttpStatus.OK);
			}
		} 
		return resp;
	}

	@PostMapping("/addTRex")
	@ResponseBody
	public ResponseEntity<String> addTRex(@RequestBody TRex tRex) {

		ResponseEntity<String> resp = null;
		try {
			mockTrexService.addTRex(tRex);
			resp = new ResponseEntity<>(tRex.toString(), HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("failed to add TRex", HttpStatus.BAD_REQUEST);
		}
		return resp;

	}
}
