package com.eurekaclient.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="eurekaClient",fallback = HelloWorldServiceFailure.class)
@Component
public interface Client {

    @RequestMapping(value="/getName",method= RequestMethod.GET)
    String getName(@RequestParam("name") String name);
}
