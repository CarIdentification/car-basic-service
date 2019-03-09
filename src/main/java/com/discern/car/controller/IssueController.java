package com.discern.car.controller;

import com.discern.car.entity.Issue;
import com.discern.car.entity.User;
import com.discern.car.service.IssueService;
import com.discern.car.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by a on 2018/5/26.
 */
@RestController
public class IssueController {

    @Autowired
    private IssueService issueService;

    @Resource
    private LoginUtil loginUtil;

    @RequestMapping("/getHotIssue")
    public List<Issue> getHotIssue(){
        List<Issue> issues = issueService.selectByHot();
        return issues;
    }
    @RequestMapping("/getIssue")
    public Issue getIssue(String id){
        Issue issue = issueService.selectByPrimaryKey(Integer.parseInt(id));
        return issue;
    }
    @RequestMapping("/getRecommendIssue")
    public List<Issue> getRecommendIssue(String signature){
        User user = loginUtil.cheakLogin(signature);
        List<Issue> issues = issueService.selectRecommendIssue(user.getId());
        return issues;
    }


}
