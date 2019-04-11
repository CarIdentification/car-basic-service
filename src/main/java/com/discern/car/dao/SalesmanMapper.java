package com.discern.car.dao;

import com.discern.car.dto.SalesmanDto;
import com.discern.car.entity.Salesman;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesmanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salesman record);

    int insertSelective(Salesman record);

    Salesman selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salesman record);

    int updateByPrimaryKey(Salesman record);

    List<SalesmanDto> selectByBrandId(Integer brandId);

    List<SalesmanDto> selectByShopId(Integer shopId);
}