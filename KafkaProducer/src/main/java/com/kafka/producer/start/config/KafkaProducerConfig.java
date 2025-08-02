package com.kafka.producer.start.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

	@Bean
	public NewTopic createTopic() {
		
		return new NewTopic("prakash-topic-1", 3, (short)1);
	}
}
