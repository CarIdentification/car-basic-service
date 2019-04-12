package com.discern.car.service.impl;

import com.discern.car.dao.CollectionMapper;
import com.discern.car.entity.Collection;
import com.discern.car.service.CollectionService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {

  @Autowired
  private static CollectionMapper collectionMapper;

  @Override
  public int insert(Collection collection) {
    return collectionMapper.insert(collection);
  }

  @Override
  public int delete(Integer userId,Integer issueId) {
    return collectionMapper.deleteByUserIdAndIssueId(userId, issueId);
  }

  @Override
  public List<Map<String, String>> selectIssueInfoByUserCollected(Integer userId) {
    return collectionMapper.selectIssueInfoByUserCollected(userId);
  }
}
