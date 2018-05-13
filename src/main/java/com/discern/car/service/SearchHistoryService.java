package com.discern.car.service;

import com.discern.car.entity.SearchHistory;

import java.util.List;

/**
 * Created by Keben on 2018-05-11.
 */
public interface SearchHistoryService {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchHistory record);

    int insertSelective(SearchHistory record);

    SearchHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchHistory record);

    int updateByPrimaryKey(SearchHistory record);

    List<SearchHistory> selectByUserId(Integer id);
}
