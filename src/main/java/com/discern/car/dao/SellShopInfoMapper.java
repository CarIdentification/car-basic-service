package com.discern.car.dao;

import com.discern.car.dto.SaleShopDto;
import com.discern.car.entity.SellShopInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellShopInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SellShopInfo record);

    int insertSelective(SellShopInfo record);

    SaleShopDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellShopInfo record);

    int updateByPrimaryKey(SellShopInfo record);

    List<SaleShopDto> selectAroundSellShopByBrandId(@Param("latitude") double latitude,@Param("longitude") double longitude,
        @Param("brandId") Integer brandId);

    List<SaleShopDto> selectAroundSellShopByLocation(@Param("latitude") double latitude,@Param("longitude") double longitude);

    Integer selectCount();

    List<SaleShopDto> list(@Param("offset") Integer offset, @Param("limit")Integer limit);
}