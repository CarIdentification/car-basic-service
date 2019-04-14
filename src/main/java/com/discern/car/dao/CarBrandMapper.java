package com.discern.car.dao;

import com.discern.car.dto.BrandDto;
import com.discern.car.entity.CarBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarBrand record);

    int insertSelective(CarBrand record);

    CarBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarBrand record);

    int updateByPrimaryKey(CarBrand record);

    List<CarBrand> selectFatherBrands();

    List<BrandDto> selectSonBrands(Integer id);
}