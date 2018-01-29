package com.example.springkafka.consumer;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


public class KafkaConsumerExample {
	
	private final static String TOPIC = "my-example-topic";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092";
	
	private static Consumer<String, String> createConsumer() {
	      final Properties props = new Properties();
	      props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
	                                  BOOTSTRAP_SERVERS);
	      props.put(ConsumerConfig.GROUP_ID_CONFIG,
	                                  "KafkaExampleConsumer");
	      props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
	    		  StringDeserializer.class.getName());
	      props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
	              StringDeserializer.class.getName());

	      final Consumer<String, String> consumer = new KafkaConsumer<>(props);

	      consumer.subscribe(Collections.singletonList(TOPIC));
	      System.out.println("Subscribed to topic " + TOPIC);
	      
	      /*ArrayList<TopicPartition> partitionList = new ArrayList<TopicPartition>();
	      TopicPartition partition = new TopicPartition(TOPIC, 0);
	      partitionList.add(partition);
	      consumer.assign(partitionList);*/
	      
	      return consumer;
	  }
	
	public static void runConsumer() throws InterruptedException {
		
        final Consumer<String, String> consumer = createConsumer();
        
        try {
	        while (true) {
	            final ConsumerRecords<String, String> consumerRecords =
	                    consumer.poll(100);
	            
	            for (ConsumerRecord<String, String> record : consumerRecords) {
	            	System.out.println(record.value());
	            	System.out.println(String.format("Topic : %s, Partition : %d, Offset : %d, Key : %s, Value : %s", 
	            			record.topic(), record.partition(), record.offset(), record.key(), record.value()));
	            }
	            consumer.commitAsync();
	        }
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	consumer.close();
        }
    }
}
