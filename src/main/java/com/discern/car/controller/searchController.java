package com.discern.car.controller;

import com.discern.car.dto.ResultDto;
import com.discern.car.entity.Car;
import com.discern.car.entity.Issue;
import com.discern.car.entity.SearchHistory;
import com.discern.car.service.SearchHistoryService;
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
    /**
     * 文字搜索
     * @param searchContext
     * @return
     */
    @RequestMapping("/textSearch")
    public ResultDto textSearch(String searchContext){
        ArrayList<Object> lists = new ArrayList<>();
        ArrayList<Car> car  = new ArrayList<>();
        ArrayList<Issue> issue = new ArrayList<>();
        lists.add(car);
        lists.add(issue);
        //保存搜索记录
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setUserId(1);
        searchHistory.setContent(searchContext);
        searchHistoryService.insertSelective(searchHistory);
        return new ResultDto("success",lists);
    }
    @ResponseBody
    @RequestMapping("/textSearchHistory")
    public ResultDto textSearchHistory(int userId){
        List<SearchHistory> list = searchHistoryService.selectByUserId(userId);
        return new ResultDto("success",list);
    }
}
