package com.discern.car.dao;

import com.discern.car.common.Page;
import com.discern.car.entity.Issue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

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

    List<Issue> list(@Param("offset") Integer offset,@Param("limit")Integer limit);

    Integer selectCount();

    Integer updateViewCountByPrimaryKey(@Param("id") Integer primaryKey);
}