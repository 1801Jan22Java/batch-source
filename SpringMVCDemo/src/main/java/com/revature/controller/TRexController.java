package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Message;
import com.revature.beans.TRex;
import com.revature.service.TRexService;

@Controller("tRexController")
@RequestMapping("/trex")
//@CrossOrigin(origins = "http://localhost:4200")
public class TRexController {

	@Autowired
	private TRexService mockTRexService;

	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<List<TRex>> getAllTRexes() {
		return new ResponseEntity<>(mockTRexService.getAllTRexes(), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<TRex> getTRexById(@PathVariable int id){
		ResponseEntity<TRex> resp = null;
		for (TRex t : mockTRexService.getAllTRexes()){
			if (id == t.getId()){
			resp = new ResponseEntity<>(t,HttpStatus.OK);
			}
		} 
		return resp;
	}

	@PostMapping("/addTRex")
	@ResponseBody
	public ResponseEntity<Message> addTRex(@RequestBody TRex tRex) {

		ResponseEntity<Message> resp = null;
		try {
			mockTRexService.addTRex(tRex);
			resp = new ResponseEntity<>(new Message("T-REX CREATED SUCCESSFULLY"), HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>(new Message("FAILED TO CREATE T-REX"), HttpStatus.BAD_REQUEST);
		}
		return resp;

	}
	
	//for rendering our simple T-Rex view via the View Resolver
	@RequestMapping(value="view/{id}",method=RequestMethod.GET)
	public String getTRexViewById(@PathVariable int id, Model m){
		
		for (TRex t : mockTRexService.getAllTRexes()){
			if (id == t.getId()){
				m.addAttribute("tRexId",t.getId());
				m.addAttribute("tRexName",t.getName());
				m.addAttribute("tRexFeatherColor",t.getFeatherColor());
			}
		} 
		return "tRex";
	}
	
	//for delivering our static HTML pages
	@GetMapping(value="/staticTRex")
	public String getStaticTRexPage(){
		return "forward:/static/staticTRex.html";
	}
	
	@GetMapping(value="/app")
	public String getApp(){
		return "forward:/static/index.html";
	}


}
