package com.example.springkafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

//@Component
public class Listener {
	
	private final Log log = LogFactory.getLog(getClass());
	private CountDownLatch latch = new CountDownLatch(1);
	
	public CountDownLatch getLatch() {
	    return latch;
	}

	@KafkaListener(topics = "my-example-topic", groupId = "KafkaExampleConsumer")
	public void receive(ConsumerRecord<?, ?> payload) {
		this.log.info("received payload={ " + payload + " }");
		latch.countDown();
	}

}
