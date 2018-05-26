package com.discern.car.controller;

import com.discern.car.config.RedisService;
import com.discern.car.dto.ResultDto;
import com.discern.car.entity.Car;
import com.discern.car.entity.Issue;
import com.discern.car.entity.SearchHistory;
import com.discern.car.entity.User;
import com.discern.car.service.SearchHistoryService;
import com.discern.car.util.LoginUtil;
import com.discern.car.util.OpenIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Keben on 2018-05-11.
 */

@RestController
@RequestMapping("/search")
public class searchController {



    @Resource
    private SearchHistoryService searchHistoryService;

    @Resource
    private LoginUtil loginUtil;
    /**
     * 文字搜索
     * @param searchContext
     * @return
     */
    @RequestMapping("/textSearch")
    public ResultDto textSearch(String searchContext,String signature){
        System.out.println("/textSearch");
        System.out.println("signature :"+signature);
        //保存搜索记录
        SearchHistory searchHistory = new SearchHistory();
        User user = loginUtil.cheakLogin(signature);
        if (user == null){
            return new ResultDto("fail","需要授予用户权限！");
        }
        searchHistory.setUserId(user.getId());
        searchHistory.setContent(searchContext);
        searchHistoryService.insertSelective(searchHistory);
        return new ResultDto("success","搜索记录添加成功");
    }

    /**
     *
     * @param signature 登陆状态
     * @return
     */
    @ResponseBody
    @RequestMapping("/textSearchHistory")
    public ResultDto textSearchHistory(String signature){
        System.out.println("/textSearchHistory : ");
        System.out.println("signature :"+signature);
        //获取用户登陆信息
        User user = loginUtil.cheakLogin(signature);
        if (user==null){
            return new ResultDto("fail","需要授予用户权限！");
        }else {
            List<SearchHistory> list = searchHistoryService.selectByUserId(user.getId());
            return new ResultDto("success",list);
        }

    }
}
