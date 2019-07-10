package com.kafka.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


@EnableBinding(Sink.class)
public class KafkaReceiver2 {

    private final Logger logger = LoggerFactory.getLogger(KafkaReceiver2.class);

    @StreamListener(Sink.INPUT_2)
    private void receive(String vote) {
        logger.info("消费2 message : " + vote);
    }

}