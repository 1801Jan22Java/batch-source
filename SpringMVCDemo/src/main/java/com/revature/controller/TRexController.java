package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.revature.service.TRexService;
import com.revature.beans.TRex;

@Controller("tRexController")
@RequestMapping("/trex")
public class TRexController {

	@Autowired
	private TRexService mockTRexService;
	
	@GetMapping("/all")
	public @ResponseBody ResponseEntity<List<TRex>> getAllTRexes() {
		return new ResponseEntity<>(mockTRexService.getAllTRexes(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TRex> getTRexById(@PathVariable int id) {
		ResponseEntity<TRex> resp = null;
		for (TRex t : mockTRexService.getAllTRexes()) {
			if (id == t.getId())
				resp = new ResponseEntity<>(t, HttpStatus.OK);
		}
		return resp;	
	}
	
	@PostMapping("/addTRex")
	@ResponseBody
	public ResponseEntity<String> addTrex(@RequestBody TRex tRex) {
		ResponseEntity<String> resp;
		try {
			mockTRexService.addTRex(tRex);
			resp = new ResponseEntity<>(tRex.toString(), HttpStatus.OK);
		} catch(Exception e) {
			resp = new ResponseEntity<>("failed to add TRex", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	// For rendering our simple T-Rex view via view resolver
	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
	public String getTRexViewById(@PathVariable int id, Model m) {
		
		for (TRex t : mockTRexService.getAllTRexes()) {
			if (id == t.getId()) {
				m.addAttribute("tRexId", t.getId());
				m.addAttribute("tRexName", t.getName());
				m.addAttribute("tRexFeatherColor", t.getFeatherColor());
			}
		}
		return "tRex";	
	}
	
	@GetMapping(value="/staticTRex")
	public String getStaticTRexPage() {
		return "forward:/static/staticTRex.html";
	}
	
}
