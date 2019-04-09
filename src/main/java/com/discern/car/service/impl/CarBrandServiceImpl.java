package com.discern.car.service.impl;

import com.discern.car.dao.CarBrandMapper;
import com.discern.car.dto.BrandDto;
import com.discern.car.entity.CarBrand;
import com.discern.car.service.CarBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public List<CarBrand> selectAncestorsById(Integer id) {
        List<CarBrand> ancestors = new ArrayList<>();
        int currId = id;
        for (;true;){
            CarBrand carBrand = carBrandMapper.selectByPrimaryKey(currId);
            ancestors.add(carBrand);
            if (carBrand.getPid()==0) {
                break;
            }
            currId = carBrand.getPid();
        }

        if (ancestors.size()>0){
            for (int i=ancestors.size();i<3;i++){
                ancestors.add(0,ancestors.get(0));
            }
        }

        // swap
        CarBrand temp = ancestors.get(0);
        ancestors.set(0,ancestors.get(2));
        ancestors.set(2,temp);

        return ancestors;
    }

}
