package com.discern.car.dao;

import com.discern.car.entity.Collection;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollectionMapper {

  int deleteByUserIdAndIssueId(@Param("userId") Integer userId, @Param("issueId") Integer issueId);

  int insert(Collection record);

  int insertSelective(Collection record);

  Collection selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Collection record);

  int updateByPrimaryKey(Collection record);

  List<Map<String, String>> selectIssueInfoByUserCollected(Integer userId);
}