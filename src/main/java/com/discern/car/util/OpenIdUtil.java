package com.discern.car.util;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;


/**
 * Created by Keben on 2018-04-18.
 */
public class OpenIdUtil {
    public static Map oauth2GetOpenid(String code) {

        String appid="wx8088b0f110233984";
        String appsecret="03b85a18c02a33826e08428d45517834";

        //授权（必填）
        String grant_type = "authorization_code";
        //URL
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //请求参数
        String params = "appid=" + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求

        String data = HttpUtil.get(requestUrl, params);
        //解析相应内容（转换成json对象）
        ObjectMapper mapper = new ObjectMapper();
        Map map = null;
        try {
            map=mapper.readValue(data, Map.class);
            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //用户的唯一标识（openid）
//        System.out.println(json);
//        String Openid =String.valueOf(json.get("openid"));
//        System.out.println(Openid);
        return map;
    }
}
