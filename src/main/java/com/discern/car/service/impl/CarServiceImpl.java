package com.discern.car.service.impl;

import com.discern.car.dao.CarMapper;
import com.discern.car.dto.CarDto;
import com.discern.car.entity.Car;
import com.discern.car.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Keben on 2018-06-09.
 */
@Service("carService")
public class CarServiceImpl implements CarService {

    @Resource
    private CarMapper carMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return carMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Car record) {
        return carMapper.insert(record);
    }

    @Override
    public int insertSelective(Car record) {
        return carMapper.insertSelective(record);
    }

    @Override
    public CarDto selectByPrimaryKey(Integer id) {
        return carMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Car record) {
        return carMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Car record) {
        return carMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Car record) {
        return carMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CarDto> selectByBrandId(Integer id,Integer pageNum) {
        return carMapper.selectByBrandId(id,pageNum*10);
    }

    @Override
    public List<Car> advancedSelect(Integer[] displacement, Integer[] structure, Integer[] level, Integer[] transmission, Integer[] country, Integer[] production_methods, Integer[] energy, Integer[] driving_method, Integer []seat, Float be_price, Float en_price) {
        return carMapper.advancedSelect(displacement, structure, level, transmission, country, production_methods,  energy,  driving_method, seat,  be_price, en_price);
    }

    @Override
    public List<Car> textSearch(String searchText) {
        return carMapper.textSearch("%"+searchText+"%");
    }
}
