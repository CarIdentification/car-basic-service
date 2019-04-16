package com.discern.car.controller;

import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.dto.ResultDto;
import com.discern.car.entity.Issue;
import com.discern.car.entity.User;
import com.discern.car.service.IssueService;
import com.discern.car.util.BeanUtil;
import com.discern.car.util.LoginUtil;
import java.util.List;
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

    @RequestMapping("/getHotIssue")
    public List<Issue> getHotIssue() {
        List<Issue> issues = issueService.selectByHot();
        return issues;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult<Issue> list(Page page) {
        PageResult<Issue> result = issueService.list(page);
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
    public ResultDto add(Issue issue) {
        issueService.insert(issue);
        return ResultDto.OK;
    }

    @RequestMapping("/delete")
    public ResultDto delete(Integer id) {
        issueService.deleteByPrimaryKey(id);
        return ResultDto.OK;
    }

    @RequestMapping("/get")
    public ResultDto get(Integer id) {
        Issue issue = issueService.selectByPrimaryKey(id);
        return new ResultDto(ResultDto.OK.getStateInfo(), issue);
    }

    @RequestMapping("/update")
    public ResultDto update(Issue issue) {
        issueService.updateByPrimaryKeySelective(issue);
        return ResultDto.OK;
    }
}
