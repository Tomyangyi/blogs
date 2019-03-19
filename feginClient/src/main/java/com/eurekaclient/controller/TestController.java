package com.eurekaclient.controller;

import com.eurekaclient.fegin.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    //@Value("${hello}")
    private String hello="123";

    @Autowired
    private Client client;

    @RequestMapping(value = "/getName",method = RequestMethod.GET)
    public String getName(){
        logger.info("eurekaClient发送fegin请求"+hello);
        String name=client.getName("yangyi");
        return name;
    }

}
