package com.discern.car.dao;

import com.discern.car.entity.Issue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IssueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Issue record);

    int insertSelective(Issue record);

    Issue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKeyWithBLOBs(Issue record);

    int updateByPrimaryKey(Issue record);

    List<Issue> selectByHot();

    List<Issue> selectRecommendIssue(Integer userId);

    List<Issue> selectByTextSearch(String textSearch);
}