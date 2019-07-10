package com.kafka.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;


@EnableBinding(Source.class)
public  class KafkaSender {
    private final Logger logger = LoggerFactory.getLogger(KafkaSender.class);

    @Autowired
    private Source source;

    public boolean sendMessage(String message) {
        try {
          boolean flag=  source.output1().send(MessageBuilder.withPayload("message: " + message).build());
            logger.info("生产 message"+message);
          return  flag;
        } catch (Exception e) {
            logger.info("消息发送失败，原因："+e);
            e.printStackTrace();
            return false;
        }
    }
}
