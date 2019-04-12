package com.discern.car.dao;

import com.discern.car.entity.SearchHistoryPic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchHistoryPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchHistoryPic record);

    int insertSelective(SearchHistoryPic record);

    SearchHistoryPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchHistoryPic record);

    int updateByPrimaryKey(SearchHistoryPic record);
}