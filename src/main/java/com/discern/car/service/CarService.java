package com.discern.car.service;

import com.discern.car.dto.CarDto;
import com.discern.car.entity.Car;

import java.util.List;

/**
 * Created by Keben on 2018-06-09.
 */
public interface CarService {

    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    CarDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKeyWithBLOBs(Car record);

    int updateByPrimaryKey(Car record);

    List<CarDto> selectByBrandId(Integer id);
    List<Car> advancedSelect(Integer[] displacement,Integer[] structure,Integer[] level,Integer[] transmission,Integer[] country,Integer[] production_methods,Integer[] energy,Integer[] driving_method,Integer []seat,Float be_price,Float en_price);

}
