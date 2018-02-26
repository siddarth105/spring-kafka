1) Some time, application wont start when the Kafka & spring-kafka versions does not match ::
	Kafka Version : 2.11
	spring-kafka Version : 1.3.3.RELEASE
 
2)  Clear the Kafka logs dir, 
	Clea	r the zookeeper logs dir,
	Clear the logs dir

3) Start Zookeeper :: 
	 bin/zookeeper-server-start.sh config/zookeeper.properties

4) Start Kafka Server :: 
	 bin/kafka-server-start.sh config/server.properties

5) Create Topic :: 
	 bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic my-example-topic
	
6) Check if the topic is created :: 
	bin/kafka-topics.sh --list --zookeeper localhost:2181
	
7) Send message :: 
	bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my-example-topic

8) Start consumer :: 
	bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-example-topic --from-beginning	