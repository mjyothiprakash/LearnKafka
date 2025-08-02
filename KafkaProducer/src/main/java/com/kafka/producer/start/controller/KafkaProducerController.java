package com.kafka.producer.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.start.service.KafkaProducerService;

@RestController
@RequestMapping("/producer")
public class KafkaProducerController {

	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@GetMapping("/send/{message}")
	public ResponseEntity<?> publichMessage(@PathVariable String message){
		try {
			kafkaProducerService.SendMessageToTopic(message);
			return ResponseEntity.status(HttpStatus.OK).body("Message sent...");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not Sent"+ex.getMessage());
		}
	}
	
}
