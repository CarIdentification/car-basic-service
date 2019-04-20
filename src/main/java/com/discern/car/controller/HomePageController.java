package com.discern.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类描述 :
 *
 * @Author JoeyTsai
 * @Time 12/04/2019
 */
@Controller
@RequestMapping("/")
public class HomePageController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }


    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String article() {
        return "article.html";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return "user.html";
    }


    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public String userInfo() {
        return "/usermanage/carList";
    }
}
