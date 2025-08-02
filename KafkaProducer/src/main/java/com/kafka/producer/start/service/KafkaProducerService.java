package com.kafka.producer.start.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerService {
	
	private KafkaTemplate<String, Object> kafkaTemplate;
	private String messageStatus;
	
	public KafkaProducerService(KafkaTemplate<String, Object> template) {
		this.kafkaTemplate=template;
	}
	
	public String SendMessageToTopic(String message) {
		
		CompletableFuture<SendResult<String,Object>> future= kafkaTemplate.send("prakash-topic-1", message);
		
		future.whenComplete((result,exception)->{
			if(exception==null) {
				this.messageStatus=message+" sent to topic with offset "+result.getRecordMetadata().offset();
			}
			else {
				this.messageStatus="Message Not Sent due to "+ exception.getMessage();
			}
		});
		
		return messageStatus;
		
	}

}
