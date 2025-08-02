package com.kafka.producer.start.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerService {
	
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public KafkaProducerService(KafkaTemplate<String, Object> template) {
		this.kafkaTemplate=template;
	}
	
	public void SendMessageToTopic(String message) {
		
		CompletableFuture<SendResult<String,Object>> future= kafkaTemplate.send("prakash-topic", message);
		future.whenComplete((result,exception)->{
			if(exception==null) {
				System.out.println(message+" sent to topic with offset "+result.getRecordMetadata().offset());
			}
			else {
				System.out.println("Message Not Sent due to "+ exception.getMessage());
			}
		});
		
	}

}
