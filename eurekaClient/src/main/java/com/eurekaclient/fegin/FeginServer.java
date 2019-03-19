package com.eurekaclient.fegin;

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
        logger.info("收到fegin请求");
        return "hello world"+name;
    }

}
