package com.discern.car.dao;

import com.discern.car.entity.Salesman;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalesmanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salesman record);

    int insertSelective(Salesman record);

    Salesman selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salesman record);

    int updateByPrimaryKey(Salesman record);
}