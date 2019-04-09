package com.discern.car.service;

import com.discern.car.dto.BrandDto;
import com.discern.car.entity.CarBrand;

import java.util.List;

/**
 * Created by Keben on 2018-06-06.
 */
public interface CarBrandService {

    int deleteByPrimaryKey(Integer id);

    int insert(CarBrand record);

    int insertSelective(CarBrand record);

    CarBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarBrand record);

    int updateByPrimaryKey(CarBrand record);

    List<CarBrand> selectFatherBrands();

    List<BrandDto> selectSonBrands(Integer id);

    List<CarBrand> selectAncestorsById(Integer id);

}
