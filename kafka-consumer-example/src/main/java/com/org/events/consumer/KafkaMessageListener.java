package com.org.events.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaMessageListener
{
	/*@KafkaListener(topics = "amlan-topic", groupId = "jt-group")
	public void consumeEvents(Customer customer)
	{
		log.info("consumer consume the events {} ", customer.toString());
	}*/

	@KafkaListener(topics = "${kafka.testing.topic}", groupId = "${spring.kafka.consumer.groupId}",
			topicPartitions = {@TopicPartition(topic = "${kafka.testing.topic}", partitions = "${kafka.testing.topic.partitions}")})
	public void consumeEvents(String message)
	{
		log.info("consumer consumed the events {} ", message);
	}

	// @KafkaListener(topics = "amlan-demo1",groupId = "amlan-group-new")
	// public void consume2(String message) {
	// log.info("consumer2 consume the message {} ", message);
	// }
	//
	// @KafkaListener(topics = "amlan-demo1",groupId = "amlan-group-new")
	// public void consume3(String message) {
	// log.info("consumer3 consume the message {} ", message);
	// }
	//
	// @KafkaListener(topics = "amlan-demo1",groupId = "amlan-group-new")
	// public void consume4(String message) {
	// log.info("consumer4 consume the message {} ", message);
	// }
}
