package com.discern.car.controller;

import com.discern.car.dto.ResultDto;
import com.discern.car.entity.Collection;
import com.discern.car.entity.User;
import com.discern.car.service.CollectionService;
import com.discern.car.util.LoginUtil;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangzhuodong on 2019/04.
 */
@RestController
@RequestMapping("/collection")
public class CollectionController {

  @Resource
  private LoginUtil loginUtil;

  @Autowired
  private CollectionService collectionService;


  @RequestMapping("/add")
  public ResultDto addCollection(String signature, Integer issueId) {
    if (signature == null || issueId == null) {
      return ResultDto.ERR_PARAM;
    }
    User user = loginUtil.cheakLogin(signature);
    if (user == null) {
      return ResultDto.NEED_LOGIN;
    }
    Collection collection = new Collection();
    collection.setUserId(user.getId());
    collection.setIssueId(issueId);
    int rs = collectionService.insert(collection);
    if (rs == 1) {
      return ResultDto.OK;
    } else {
      return ResultDto.FAIL;
    }
  }

  @RequestMapping("/delete")
  public ResultDto deleteCollection(String signature, Integer issueId) {
    if (signature == null || issueId == null) {
      return ResultDto.ERR_PARAM;
    }
    User user = loginUtil.cheakLogin(signature);
    if (user == null) {
      return ResultDto.NEED_LOGIN;
    }
    int rs = collectionService.delete(user.getId(),issueId);
    if (rs == 1) {
      return ResultDto.OK;
    } else {
      return ResultDto.FAIL;
    }
  }

  @RequestMapping("/list")
  public ResultDto userCollectionInfo(String signature) {
    if (signature == null) {
      return ResultDto.ERR_PARAM;
    }
    User user = loginUtil.cheakLogin(signature);
    if (user == null) {
      return ResultDto.NEED_LOGIN;
    }
    List<Map<String,String>> collects =
        collectionService.selectIssueInfoByUserCollected(user.getId());
    return new ResultDto("ok",collects);
  }
}
