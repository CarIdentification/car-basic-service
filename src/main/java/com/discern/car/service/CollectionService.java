package com.discern.car.service;

import com.discern.car.entity.Collection;
import java.util.List;
import java.util.Map;

public interface CollectionService {
  int insert(Collection collection);

  int delete(Integer userId,Integer issueId);

  List<Map<String,String>> selectIssueInfoByUserCollected(Integer userId);

}
