package com.runnerdave.jms.listener;

import java.net.UnknownHostException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.runnerdave.jms.adapter.ConsumerAdapter;

@Component
public class ConsumerListener implements MessageListener {
	
	private static Logger logger = LogManager.getLogger(ConsumerListener.class.getName());
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	ConsumerAdapter consumerAdapter;

	public void onMessage(Message message) {
		logger.info("In onMessage()");
		
		String json = null;
		if (message instanceof TextMessage) {
			try {
				json = ((TextMessage)message).getText();
				logger.info("sending json to DB: " + json);
				consumerAdapter.sendToMongo(json);
			} catch (JMSException e) {
				logger.error("message: " + json);
				jmsTemplate.convertAndSend(json);
			} catch (UnknownHostException e) {
				logger.error("message: " + json);
				jmsTemplate.convertAndSend(json);
			} catch (Exception e) {
				logger.error("message: " + json);
				jmsTemplate.convertAndSend(json);
			} 
		}
		
	}

}
