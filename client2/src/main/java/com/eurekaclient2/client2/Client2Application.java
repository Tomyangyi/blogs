package com.eurekaclient2.client2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
@ComponentScan(basePackages = {"com.eurekaclient2"})
public class Client2Application {

	public static void main(String[] args) {
		SpringApplication.run(Client2Application.class, args);
	}

}
