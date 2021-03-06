package com.discern.car.service.impl;

import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.common.Result;
import com.discern.car.dao.TagMapper;
import com.discern.car.entity.Tag;
import com.discern.car.service.TagService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by Keben on 2018-05-12.
 */
@Service("tagService")
public class TagServiceImpl implements TagService {
    @Resource
    TagMapper mapper;

    @Override
    public Result<Boolean> deleteByPrimaryKey(Integer tagId) {
        mapper.deleteByPrimaryKey(tagId);
        return Result.newSuccess(true);
    }

    @Override
    public Result<Integer> insert(Tag record) {
        Integer id = mapper.insert(record);
        return Result.newSuccess(id);
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
    public PageResult<Tag> list(Page page) {
        List<Tag> tags = mapper.list((page.getPage()-1)*page.getLimit(),page.getLimit());
        Integer count = mapper.selectCount();
        page.setCount(count);
        return PageResult.newSuccess(page, tags);
    }

    @Override
    public int insertTagWithUserId(Integer userId, Integer tagId) {
        return mapper.insertTagWithUserId(userId, tagId);
    }

    @Override
    public List<Tag> selectNoHasByUserId(Integer userId) {
        return mapper.selectNoHasByUserId(userId);
    }

    @Override
    public int selectCount() {
        return mapper.selectCount();
    }

    @Override
    public int removeTagWithUserId(Integer userId, Integer tagId) {
        return mapper.removeTagWithUserId(userId, tagId);
    }
}
