package com.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.hexagonal"})
public class MessageHexProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageHexProjectApplication.class, args);
	}

}
