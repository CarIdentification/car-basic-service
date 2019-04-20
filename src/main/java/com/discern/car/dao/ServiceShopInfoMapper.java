package com.discern.car.dao;

import com.discern.car.dto.IssueDto;
import com.discern.car.entity.SellShopInfo;
import com.discern.car.entity.ServiceShopInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServiceShopInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceShopInfo record);

    int insertSelective(ServiceShopInfo record);

    ServiceShopInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceShopInfo record);

    int updateByPrimaryKey(ServiceShopInfo record);
}