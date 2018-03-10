package com.revature.controller;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TRexSource {
	
	@Output("tRexChannel")
	MessageChannel tRexChannel();

}
