package com.blogs2.service;

import com.blogs2.bean.Title;
import java.util.List;


public interface BlogsService {

    boolean addTitle(Title title);

    List<Title> getTitleList(int type);

    Title getTitle(int id);

    boolean update(Title title);

    boolean delete(int id);
}
