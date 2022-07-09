package com.ecom.kafkaconsumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumer1Application {

	@KafkaListener(topics = "myFirstTopic",groupId = "consumer1")
	public void consume(String message){
		System.out.println("Message Consumed by Consumer 1 is : "+message);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumer1Application.class, args);
	}

}
