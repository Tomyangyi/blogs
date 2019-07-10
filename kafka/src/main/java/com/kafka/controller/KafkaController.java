package com.kafka.controller;

import com.kafka.util.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KafkaController {
    @Autowired
    private KafkaSender kafkaSender;

    @RequestMapping("/getString")
    public boolean sendMsg(){
        boolean flag=true;
        for (int i = 0; i < 10; i++) {
            //调用消息发送类中的消息发送方法
            flag= kafkaSender.sendMessage("生产消息------："+i);
        }
        return flag;
    }
}
