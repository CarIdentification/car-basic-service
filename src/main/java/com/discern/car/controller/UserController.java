package com.discern.car.controller;

import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.config.RedisService;
import com.discern.car.dao.CarMapper;
import com.discern.car.dao.UserMapper;
import com.discern.car.dto.CarDto;
import com.discern.car.dto.OwnCarDto;
import com.discern.car.dto.ResultDto;
import com.discern.car.entity.Tag;
import com.discern.car.entity.User;
import com.discern.car.service.TagService;
import com.discern.car.service.UserService;
import com.discern.car.util.LoginUtil;
import com.discern.car.util.OpenIdUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @Resource
    private RedisService redisService;
    @Resource
    private LoginUtil loginUtil;
    @Value("${server.port}")
    private String port;
    @Resource
    private UserMapper userMapper;
    @Resource
    private CarMapper carMapper;

    //    @RequestMapping("/getMarkers")
//    public ArrayList<MapMarkers> getMarkers(){
//        System.out.println("hhhhh");
//        ArrayList<MapMarkers> markers = new ArrayList<>();
//        markers.add(new MapMarkers(22.3497582742,113.5498809814));
//        markers.add(new MapMarkers(22.3536479905,113.5555458069));
//        return markers;
//
//    }
    @RequestMapping("/add")
    public ResultDto add(User user) {
        userService.insert(user);
        return ResultDto.OK;
    }

    @RequestMapping("/delete")
    public ResultDto delete(Integer id) {
        userService.deleteByPrimaryKey(id);
        return ResultDto.OK;
    }

    @RequestMapping("/update")
    public ResultDto update(User user) {
        userService.updateByPrimaryKey(user);
        return ResultDto.OK;
    }

    /**
     * @param code 用于获取openid与sessionKey
     * @param user 用户个人信息
     * @param signature 校验签名
     * @param rawData 不包含敏感信息的个人信息，用于结合sessionKey校验签名，与signature比较
     */
    @RequestMapping("/sendUserCode")
    public HashMap<String, Object> sendUserCode(String code, User user, String signature, String rawData) {
        System.out.println("/sendUserCode\ncode :" + code);
        System.out.println("signature :" + signature);
        System.out.println(user.getNickname());
        Map map = OpenIdUtil.oauth2GetOpenid(code);
        String openid = map.get("openid").toString();

        User u = userService.selectByOpenId(openid);
        //数据库没有用户信息，为第一次使用小程序的用户
        if (u == null) {
            user.setOpenid(openid);
            userService.insertSelective(user);
            u = userService.selectByOpenId(openid);
        }
        //从redis数据库中查看用户是否登陆过,signature会因为session_key的改变而改变，但我们只需要第一次登陆的signature
        if (loginUtil.cheakLogin(signature) == null) {
            System.out.println("未登录");
            //如果用户未登录，记录下登陆状态
            System.out.println(redisService.set(signature, u, new Long(86400)));
        }
//        System.out.println(u.toString());
        HashMap<String, Object> rsDto = new HashMap<>();
        rsDto.put("stateInfo", "success");
        rsDto.put("entity", signature);
        rsDto.put("uid", u.getId());

        return rsDto;
    }

    /**
     * 查询tag
     */
    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public ResultDto tag(String signature) {
        User user = loginUtil.cheakLogin(signature);
        if (user == null) {
            return new ResultDto("fail", "需要授予用户权限！");
        }
        List<Tag> list = tagService.selectByUserId(user.getId());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return new ResultDto("success", list);
    }

    /**
     * 未选择的tag
     */
    @RequestMapping(value = "/noTags", method = RequestMethod.GET)
    public ResultDto noTags(String signature) {
        User user = loginUtil.cheakLogin(signature);
        if (user == null) {
            return new ResultDto("fail", "需要授予用户权限！");
        }
        List<Tag> list = tagService.selectNoHasByUserId(user.getId());
        int count = tagService.selectCount();
        List<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            booleans.add(false);
        }

        List<Object> lists = new ArrayList<>();
        lists.add(list);
        lists.add(booleans);
        return new ResultDto("success", lists);
    }

    /**
     * 已选择的tag
     */
    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public ResultDto tags(String signature) {
        User user = loginUtil.cheakLogin(signature);
        if (user == null) {
            return new ResultDto("fail", "需要授予用户权限！");
        }
        List<Tag> list = tagService.selectByUserId(user.getId());
        int count = tagService.selectCount();
        List<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            booleans.add(false);
        }

        List<Object> lists = new ArrayList<>();
        lists.add(list);
        lists.add(booleans);
        return new ResultDto("success", lists);
    }

    /**
     * 添加tag
     */
    @RequestMapping(value = "/addTag", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto addTag(@RequestBody String[] add) {
        String signature = add[add.length - 1];
//        System.out.println(add);
        User user = loginUtil.cheakLogin(signature);
        if (user == null) {
            return new ResultDto("fail", "需要授予用户权限！");
        }
        String process = "success";
        for (int i = 0; i < add.length - 1; i++) {

            int a = tagService.insertTagWithUserId(user.getId(), Integer.parseInt(add[i]));
//                if (a == 0){
//                    return new ResultDto("fail","操作失败！");
//                }

        }
        return new ResultDto(process, "操作成功！");
    }

    /**
     * 删除tag
     */
    @RequestMapping(value = "/removeTag", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto removeTag(@RequestBody String[] remove) {
        String signature = remove[remove.length - 1];
        User user = loginUtil.cheakLogin(signature);
        if (user == null) {
            return new ResultDto("fail", "需要授予用户权限！");
        }
        String process = "success";
        for (int i = 0; i < remove.length - 1; i++) {

            int a = tagService.removeTagWithUserId(user.getId(), Integer.parseInt(remove[i]));
//                if (a == 0){
//                    return new ResultDto("fail","操作失败！");
//                }

        }
        return new ResultDto(process, "操作成功！");
    }

    @RequestMapping("/signUp")
    public ResultDto signUp(@RequestParam User user) {
        userService.insert(user);
        System.out.println(111);
        return new ResultDto("success", user);
    }

    @RequestMapping("/hi")
    public ResultDto home(@RequestParam int id) {
        return new ResultDto("success", userService.selectByPrimaryKey(3));
    }

    @RequestMapping(value = "/addOwnCar", method = RequestMethod.POST)
    public ResultDto addOwnCar(@RequestParam(name = "userId") int userId, @RequestParam(name = "carId") int carId) {
        return new ResultDto("success", userMapper.addOwnCar(carId, userId));
    }

    @RequestMapping(value = "/delOwnCar", method = RequestMethod.POST)
    public ResultDto delOwnCar(@RequestParam(name = "userId") int userId, @RequestParam(name = "carId") int carId) {
        return new ResultDto("success", userMapper.delOwnCar(carId, userId));
    }

    @RequestMapping("/getOwnCar")
    public ResultDto getOwnCar(@RequestParam(name = "userId") int userId) {
        List<Integer> carIds = userMapper.getOwnCar(userId);
        ArrayList<OwnCarDto> data = new ArrayList<>();
        if(carIds.size()!=0){
            List<CarDto> carInfos = carMapper.selectByPrimaryKeys(carIds);

            for (CarDto carInfo : carInfos) {
                OwnCarDto info = new OwnCarDto();
                info.setCarName(carInfo.getCarName());
                info.setCoverPic(carInfo.getCoverPic());
                info.setId(carInfo.getId());
                data.add(info);
            }
        }
        return new ResultDto("success", data);
    }

    @RequestMapping("/haveCar")
    public ResultDto haveCar(@RequestParam(name = "userId")int userId, @RequestParam(name = "carId") int carId){
        return new ResultDto("success",userMapper.haveCar(carId,userId));
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult<User> list(Page page) {
        PageResult<User> result = userService.list(page);
        return result;
    }
}
