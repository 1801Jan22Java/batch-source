package com.revature.client;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.TRex;

@Component(value="tRexClient")
public class TRexClient {
	
	private String resourceUrl;
	
	public void setResourceUrl(String resourceUrl){
		this.resourceUrl = resourceUrl;
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	//Jackson is doing a lot of work behind the scenes 
	public ArrayList<TRex> getTRexes(){
		ResponseEntity<? extends ArrayList<TRex>> response = 
				this.restTemplate.getForEntity(this.resourceUrl+"/trex/all",(Class<? extends ArrayList<TRex>>)ArrayList.class);
		return response.getBody();
	}
	

	public TRex saveTRex(TRex tRex){
		HttpEntity<TRex> request = new HttpEntity<TRex>(tRex);
		return this.restTemplate.postForObject(this.resourceUrl+"/trex/addTRex", request, TRex.class);
	}

}
