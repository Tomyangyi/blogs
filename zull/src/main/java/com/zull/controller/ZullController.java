package com.zull.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ZullController {

    @RequestMapping("/getString")
    public String getString(){
        return "12345678";
    }

}
