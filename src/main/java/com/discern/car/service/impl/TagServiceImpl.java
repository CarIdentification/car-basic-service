package com.discern.car.service.impl;

import com.discern.car.dao.TagMapper;
import com.discern.car.entity.Tag;
import com.discern.car.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Keben on 2018-05-12.
 */
@Service("tagService")
public class TagServiceImpl implements TagService {

    @Resource
    TagMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer tagId) {
        return mapper.deleteByPrimaryKey(tagId);
    }

    @Override
    public int insert(Tag record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Tag record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Tag selectByPrimaryKey(Integer tagId) {
        return mapper.selectByPrimaryKey(tagId);
    }

    @Override
    public int updateByPrimaryKeySelective(Tag record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tag record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Tag> selectByUserId(Integer userId) {
        return mapper.selectByUserId(userId);
    }

    @Override
    public int insertTagWithUserId(Integer userId, Integer tagId) {
        return mapper.insertTagWithUserId(userId,tagId);
    }
}
