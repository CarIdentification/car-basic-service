package com.discern.car.dao;

import com.discern.car.entity.CarPic;

public interface CarPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPic record);

    int insertSelective(CarPic record);

    CarPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPic record);

    int updateByPrimaryKey(CarPic record);
}