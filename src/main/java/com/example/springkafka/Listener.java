package com.example.springkafka;

import java.util.concurrent.CountDownLatch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;

//@Service
public class Listener {
	
	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	private final Log log = LogFactory.getLog(getClass());

	@KafkaListener(topics = "my-example-topic", groupId = "SpringKafkaEgConsumer")
	public void receive(String payload) {
		this.log.info("received payload={ " + payload + " }");
	}

}
