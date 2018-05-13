package com.discern.car.dao;

import com.discern.car.entity.Issue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IssueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Issue record);

    int insertSelective(Issue record);

    Issue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKeyWithBLOBs(Issue record);

    int updateByPrimaryKey(Issue record);
}