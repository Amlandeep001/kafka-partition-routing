package com.org.events.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.org.events.dto.Customer;

@Service
public class KafkaMessagePublisher
{
	private final KafkaTemplate<String, Object> template;
	private final String topic;

	public KafkaMessagePublisher(KafkaTemplate<String, Object> template, @Value("${kafka.testing.topic}") String topic)
	{
		this.template = template;
		this.topic = topic;
	}

	public void sendMessageToTopic(String message)
	{
		/*CompletableFuture<SendResult<String, Object>> future = template.send("amlan-topic", 3, null, message);
		future.whenComplete((result, ex) ->
		{
			if(ex == null)
			{
				System.out.println("Sent message=[" + message +
						"] with offset=[" + result.getRecordMetadata().offset() + "]");
			}
			else
			{
				System.out.println("Unable to send message=[" +
						message + "] due to : " + ex.getMessage());
			}
		});*/

		template.send(topic, 0, null, "hi");
		template.send(topic, 1, null, "hello");
		template.send(topic, 2, null, "welcome");
		template.send(topic, 2, null, "youtube");
		template.send(topic, 3, null, "bye");
		template.send(topic, 4, null, "facebook");
	}

	public void sendEventsToTopic(Customer customer)
	{
		try
		{
			CompletableFuture<SendResult<String, Object>> future = template.send("amlan-demo", customer);
			future.whenComplete((result, ex) ->
			{
				if(ex == null)
				{
					System.out.println("Sent message=[" + customer.toString() +
							"] with offset=[" + result.getRecordMetadata().offset() + "]");
				}
				else
				{
					System.out.println("Unable to send message=[" +
							customer.toString() + "] due to : " + ex.getMessage());
				}
			});
		}
		catch(Exception ex)
		{
			System.out.println("ERROR : " + ex.getMessage());
		}
	}
}
