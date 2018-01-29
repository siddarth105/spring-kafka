package com.example.springkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication/*(exclude = {EmbeddedServletContainerAutoConfiguration.class})*/
public class SpringKafkaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SpringKafkaApplication.class, args);
		//KafkaConsumerExample.runConsumer();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringKafkaApplication.class);
	}
}
