package com.discern.car.service.impl;

import com.discern.car.dao.SearchHistoryPicMapper;
import com.discern.car.entity.SearchHistoryPic;
import com.discern.car.service.SearchHistoryPicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Keben on 2019-01-04.
 */
@Service("SearchHistoryPicService")
public class SearchHistoryPicServiceImpl implements SearchHistoryPicService {
    @Resource
    SearchHistoryPicMapper searchHistoryPicMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return searchHistoryPicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SearchHistoryPic record) {
        return searchHistoryPicMapper.insert(record);
    }

    @Override
    public int insertSelective(SearchHistoryPic record) {
        return searchHistoryPicMapper.insertSelective(record);
    }

    @Override
    public SearchHistoryPic selectByPrimaryKey(Integer id) {
        return searchHistoryPicMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SearchHistoryPic> selectByUid(Integer uid) {
        return searchHistoryPicMapper.selectByUid(uid);
    }

    @Override
    public int updateByPrimaryKeySelective(SearchHistoryPic record) {
        return searchHistoryPicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SearchHistoryPic record) {
        return searchHistoryPicMapper.updateByPrimaryKey(record);
    }
}
