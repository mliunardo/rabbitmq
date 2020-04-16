package com.rabbitmq.rabbitamqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rabbitmq.rabbitamqp.model.SimpleMessage;

@SpringBootApplication
public class RabbitamqpApplication implements CommandLineRunner{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitamqpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* Send message to Default Exchange (AMQP Default) 
		 * Unable to be retrieved message in Queues (NO BINDING, NO ROUTING)
		
		rabbitTemplate.convertAndSend("Hello from our first message");
		
		*/
		
		SimpleMessage simpleMessage = new SimpleMessage();
		simpleMessage.setName("FirstMessage");
		simpleMessage.setDescription("simpleDescription");
		
		rabbitTemplate.convertAndSend("TestExchange", "testRouting", simpleMessage);
		
		
	}

}
