package com.discern.car.dao;

import com.discern.car.common.Page;
import com.discern.car.dto.IssueDto;
import com.discern.car.entity.Issue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

@Mapper
public interface IssueMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteIssueTag(Integer id);

    int insert(Issue record);

    int insertSelective(Issue record);

    Issue selectByPrimaryKey(Integer id);

    IssueDto selectByPrimaryKeyWithTag(Integer id);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKeyWithBLOBs(Issue record);

    int updateByPrimaryKey(Issue record);

    List<Issue> selectByHot();

    List<Issue> selectRecommendIssue(Integer userId);

    List<Issue> selectByTextSearch(String textSearch);

    List<IssueDto> list(@Param("offset") Integer offset, @Param("limit")Integer limit);

    Integer selectCount();

    Integer updateViewCountByPrimaryKey(@Param("id") Integer primaryKey);

    Integer insertIssueTag(@Param("issueId")Integer issueId,@Param("tagId")Integer tagId);

    Integer updateIssueTag(@Param("issueId")Integer issueId,@Param("tagId")Integer tagId);
}