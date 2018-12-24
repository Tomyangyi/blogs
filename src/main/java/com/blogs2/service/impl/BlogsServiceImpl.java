package com.blogs2.service.impl;

import com.blogs2.bean.Title;
import com.blogs2.mapper.BlogsMapper;
import com.blogs2.service.BlogsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogsServiceImpl implements BlogsService {

    @Autowired
    private BlogsMapper blogsMapper;

    @Override
    public boolean addTitle(Title title) {
      boolean flag=  blogsMapper.addTitle(title);
        return flag;
    }

    @Override
    public List<Title> getTitleList(int type) {
        List<Title> list=blogsMapper.getTitleList(type);
        return list;
    }

    @Override
    public Title getTitle(int id) {
        Title title=blogsMapper.getTitle(id);
        return title;
    }

    @Override
    public boolean update(Title title) {
        boolean flag=blogsMapper.update(title);
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag=blogsMapper.delete(id);
        return flag;
    }
}
