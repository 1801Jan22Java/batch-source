package com.revature.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

import com.revature.beans.TRex;

@EnableBinding(TRexSource.class)
public class TRexPublisher {
	
	public String sendTRex(){
		return "Fred the T-Rex";
	}
	
	@Bean 
	@InboundChannelAdapter(channel="tRexChannel")
	public MessageSource<TRex> sendRealTRex(){
		return () -> MessageBuilder.withPayload(new TRex("RealFred","Blue")).build();
	}
	

}
