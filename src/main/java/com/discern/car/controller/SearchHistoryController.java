package com.discern.car.controller;

import com.discern.car.dto.ResultDto;
import com.discern.car.entity.SearchHistory;
import com.discern.car.entity.User;
import com.discern.car.service.SearchHistoryService;
import com.discern.car.util.LoginUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述 :
 *
 * @Author JoeyTsai
 * @Time 11/04/2019
 */
@RestController
@RequestMapping("/searchHistory")
public class SearchHistoryController {
    @Autowired
    private SearchHistoryService searchHistoryService;
    @Autowired
    private LoginUtil loginUtil;
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public ResultDto list(String signature) {
        User user = loginUtil.cheakLogin(signature);
        if (user.getId() == 0) {
            return new ResultDto(ResultDto.OK.getStateInfo(), null);
        }
        List<SearchHistory> searchHistories = searchHistoryService.selectByUserId(user.getId());
        return new ResultDto(ResultDto.OK.getStateInfo(), searchHistories);
    }
}
