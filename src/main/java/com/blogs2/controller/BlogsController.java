package com.blogs2.controller;

import com.blogs2.bean.Title;
import com.blogs2.service.BlogsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class BlogsController {

    @Autowired
    private BlogsService blogsService;

    @GetMapping("/index")
    public String index(){
        getTitle(1);
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = {"/getTitleList"}, method = RequestMethod.POST)
    @ResponseBody
    private List<Title> getTitleList(int type) {
        return  blogsService.getTitleList(type);
    }


    @RequestMapping(value = {"/getTitle"}, method = RequestMethod.POST)
    @ResponseBody
    private Title getTitle(int id) {
        return  blogsService.getTitle(id);
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    @ResponseBody
    private boolean add(Title title) {
        return  blogsService.addTitle(title);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    private boolean update(Title title) {
        return  blogsService.update(title);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    @ResponseBody
    private boolean delete(int id) {
        return  blogsService.delete(id);
    }
}
