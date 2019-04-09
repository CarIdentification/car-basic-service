package com.discern.car.dao;

import com.discern.car.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByOpenId(String openId);

    // 添加拥有车型
    int addOwnCar();

    // 删除拥有车型

    // 获取拥有车型
}