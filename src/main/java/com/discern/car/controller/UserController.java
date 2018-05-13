package com.discern.car.controller;

import com.discern.car.dto.ResultDto;

import com.discern.car.entity.Tag;
import com.discern.car.entity.User;
import com.discern.car.service.TagService;
import com.discern.car.service.UserService;
import com.discern.car.util.OpenIdUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;

/**
 * Created by Keben on 2018-05-04.
 */

@RestController
@RequestMapping("/personal")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private TagService tagService;
    @Value("${server.port}")
    private String port;

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
    public ResultDto sendUserCode(String code,User user,HttpSession session){
        System.out.println(code);
//        System.out.println(OpenIdUtil.oauth2GetOpenid(code));
        Map map = OpenIdUtil.oauth2GetOpenid(code);
        User u = userService.selectByOpenId(map.get("openid" ).toString());
        System.out.println(u);

        //如果还没登陆过，则将用户信息存入数据库
        if (u==null){
            user.setOpenid(map.get("openid" ).toString());
            userService.insertSelective(user);
        }
        u = userService.selectByOpenId(map.get("openid" ).toString());

        System.out.println(u.toString());
        //在session中保存用户登陆状态
        session.setAttribute("user",u);
        System.out.println("sessionId      " + session.getId());
        return new ResultDto("success",u);
    }

    /**
     * 查询tag
     * @param
     * @return
     */
    @RequestMapping(value="/tag",method= RequestMethod.GET)
    public ResultDto tag(HttpSession session){
        System.out.println("sessionId      " + session.getId());
        User user = (User)session.getAttribute("user");
        System.out.println(user.getId());
        List<Tag> list = tagService.selectByUserId(user.getId());
        return new ResultDto("success",list);
    }

    @RequestMapping(value="/tag/{brandName}",method= RequestMethod.POST)
    public ResultDto tag(@PathVariable("brandName") String brandName){
        Tag tag = new Tag();
        tag.setBrandName(brandName);
        tagService.insertSelective(tag);
        return new ResultDto("success",tag);
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
