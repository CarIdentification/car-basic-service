package com.discern.car.service;

import com.discern.car.entity.User;

/**
 * Created by Keben on 2018-05-04.
 */
public interface UserService{
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
