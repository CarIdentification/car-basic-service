package com.discern.car.util;

import com.discern.car.config.RedisService;
import com.discern.car.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Keben on 2018-05-21.
 */
@Service("loginUtil")
public class LoginUtil {

    @Resource
    private RedisService redisService ;

    public User cheakLogin(String signature){
        Object loginSign = redisService.get(signature);
        if (loginSign == null ){
            return null;
        }else {
            return (User)redisService.get(signature);
        }
    }
}
