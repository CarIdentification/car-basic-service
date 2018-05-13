package com.discern.car.dao;

import com.discern.car.entity.SellShopInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellShopInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SellShopInfo record);

    int insertSelective(SellShopInfo record);

    SellShopInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellShopInfo record);

    int updateByPrimaryKey(SellShopInfo record);
}