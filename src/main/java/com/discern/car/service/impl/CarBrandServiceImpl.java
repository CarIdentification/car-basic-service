package com.discern.car.service.impl;

import com.discern.car.dao.CarBrandMapper;
import com.discern.car.dto.BrandDto;
import com.discern.car.entity.CarBrand;
import com.discern.car.service.CarBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Keben on 2018-06-06.
 */

@Service("carBrandService")
public class CarBrandServiceImpl implements CarBrandService {

    @Resource
    private CarBrandMapper carBrandMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return carBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CarBrand record) {
        return carBrandMapper.insert(record);
    }

    @Override
    public int insertSelective(CarBrand record) {
        return carBrandMapper.insertSelective(record);
    }

    @Override
    public CarBrand selectByPrimaryKey(Integer id) {
        return carBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CarBrand record) {
        return carBrandMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CarBrand record) {
        return carBrandMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CarBrand> selectFatherBrands() {
        return carBrandMapper.selectFatherBrands();
    }

    @Override
    public List<BrandDto> selectSonBrands(Integer id) {
        return carBrandMapper.selectSonBrands(id);
    }
}
