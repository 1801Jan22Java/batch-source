package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Message;
import com.revature.beans.TRex;
import com.revature.service.TRexService;

@RestController
@RequestMapping(value="/trex")
//@CrossOrigin(origins = "http://localhost:4200")
public class TRexController {
	
	@Autowired 
	private TRexService trs;
	
	@GetMapping("/all")
	public ResponseEntity<List<TRex>> getAllTRexes() {
		return new ResponseEntity<>(trs.getAllTRexes(), HttpStatus.OK);
	}
	
	@PostMapping("/addTRex")
	public ResponseEntity<Message> addTRex(@RequestBody TRex tRex) {

		ResponseEntity<Message> resp = null;
		try {
			trs.addTRex(tRex);
			resp = new ResponseEntity<>(new Message("T-REX CREATED SUCCESSFULLY"), HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>(new Message("FAILED TO CREATE T-REX"), HttpStatus.BAD_REQUEST);
		}
		return resp;

	}

}
