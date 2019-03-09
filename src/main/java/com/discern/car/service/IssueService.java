package com.discern.car.service;

import com.discern.car.entity.Issue;

import java.util.List;

/**
 * Created by a on 2018/5/17.
 */
public interface IssueService {
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
