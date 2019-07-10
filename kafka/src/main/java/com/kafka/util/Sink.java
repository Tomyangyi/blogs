package com.kafka.util;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface Sink {
    //接收队列1
    String INPUT_1 = "input";

    @Input(Sink.INPUT_1)
    SubscribableChannel input1();


    //接收队列1
    String INPUT_2 = "input2";

    @Input(Sink.INPUT_2)
    SubscribableChannel INPUT_2();

}
