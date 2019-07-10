package com.eurekaclient.controller;

import com.eurekaclient.fegin.Client;
import com.eurekaclient.rabbitmq.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Component
@RefreshScope
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${hello}")
    private String hello;

    @Autowired
    private Client client;

    @Autowired
    Producer producer;

    @RequestMapping(value = "/getName",method = RequestMethod.GET)
    public String getName(){
        logger.info("fueurekaClient发送fegin请求"+hello);
        String name=client.getName("yangyi");
        name="负载均衡 fegin:"+name+hello;
        return name;
    }


    @RequestMapping(value = "/getCandy",method = RequestMethod.GET)
    public void getHello(){
        producer.produce();
    }

    @RequestMapping(value = "/getApple",method = RequestMethod.GET)
    public String getCandy(){
        return "12341564";
    }



}
