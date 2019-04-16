package com.discern.car.service;

import com.discern.car.entity.SearchHistoryPic;

import java.util.List;

/**
 * Created by Keben on 2019-01-03.
 */
public interface SearchHistoryPicService {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchHistoryPic record);

    int insertSelective(SearchHistoryPic record);

    SearchHistoryPic selectByPrimaryKey(Integer id);

    List<SearchHistoryPic> selectByUid(Integer uid);

    int updateByPrimaryKeySelective(SearchHistoryPic record);

    int updateByPrimaryKey(SearchHistoryPic record);
}
