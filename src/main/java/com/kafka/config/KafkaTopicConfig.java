package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic createNewTopics() {
		return TopicBuilder.name("javaguides")
//				.partitions(10)
				.build();
	}
	
	@Bean
	public NewTopic createJsonNewTopics() {
		return TopicBuilder.name("javaguides_json")
//				.partitions(10)
				.build();
	}
	
}
