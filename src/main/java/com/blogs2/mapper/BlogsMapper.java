package com.blogs2.mapper;

import com.blogs2.bean.Title;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BlogsMapper {

    boolean addTitle(Title title);

    List<Title> getTitleList(int type);

    Title getTitle(int id);

    boolean update(Title title);

    boolean delete(int id);
}
