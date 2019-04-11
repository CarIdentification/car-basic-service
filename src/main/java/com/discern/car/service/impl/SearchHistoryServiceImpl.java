package com.discern.car.service.impl;

import com.discern.car.dao.SearchHistoryMapper;
import com.discern.car.entity.SearchHistory;
import com.discern.car.service.SearchHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Keben on 2018-05-11.
 */
@Service("searchHistoryService")
public class SearchHistoryServiceImpl implements SearchHistoryService {


    @Resource
    private SearchHistoryMapper searchHistoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return searchHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SearchHistory record) {
        return searchHistoryMapper.insert(record);
    }

    @Override
    public int insertSelective(SearchHistory record) {
        return searchHistoryMapper.insertSelective(record);
    }

    @Override
    public SearchHistory selectByPrimaryKey(Integer id) {
        return searchHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SearchHistory record) {
        return searchHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SearchHistory record) {
        return searchHistoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SearchHistory> selectByUserId(Integer id) {
        return searchHistoryMapper.selectByUserId(id);
    }

    @Override
    public List<SearchHistory> select(SearchHistory searchHistory) {
        return null;
    }
}
