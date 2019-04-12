package com.discern.car.service;

import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.entity.Issue;

import java.util.List;
import org.apache.ibatis.annotations.Param;

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

    PageResult<Issue> list(@Param("page") Page page);
}
