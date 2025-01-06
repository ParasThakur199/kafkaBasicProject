package com.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.payload.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonKafkaConsumer {
	
	@KafkaListener(topics="javaguides_json",groupId = "myGroup")
	public void consume(User user) {
		log.info(String.format("Json message received -> %s", user.toString()));
	}
}
