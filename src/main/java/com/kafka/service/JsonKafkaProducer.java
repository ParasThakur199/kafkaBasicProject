package com.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.payload.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonKafkaProducer {

	private KafkaTemplate<String, String> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(User data) {

		log.info(String.format("Message sent -> %s", data.toString()));

		// Build the message with payload and headers
		Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "javaguides_json").build();

		// Send the message using KafkaTemplate
		kafkaTemplate.send(message);
	}
}
