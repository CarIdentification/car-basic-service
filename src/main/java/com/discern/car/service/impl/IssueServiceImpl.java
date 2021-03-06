package com.discern.car.service.impl;

import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.dao.IssueMapper;
import com.discern.car.dto.IssueDto;
import com.discern.car.entity.Issue;
import com.discern.car.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by a on 2018/5/17.
 */
@Service("issueService")
public class IssueServiceImpl implements IssueService{
    @Autowired
    private IssueMapper issueMapper;

    public int deleteByPrimaryKey(Integer id){
        return issueMapper.deleteByPrimaryKey(id);
    }

    public int insert(Issue record){
        return issueMapper.insert(record);
    }

    public int insertSelective(Issue record){
        return issueMapper.insertSelective(record);
    }

    public Issue selectByPrimaryKey(Integer id){
        return issueMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Issue record){
        return issueMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKeyWithBLOBs(Issue record){
        return issueMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int updateByPrimaryKey(Issue record){
        return issueMapper.updateByPrimaryKey(record);
    }

    public List<Issue> selectByHot(){
        return issueMapper.selectByHot();
    }

    @Override
    public List<Issue> selectRecommendIssue(Integer userId) {
        return issueMapper.selectRecommendIssue(userId);
    }

    @Override
    public List<Issue> selectByTextSearch(String textSearch) {
        return issueMapper.selectByTextSearch("%"+textSearch+"%");
    }

    @Override
    public PageResult<IssueDto> list(Page page) {
        List<IssueDto> issues = issueMapper.list((page.getPage()-1)*page.getLimit(),page.getLimit());
        Integer count = issueMapper.selectCount();
        page.setCount(count);
        return PageResult.newSuccess(page, issues);
    }

    @Override
    public int updateViewCountByPrimaryKey(Integer primaryKey) {
        return issueMapper.updateViewCountByPrimaryKey(primaryKey);
    }
}
