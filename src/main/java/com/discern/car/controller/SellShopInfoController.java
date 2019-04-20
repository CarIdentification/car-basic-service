package com.discern.car.controller;

import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.common.Result;
import com.discern.car.dto.SaleShopDto;
import com.discern.car.entity.SellShopInfo;
import com.discern.car.entity.Tag;
import com.discern.car.service.SellShopInfoService;
import com.discern.car.service.TagService;
import com.discern.car.util.BeanUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：d
 * @date ：Created in 2019/4/12
 * @description：
 */

@RestController
@RequestMapping("/sellShopInfo")
public class SellShopInfoController {

    @Autowired
    private SellShopInfoService sellShopInfoService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(Integer id) {
        sellShopInfoService.deleteByPrimaryKey(id);
        return Result.newSuccess();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult<SellShopInfo> list(Page page) {
        PageResult<SellShopInfo> result = sellShopInfoService.list(page);
        return result;
    }

    @RequestMapping(value = "/merge", method = RequestMethod.POST)
    public Result<SaleShopDto> merge(SellShopInfo sellShopInfo) {
        Integer id;
        if (sellShopInfo.getId() == null || sellShopInfo.getId() == 0) {
            sellShopInfoService.insertSelective(sellShopInfo);
        } else {
            sellShopInfoService.updateByPrimaryKeySelective(sellShopInfo);
        }
        id = sellShopInfo.getId();
        return Result.newSuccess(sellShopInfoService.selectByPrimaryKey(id));
    }
}
