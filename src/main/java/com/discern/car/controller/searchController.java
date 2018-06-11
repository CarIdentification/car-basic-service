package com.discern.car.controller;

import com.discern.car.config.RedisService;
import com.discern.car.dao.CarBrandMapper;
import com.discern.car.dto.BrandDto;
import com.discern.car.dto.CarDto;
import com.discern.car.dto.ResultDto;
import com.discern.car.entity.*;
import com.discern.car.service.CarBrandService;
import com.discern.car.service.CarService;
import com.discern.car.service.SearchHistoryService;
import com.discern.car.util.ChineseCharToEn;
import com.discern.car.util.LoginUtil;
import com.discern.car.util.OpenIdUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Keben on 2018-05-11.
 */

@RestController
@RequestMapping("/search")
public class searchController {



    @Resource
    private SearchHistoryService searchHistoryService;

    @Resource
    private LoginUtil loginUtil;

    @Resource
    private CarBrandService carBrandService;

    @Resource
    private ChineseCharToEn chineseCharToEn;

    @Resource
    private CarService carService;
    /**
     * 文字搜索
     * @param searchContext
     * @return
     */
    @RequestMapping("/textSearch")
    public ResultDto textSearch(String searchContext,String signature){
        System.out.println("/textSearch");
        System.out.println("signature :"+signature);
        //保存搜索记录
        SearchHistory searchHistory = new SearchHistory();
        User user = loginUtil.cheakLogin(signature);
        if (user == null){
            return new ResultDto("fail","需要授予用户权限！");
        }
        searchHistory.setUserId(user.getId());
        searchHistory.setContent(searchContext);
        searchHistoryService.insertSelective(searchHistory);
        return new ResultDto("success","搜索记录添加成功");
    }

    /**
     *
     * @param signature 登陆状态
     * @return
     */
    @ResponseBody
    @RequestMapping("/textSearchHistory")
    public ResultDto textSearchHistory(String signature){
        System.out.println("/textSearchHistory : ");
        System.out.println("signature :"+signature);
        //获取用户登陆信息
        User user = loginUtil.cheakLogin(signature);
        if (user==null){
            return new ResultDto("fail","需要授予用户权限！");
        }else {
            List<SearchHistory> list = searchHistoryService.selectByUserId(user.getId());
            return new ResultDto("success",list);
        }

    }

    /**
     * 高级搜索
     * @param displacement
     * @param structure
     * @param level
     * @param be_price
     * @param en_price
     * @return
     */
    @RequestMapping(value = "/advancedSearch",method = RequestMethod.POST)
    public ResultDto advancedSearch(@RequestParam(value = "displacement") Integer[] displacement,@RequestParam(value = "structure") Integer[] structure,@RequestParam(value = "level") Integer[] level,@RequestParam(value = "be_price") Integer be_price,@RequestParam(value = "en_price") Integer en_price){
        System.out.println(level);
        System.out.println(structure);
        return new ResultDto("success",1);
    }

    /**
     * 提供第一层品牌
     * @return
     */
    @RequestMapping(value = "/getBrands",method = RequestMethod.GET)
    public ResultDto getBrands(){
        System.out.println("/getBrands : ");

        List<CarBrand> list = carBrandService.selectFatherBrands();
        Map map =new HashMap();
        for (int i = 0 ; i < 24 ; i++ ){
            map.put((char)(65+i),new ArrayList<CarBrand>());
        }

        for (CarBrand carBrand : list){
            char c = chineseCharToEn.getFirstLetter(carBrand.getName()).charAt(0);
            ((List<CarBrand>)map.get((char)(c-32))).add(carBrand);

        }
        return new ResultDto("success",map);

    }

    /**
     * 获取单个品牌的信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBrand",method = RequestMethod.GET)
    public ResultDto getBrand(Integer id){
        CarBrand carBrand = carBrandService.selectByPrimaryKey(id);
        return new ResultDto("success",carBrand);
    }

    /**
     * 提供一层品牌以下的二层品牌与三层品牌
     * @param id
     * @return
     */
    @RequestMapping(value = "/getSonBrands",method = RequestMethod.GET)
    public ResultDto getSonBrands(Integer id){
        System.out.println("/getBrands : ");
        List<BrandDto> list = carBrandService.selectSonBrands(id);
        return new ResultDto("success",list);
    }

    /**
     * 提供第三层品牌以下的所有汽车
     * @param id
     * @return
     */
    @RequestMapping(value = "/getCars",method = RequestMethod.GET)
    public ResultDto getCars(Integer id){
        System.out.println("/getCars : ");
        List<Car> list = carService.selectByBrandId(id);
        return new ResultDto("success",list);
    }

    /**
     * 获取车信息
     */
    @RequestMapping(value = "/getCar",method = RequestMethod.GET)
    public ResultDto getCar(Integer id){
        CarDto car = carService.selectByPrimaryKey(id);
        return new ResultDto("success",car);
    }
}
