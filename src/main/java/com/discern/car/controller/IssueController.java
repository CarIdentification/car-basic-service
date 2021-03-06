package com.discern.car.controller;

import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.common.Result;
import com.discern.car.dao.IssueMapper;
import com.discern.car.dto.IssueDto;
import com.discern.car.dto.ResultDto;
import com.discern.car.entity.Issue;
import com.discern.car.entity.User;
import com.discern.car.service.IssueService;
import com.discern.car.util.BeanUtil;
import com.discern.car.util.LoginUtil;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by a on 2018/5/26.
 */
@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    private IssueService issueService;
    @Resource
    private LoginUtil loginUtil;
    @Autowired
    private IssueMapper issueMapper;

    @RequestMapping("/getHotIssue")
    public List<Issue> getHotIssue() {
        List<Issue> issues = issueService.selectByHot();
        return issues;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult<IssueDto> list(Page page) {
        PageResult<IssueDto> result = issueService.list(page);
        return result;
    }

    @RequestMapping("/getIssue")
    public Issue getIssue(String id) {
        Issue issue = issueService.selectByPrimaryKey(Integer.parseInt(id));
        issueService.updateViewCountByPrimaryKey(issue.getId());
        return issue;
    }

    @RequestMapping("/getRecommendIssue")
    public List<Issue> getRecommendIssue(String signature) {
        User user = loginUtil.cheakLogin(signature);
        List<Issue> issues = issueService.selectRecommendIssue(user.getId());
        return issues;
    }

    @RequestMapping("/add")
    public Result add(Issue issue) {
        issueService.insert(issue);
        return Result.newSuccess();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(Integer id) {
        issueService.deleteByPrimaryKey(id);
        issueMapper.deleteIssueTag(id);
        return Result.newSuccess();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<Issue> get(Integer id) {
        Issue issue = issueService.selectByPrimaryKey(id);
        return Result.newSuccess(issue);
    }

    @RequestMapping("/update")
    public Result update(Issue issue) {
        issueService.updateByPrimaryKeySelective(issue);
        return Result.newSuccess();
    }

    @RequestMapping(value = "/merge", method = RequestMethod.POST)
    public Result<IssueDto> merge(Issue issue,String tagId) {
        Integer id;
        if (issue.getId() == null || issue.getId() == 0) {
            id = issueService.insert(issue);
            if (Integer.parseInt(tagId)!=0){
                issueMapper.insertIssueTag(id,Integer.parseInt(tagId));
            }
        } else {
            issueService.updateByPrimaryKeySelective(issue);
            if (Integer.parseInt(tagId)!=0){
                issueMapper.updateIssueTag(issue.getId(),Integer.parseInt(tagId));
            }
        }
        id = issue.getId();
        return Result.newSuccess(issueMapper.selectByPrimaryKeyWithTag(id));
    }
}
