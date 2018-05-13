package com.discern.car.dao;

import com.discern.car.entity.CarBrand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarBrand record);

    int insertSelective(CarBrand record);

    CarBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarBrand record);

    int updateByPrimaryKey(CarBrand record);
}