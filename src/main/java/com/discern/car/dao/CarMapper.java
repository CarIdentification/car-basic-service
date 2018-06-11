package com.discern.car.dao;

import com.discern.car.dto.CarDto;
import com.discern.car.entity.Car;

import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    CarDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKeyWithBLOBs(Car record);

    int updateByPrimaryKey(Car record);

    List<Car> selectByBrandId(Integer id);
}