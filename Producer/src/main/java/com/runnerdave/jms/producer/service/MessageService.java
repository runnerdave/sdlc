package com.runnerdave.jms.producer.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.runnerdave.jms.producer.model.Vendor;
import com.runnerdave.jms.producer.sender.MessageSender;

@Component
public class MessageService {
	private static Logger logger = LogManager.getLogger(MessageService.class.getName());
	
	@Autowired
	MessageSender messageSender;
	
	public void process(Vendor vendor) {
		Gson gson = new Gson();
		String json = gson.toJson(vendor);
		logger.info("Message:" + json);
		messageSender.send(json);
	}

}
