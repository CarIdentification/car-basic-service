package com.discern.car.controller;

import com.discern.car.dto.ResultDto;
import com.discern.car.entity.User;
import com.discern.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Keben on 2018-05-04.
 */

@RestController
public class UserController {

    @Resource
    UserService userService;
    @Value("${server.port}")
    String port;

    @RequestMapping("/signUp")
    public ResultDto signUp(@RequestParam User user){
        userService.insert(user);
        return new ResultDto("success",user);
    }


    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
}
