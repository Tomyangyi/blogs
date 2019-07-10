package com.eurekaclient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RefreshScope
@RestController
@EnableFeignClients
@EnableEurekaClient
@EnableZuulProxy
@ComponentScan(basePackages = {"com.eurekaclient"})
public class FeginClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeginClientApplication.class, args);
    }
}
