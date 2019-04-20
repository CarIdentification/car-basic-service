package com.discern.car.dao;

import com.discern.car.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

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
    int addOwnCar(@Param("carId")int carId, @Param("userId")int userId);

    // 删除拥有车型
    int delOwnCar(@Param("carId")int carId , @Param("userId")int userId);

    // 获取拥有车型
    List<Integer> getOwnCar(@Param("userId")int userId);

    // 某辆车是否在车库里
    int haveCar(@Param("carId")int carId, @Param("userId")int userId);

    List<User> selectPagination(@Param("limit")int limit, @Param("offset")int offset);

    int selectCount();
}