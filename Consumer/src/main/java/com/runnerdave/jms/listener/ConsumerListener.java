package com.runnerdave.jms.listener;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

@Component
public class ConsumerListener implements MessageListener {

	public void onMessage(Message message) {
		System.out.println("In onMessage()");
	}

}
