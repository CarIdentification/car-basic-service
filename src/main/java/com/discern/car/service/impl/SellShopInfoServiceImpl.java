package com.discern.car.service.impl;

import com.discern.car.dao.SellShopInfoMapper;
import com.discern.car.entity.SellShopInfo;
import com.discern.car.service.SellShopInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Keben on 2018-05-10.
 */

@Service("sellShopInfoService")
public class SellShopInfoServiceImpl implements SellShopInfoService {


    @Resource
    private SellShopInfoMapper sellShopInfoMapper;

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
    public SellShopInfo selectByPrimaryKey(Integer id) {
        return sellShopInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SellShopInfo record) {
        return sellShopInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SellShopInfo record) {
        return sellShopInfoMapper.updateByPrimaryKey(record);
    }
}
