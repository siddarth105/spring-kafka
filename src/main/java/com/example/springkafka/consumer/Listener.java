package com.example.springkafka.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
	
	private final Log log = LogFactory.getLog(getClass());
	
	@KafkaListener(topics = "${spring.kafka.topic}") //, groupId = "KafkaExampleConsumer"
	public void receive(String payload) {
		this.log.info("received payload={ " + payload + " }");
	}

}
