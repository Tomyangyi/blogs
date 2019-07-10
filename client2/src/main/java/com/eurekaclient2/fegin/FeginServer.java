package com.eurekaclient2.fegin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeginServer {
    private static final Logger logger = LoggerFactory.getLogger(FeginServer.class);
    @RequestMapping(value = "/getName",method = RequestMethod.GET)
    public String getName(@RequestParam("name") String name){
        logger.info("client2 :收到fegin请求");
        return "client2"+name;
    }

    @RequestMapping(value = "/getHello",method = RequestMethod.GET)
    public String getHello(){
        return "123456789";
    }

}
