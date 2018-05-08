package com.discern.car.controller;

import com.discern.car.dto.ResultDto;
//import com.discern.car.entity.MapMarkers;
import com.discern.car.entity.User;
import com.discern.car.service.UserService;
import com.discern.car.util.OpenIdUtil;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Keben on 2018-05-04.
 */

@RestController
public class UserController {

    @Resource
    UserService userService;
    @Value("${server.port}")
    String port;

//    @RequestMapping("/getMarkers")
//    public ArrayList<MapMarkers> getMarkers(){
//        System.out.println("hhhhh");
//        ArrayList<MapMarkers> markers = new ArrayList<>();
//        markers.add(new MapMarkers(22.3497582742,113.5498809814));
//        markers.add(new MapMarkers(22.3536479905,113.5555458069));
//        return markers;
//
//    }

    @RequestMapping("/sendUserCode")
    public Map sendUserCode(String code){
        System.out.println(22);
        System.out.println(code);
//        System.out.println(OpenIdUtil.oauth2GetOpenid(code));
        return OpenIdUtil.oauth2GetOpenid(code);
    }

    @RequestMapping("/signUp")
    public ResultDto signUp(@RequestParam User user){
        userService.insert(user);
        System.out.println(111);
        return new ResultDto("success",user);
    }


    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
}
