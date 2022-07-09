package com.ecom.kafkaconsumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumer2Application {

	@KafkaListener(topics = "myFirstTopic",groupId = "consumer2")
	public void consume(String message){
		System.out.println("Message Consumed by consumer 2 is : "+message);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumer2Application.class, args);
	}

}
