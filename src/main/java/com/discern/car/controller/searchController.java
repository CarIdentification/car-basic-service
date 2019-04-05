package com.discern.car.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.discern.car.config.RedisService;
import com.discern.car.dao.CarBrandMapper;
import com.discern.car.dto.BrandDto;
import com.discern.car.dto.CarDto;
import com.discern.car.dto.ResultDto;
import com.discern.car.dto.SalesmanDto;
import com.discern.car.entity.*;
import com.discern.car.service.*;
import com.discern.car.util.ChineseCharToEn;
import com.discern.car.util.ImageUtil;
import com.discern.car.util.LoginUtil;
import com.discern.car.util.OpenIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Array;
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


    @Autowired
    private IssueService issueService;

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

    @Resource
    private SalesmanService salesmanService;

    @Resource
    private RedisService redisService ;

    @Resource
    private SearchHistoryPicService searchHistoryPicService;

    @Value("${img.location}")
    private String location;

    @RequestMapping(value = "/pictureDiscern",method = RequestMethod.POST)
    public ResultDto pictureDiscern(@RequestParam("file") MultipartFile multipartFile, String signature, int serial, int last){
        User user = loginUtil.cheakLogin(signature);
        if (multipartFile.isEmpty()) {
            return new ResultDto("fail","图片不存在！");
        }else {
            try {
                String filePath = new ImageUtil().saveImg(multipartFile,location);
                SearchHistoryPic searchHistoryPic = null;
                switch (serial){
                    case 0:
                        searchHistoryPic = new SearchHistoryPic();
                        searchHistoryPic.setUserId(user.getId());
                        searchHistoryPic.setPic1(location+"\\"+filePath);
                        redisService.set(signature+"Pic",searchHistoryPic,new Long(1800));
                        System.out.println("first pic");
                        break;
                    case 1:
                        searchHistoryPic = (SearchHistoryPic)redisService.get(signature+"Pic");
                        searchHistoryPic.setPic2(location+"\\"+filePath);
                        redisService.set(signature+"Pic",searchHistoryPic,new Long(1800));
                        System.out.println("second pic");
                        break;
                    case 2:
                        searchHistoryPic = (SearchHistoryPic)redisService.get(signature+"Pic");
                        searchHistoryPic.setPic3(location+"\\"+filePath);
                        redisService.set(signature+"Pic",searchHistoryPic,new Long(1800));
                        System.out.println("third pic");
                        break;
                }
                if (last==1){
                    searchHistoryPicService.insertSelective(searchHistoryPic);
                    System.out.println("discern!");
                    //调用图像识别api，将图片路径作为参数
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<CarDto> carList = null;
            carList = carService.selectByBrandId(9,1);
            return new ResultDto("success",carList);
        }


    }
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
        //添加搜索记录
        searchHistory.setUserId(user.getId());
        searchHistory.setContent(searchContext);
        searchHistoryService.insertSelective(searchHistory);
        //获取搜索结果
        List<Car> list = carService.textSearch(searchContext);
        Map<String ,Object> map = new HashMap<>();
        map.put("carList",list);
        map.put("issue",issueService.selectByTextSearch(searchContext));
        return new ResultDto("success",map);
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
    public ResultDto advancedSearch(@RequestParam(value = "displacement",required = false) Integer[] displacement,@RequestParam(value = "structure",required = false) Integer[] structure,@RequestParam(value = "level",required = false) Integer[] level,@RequestParam(value = "Transmission",required = false) Integer[] transmission,@RequestParam(value = "country",required = false) Integer[] country,@RequestParam(value = "production_methods",required = false) Integer[] production_methods,@RequestParam(value = "energy",required = false) Integer[] energy,@RequestParam(value = "driving_method",required = false) Integer[] driving_method,@RequestParam(value = "seat",required = false) Integer[] seat,@RequestParam(value = "be_price",required = false) Float be_price,@RequestParam(value = "en_price",required = false) Float en_price){
        System.out.println(level);
        System.out.println(structure);
        List<Car> list = carService.advancedSelect(displacement, structure, level, transmission, country, production_methods,  energy,  driving_method, seat,  be_price, en_price);

        return new ResultDto("success",list);
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
    public ResultDto getCars(Integer id,Integer pageNum){
        System.out.println("/getCars : ");
        List<CarDto> list = carService.selectByBrandId(id,pageNum);
        Map<String,Object> map = new HashMap<>();
        map.put("cars",list);
        if (list.size()!=0){
            pageNum++;
        }else {
            pageNum=-1;
        }
        map.put("pageNum",pageNum);
        return new ResultDto("success",map);
    }

    /**
     * 获取车信息
     */
    @RequestMapping(value = "/getCar",method = RequestMethod.GET)
    public ResultDto getCar(@RequestParam(name = "ids", required = true) String idArrayString){
        JSONArray jsonArray = JSON.parseArray(idArrayString);
        List<CarDto> carDtoArrayList;
        List<Integer> ids = new ArrayList<>();
        for(int i = 0;i < jsonArray.size();i++){
            ids.add(jsonArray.getIntValue(i));
        }
        carDtoArrayList = carService.selectByPrimaryKeys(ids);
        return new ResultDto("success",carDtoArrayList);
    }

    /**
     * 获取指定车型的销售人员
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/getSalesman",method = RequestMethod.GET)
    public ResultDto getSalesman(Integer brandId){
        List<SalesmanDto> list = salesmanService.selectByBrandId(brandId);
        return new ResultDto("success",list);
    }
}
