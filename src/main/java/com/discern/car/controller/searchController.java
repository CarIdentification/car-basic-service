package com.discern.car.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.discern.car.config.RedisService;
import com.discern.car.dto.*;
import com.discern.car.entity.Car;
import com.discern.car.entity.CarBrand;
import com.discern.car.entity.SearchHistory;
import com.discern.car.entity.SearchHistoryPic;
import com.discern.car.entity.User;
import com.discern.car.service.CarBrandService;
import com.discern.car.service.CarService;
import com.discern.car.service.IssueService;
import com.discern.car.service.SalesmanService;
import com.discern.car.service.SearchHistoryPicService;
import com.discern.car.service.SearchHistoryService;
import com.discern.car.service.SellShopInfoService;
import com.discern.car.util.ChineseCharToEn;
import com.discern.car.util.ImageUtil;
import com.discern.car.util.LoginUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Keben on 2018-05-11.
 */

@RestController
@RequestMapping("/search")
public class searchController implements InitializingBean {


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
  private SellShopInfoService sellShopInfoService;

  @Resource
  private RedisService redisService;

  @Resource
  private SearchHistoryPicService searchHistoryPicService;

  @Value("${img.location}")
  private String location;


  /**
   * 文字搜索
   */
  @RequestMapping("/textSearch")
  public ResultDto textSearch(
          @RequestParam(value = "searchContext", required = false) String searchContext, String signature) {
    System.out.println("/textSearch");
    System.out.println("signature :" + signature);
    //保存搜索记录
    SearchHistory searchHistory = new SearchHistory();
    User user = loginUtil.cheakLogin(signature);
    if (user == null) {
      return new ResultDto("fail", "需要授予用户权限！");
    }
    //添加搜索记录
    searchHistory.setUserId(user.getId());
    searchHistory.setContent(searchContext);
    searchHistoryService.insertHistory(searchHistory);
    //获取搜索结果
    List<Car> list = carService.textSearch(searchContext);
    Map<String, Object> map = new HashMap<>();
    map.put("carList", list);
    map.put("issue", issueService.selectByTextSearch(searchContext));
    return new ResultDto("success", map);
  }

  /**
   * @param signature 登陆状态
   */
  @ResponseBody
  @RequestMapping("/textSearchHistory")
  public ResultDto textSearchHistory(String signature) {
    System.out.println("/textSearchHistory : ");
    System.out.println("signature :" + signature);
    //获取用户登陆信息
    User user = loginUtil.cheakLogin(signature);
    if (user == null) {
      return new ResultDto("fail", "需要授予用户权限！");
    } else {
      List<SearchHistory> list = searchHistoryService.selectByUserId(user.getId());
      return new ResultDto("success", list);
    }

  }

    /**
     * @param signature 登陆状态
     */
  @ResponseBody
  @RequestMapping("/removeTextSearchHistory")
  public ResultDto removeTextSearchHistory(String signature){
      //获取用户登陆信息
      User user = loginUtil.cheakLogin(signature);
      if (user == null) {
          return new ResultDto("fail", "需要授予用户权限！");
      } else {
          searchHistoryService.removeTextSearchHistory(user.getId());
          return new ResultDto("success",null);
      }
  }


  /**
   * 高级搜索 高级搜索
   */
  @RequestMapping(value = "/advancedSearch", method = RequestMethod.POST)
  public ResultDto advancedSearch(
      @RequestParam(value = "displacement", required = false) Integer[] displacement,
      @RequestParam(value = "structure", required = false) Integer[] structure,
      @RequestParam(value = "level", required = false) Integer[] level,
      @RequestParam(value = "Transmission", required = false) Integer[] transmission,
      @RequestParam(value = "country", required = false) Integer[] country,
      @RequestParam(value = "production_methods", required = false) Integer[] production_methods,
      @RequestParam(value = "energy", required = false) Integer[] energy,
      @RequestParam(value = "driving_method", required = false) Integer[] driving_method,
      @RequestParam(value = "seat", required = false) Integer[] seat,
      @RequestParam(value = "be_price", required = false) Float be_price,
      @RequestParam(value = "en_price", required = false) Float en_price) {
    System.out.println(level);
    System.out.println(structure);
    List<Car> list = carService
        .advancedSelect(displacement, structure, level, transmission, country, production_methods,
            energy, driving_method, seat, be_price, en_price);

    return new ResultDto("success", list);
  }

  /**
   * 提供第一层品牌 提供第一层品牌
   */
  private Map brandsMap;
  @RequestMapping(value = "/getBrands", method = RequestMethod.GET)
  public ResultDto getBrands() {
    return new ResultDto("success", brandsMap);
  }
  private void generateBrands(){
    List<CarBrand> list = carBrandService.selectFatherBrands();
    Map map = new HashMap();
    for (int i = 0; i < 26; i++) {
      map.put((char) (65 + i), new ArrayList<CarBrand>());
    }

    for (CarBrand carBrand : list) {
      String firstLetterString = chineseCharToEn.getFirstLetter(carBrand.getName());

      Character c = null;

      c = firstLetterString.toLowerCase().charAt(0);
      if ("讴".equals("" +c)) {
        ((List<CarBrand>) map.get('O')).add(carBrand);
        continue;
      }
      try {
        ((List<CarBrand>) map.get((char) (c - 32))).add(carBrand);
      } catch (NullPointerException e) {
        e.printStackTrace();
        System.out.println("=================字符 " + c);
      }
    }
    brandsMap = map;
  }

  /**
   * 获取单个品牌的信息
   */
  @RequestMapping(value = "/getBrand", method = RequestMethod.GET)
  public ResultDto getBrand(Integer id) {
    CarBrand carBrand = carBrandService.selectByPrimaryKey(id);
    return new ResultDto("success", carBrand);
  }

  /**
   * 提供一层品牌以下的二层品牌与三层品牌
   */
  @RequestMapping(value = "/getSonBrands", method = RequestMethod.GET)
  public ResultDto getSonBrands(Integer id) {
    System.out.println("/getBrands : ");
    List<BrandDto> list = carBrandService.selectSonBrands(id);
    return new ResultDto("success", list);
  }

  /**
   * 提供第三层品牌以下的所有汽车
   */
  @RequestMapping(value = "/getCars", method = RequestMethod.GET)
  public ResultDto getCars(Integer id, Integer pageNum) {
    System.out.println("/getCars : ");
    List<CarDto> list = carService.selectByBrandId(id, pageNum);
    Map<String, Object> map = new HashMap<>();
    map.put("cars", list);
    if (list.size() != 0) {
      pageNum++;
    } else {
      pageNum = -1;
    }
    map.put("pageNum", pageNum);
    return new ResultDto("success", map);
  }

  /**
   * 获取车信息
   */
  @RequestMapping(value = "/getCar", method = RequestMethod.GET)
  public ResultDto getCar(@RequestParam(name = "ids", required = false) String idArrayString,
      @RequestParam(name = "id", required = false) Integer id,
      @RequestParam(name = "latitude", required = false) String latitude,
      @RequestParam(name = "longitude", required = false) String longitude) {
    double lat, lon;
    if (latitude == null || latitude.isEmpty()) {
      lat = 0;
    } else {
      lat = Double.parseDouble(latitude);
    }
    if (longitude == null || longitude.isEmpty()) {
      lon = 0;
    } else {
      lon = Double.parseDouble(longitude);
    }
    if (idArrayString == null && id == null) {
      return ResultDto.ERR_PARAM;
    }
    if (idArrayString != null) {
      JSONArray jsonArray = JSON.parseArray(idArrayString);
      List<CarDto> carDtoArrayList;
      List<Integer> ids = new ArrayList<>();
      for (int i = 0; i < jsonArray.size(); i++) {
        ids.add(jsonArray.getIntValue(i));
      }
      carDtoArrayList = carService.selectByPrimaryKeys(ids);

      for (CarDto tmpDto : carDtoArrayList) {
        int ancestorBrandId = carBrandService.selectAncestorsById(tmpDto.getCarBrand()).get(0)
            .getId();
        tmpDto.setSaleShops(sellShopInfoService.selectAroundSellShopByBrandId(lat,
            lon,
            ancestorBrandId));
      }
      return new ResultDto("success", carDtoArrayList);
    } else {
      CarDto car = carService.selectByPrimaryKey(id);
      int ancestorBrandId = carBrandService.selectAncestorsById(car.getCarBrand()).get(0).getId();
      car.setSaleShops(sellShopInfoService.selectAroundSellShopByBrandId(lat, lon,
          ancestorBrandId));
      return new ResultDto("success", car);
    }
  }

  /**
   * 获取附近的所有商店
   */
  @RequestMapping(value = "/getAroundShop", method = RequestMethod.GET)
  public ResultDto getNearbyShops(double latitude, double longitude) {
    List<SaleShopDto> saleShopDtos = sellShopInfoService
        .selectAroundSellShopByLocation(latitude, longitude);
    return new ResultDto("success", saleShopDtos);

  }

  /**
   * 获取指定车型的销售人员
   */
  @RequestMapping(value = "/getSalesman", method = RequestMethod.GET)
  public ResultDto getSalesman(Integer brandId) {
    List<SalesmanDto> list = salesmanService.selectByBrandId(brandId);
    return new ResultDto("success", list);
  }

  /**
   *
   */
  @RequestMapping(value = "/getShopInfo", method = RequestMethod.GET)
  public ResultDto getShopInfoById(Integer id) {
    SaleShopDto shopDto = sellShopInfoService.selectByPrimaryKey(id);
    return new ResultDto("success", shopDto);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    generateBrands();
  }
}
