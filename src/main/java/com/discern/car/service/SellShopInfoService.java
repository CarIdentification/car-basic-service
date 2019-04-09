package com.discern.car.service;

import com.discern.car.dto.SaleShopDto;
import com.discern.car.entity.SellShopInfo;

import java.util.List;

/**
 * Created by Keben on 2018-05-10.
 */
public interface SellShopInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(SellShopInfo record);

    int insertSelective(SellShopInfo record);

    SellShopInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellShopInfo record);

    int updateByPrimaryKey(SellShopInfo record);

    List<SaleShopDto> selectAroundSellShopByBrandId(double latitude, double longitude,
        Integer brandId);
}
