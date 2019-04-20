package com.discern.car.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.dao.SalesmanMapper;
import com.discern.car.dao.SellShopInfoMapper;
import com.discern.car.dto.SaleShopDto;
import com.discern.car.dto.SalesmanDto;
import com.discern.car.entity.Salesman;
import com.discern.car.entity.SellShopInfo;
import com.discern.car.service.SellShopInfoService;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keben on 2018-05-10.
 */

@Service("sellShopInfoService")
public class SellShopInfoServiceImpl implements SellShopInfoService {


    @Resource
    private SellShopInfoMapper sellShopInfoMapper;

    @Resource
    private SalesmanMapper salesmanMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sellShopInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SellShopInfo record) {
        return sellShopInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(SellShopInfo record) {
        return sellShopInfoMapper.insertSelective(record);
    }

    @Override
    public SaleShopDto selectByPrimaryKey(Integer id) {
        SaleShopDto shopDto = sellShopInfoMapper.selectByPrimaryKey(id);
        List<SalesmanDto> salesmen = salesmanMapper.selectByShopId(shopDto.getId());
        shopDto.setSalesMan(salesmen);
        return shopDto;
    }

    @Override
    public int updateByPrimaryKeySelective(SellShopInfo record) {
        return sellShopInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SellShopInfo record) {
        return sellShopInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SaleShopDto> selectAroundSellShopByBrandId(double latitude, double longitude,
        Integer brandId) {
        return sellShopInfoMapper.selectAroundSellShopByBrandId(latitude, longitude, brandId);
    }

    @Override
    public List<SaleShopDto> selectAroundSellShopByLocation(double latitude, double longitude) {
        List<SaleShopDto> shops = sellShopInfoMapper.selectAroundSellShopByLocation(latitude,longitude);
        for (SaleShopDto shop : shops) {
            List<SalesmanDto> salesmen = salesmanMapper.selectByShopId(shop.getId());
            shop.setSalesMan(salesmen);
        }
        return shops;
    }

    @Override
    public PageResult<SellShopInfo> list(Page page) {
        List<SellShopInfo> sellShopInfos = sellShopInfoMapper.list((page.getPage()-1)*page.getLimit(),page.getLimit());
        Integer count = sellShopInfoMapper.selectCount();
        page.setCount(count);
        return PageResult.newSuccess(page, sellShopInfos);
    }
}
