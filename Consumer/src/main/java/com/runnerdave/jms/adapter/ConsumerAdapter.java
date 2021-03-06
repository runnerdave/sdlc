package com.runnerdave.jms.adapter;

import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;


@Component
public class ConsumerAdapter {

	private static Logger logger = LogManager.getLogger(ConsumerAdapter.class.getName());

	
	
	@SuppressWarnings("deprecation")
	public void sendToMongo(String json) throws UnknownHostException {
		logger.info("Sending to MongoDB");
		MongoClient client = new MongoClient();
		DB db = client.getDB("vendor");
		DBCollection collection = db.getCollection("contact");
		logger.info("Converting JSON to DBObject");
		DBObject object = (DBObject)JSON.parse(json);
		collection.insert(object);
		logger.info("inserted into mongodb");
	}

}
