package com.discern.car.dao;

import com.discern.car.dto.CarDto;
import com.discern.car.entity.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    CarDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKeyWithBLOBs(Car record);

    int updateByPrimaryKey(Car record);

    List<CarDto> selectByBrandId(@Param("id") Integer id,@Param("pageNum") Integer pageNum);

    List<Car> advancedSelect(@Param("displacement") Integer[] displacement,@Param("structure") Integer[] structure, @Param("level") Integer[] level,@Param("transmission")Integer[] transmission, @Param("country")Integer[] country,@Param("production_methods") Integer[] production_methods, @Param("energy")Integer[] energy, @Param("driving_method")Integer[] driving_method,@Param("seat") Integer[] seat, @Param("be_price") Float be_price,@Param("en_price") Float en_price);

    List<Car> textSearch(@Param("searchText")String searchText);

    List<Car> selectList();
}