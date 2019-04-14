package com.discern.car.service;

import com.discern.car.dto.SalesmanDto;
import com.discern.car.entity.Salesman;

import java.util.List;

/**
 * Created by Keben on 2018-06-12.
 */
public interface SalesmanService {
    int deleteByPrimaryKey(Integer id);

    int insert(Salesman record);

    int insertSelective(Salesman record);

    Salesman selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salesman record);

    int updateByPrimaryKey(Salesman record);

    List<SalesmanDto> selectByBrandId(Integer id);
}
