package com.eurekaclient.rabbitmq;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Producer {

    @Autowired
    private AmqpTemplate template;

    public void produce() {
        String content = "hello" + new Date();
        System.out.println("生产者发送消息到MQ :" + content);
        template.convertAndSend("hello", content);
    }


}
