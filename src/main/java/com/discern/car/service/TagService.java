package com.discern.car.service;

import com.discern.car.entity.Tag;

import java.util.List;

/**
 * Created by Keben on 2018-05-12.
 */
public interface TagService {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> selectByUserId(Integer userId);
}