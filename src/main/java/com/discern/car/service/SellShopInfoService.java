package com.discern.car.service;

import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.dto.SaleShopDto;
import com.discern.car.entity.SellShopInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Keben on 2018-05-10.
 */
public interface SellShopInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(SellShopInfo record);

    int insertSelective(SellShopInfo record);

    SaleShopDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellShopInfo record);

    int updateByPrimaryKey(SellShopInfo record);

    List<SaleShopDto> selectAroundSellShopByBrandId(double latitude, double longitude,
        Integer brandId);

    List<SaleShopDto> selectAroundSellShopByLocation(double latitude, double longitude);

    PageResult<SaleShopDto> list(@Param("page") Page page);
}
