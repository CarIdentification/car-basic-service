package com.discern.car.service.impl;

import com.discern.car.dao.SalesmanMapper;
import com.discern.car.dto.SalesmanDto;
import com.discern.car.entity.Salesman;
import com.discern.car.service.SalesmanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Keben on 2018-06-12.
 */
@Service("salesmanService")
public class SalesmanServiceImpl implements SalesmanService {

    @Resource
    SalesmanMapper salesmanMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return salesmanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Salesman record) {
        return salesmanMapper.insert(record);
    }

    @Override
    public int insertSelective(Salesman record) {
        return salesmanMapper.insertSelective(record);
    }

    @Override
    public Salesman selectByPrimaryKey(Integer id) {
        return salesmanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Salesman record) {
        return salesmanMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Salesman record) {
        return salesmanMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SalesmanDto> selectByBrandId(Integer id) {
        return salesmanMapper.selectByBrandId(id);
    }

}
