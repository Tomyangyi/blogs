package com.eurekaclient.rabbitmq;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component

@RabbitListener(queues = "hello")
public class Consumer {

    @RabbitHandler
    public void consume(String hello){
        System.out.println("消费者从MQ接收消息:" + hello);
    }
}
