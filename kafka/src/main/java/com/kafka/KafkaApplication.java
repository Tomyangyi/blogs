package com.kafka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.kafka"})
public class KafkaApplication {




	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
