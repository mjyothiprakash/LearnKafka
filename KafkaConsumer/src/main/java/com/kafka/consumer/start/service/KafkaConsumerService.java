package com.kafka.consumer.start.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	Logger logger=LoggerFactory.getLogger(KafkaConsumerService.class);
	
	@KafkaListener(topics = "prakash-topic-1",groupId = "prakash-group")
	public void consumeMessage(String message) {
		
		logger.info("Consumer received the message : "+message);
	}
	
}
