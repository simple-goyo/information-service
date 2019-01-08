package com.fdse.is.sys.sensor.controller;

import com.alibaba.fastjson.JSONObject;
import com.fdse.is.common.constant.UrlConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName HeaterController
 * @Description TODO
 * @Author LiuJing
 * @Date 2018/9/149:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("/instruction")
public class InstructionController {

    @Autowired
    private RestTemplate restTemplate;

    //取糖
    @RequestMapping("/takeSugar")
    public boolean takeSugar(@RequestParam(name = "userId") int userId){
        //根据用户id去App后台获取用户位置信息
        String serviceURL = UrlConstant.getAppBackEndServiceURL(UrlConstant.APP_BACK_END_SEND_MESSAGE_TO_MP);
        serviceURL+=("?userId="+userId);
        //获取糖的位置
        serviceURL+=("?content="+"请按照链接地图去401取糖");
        serviceURL+=("?url="+"https://map.baidu.com/");
        JSONObject jsonObject = restTemplate.getForEntity(serviceURL, JSONObject.class).getBody();
        return true;
    }

    //接咖啡
    @RequestMapping("/takeCoffee")
    public boolean takeCoffee(@RequestParam(name = "userId") int userId){
        //根据用户id去App后台获取用户位置信息
        String serviceURL = UrlConstant.getAppBackEndServiceURL(UrlConstant.APP_BACK_END_SEND_MESSAGE_TO_MP);
        serviceURL+=("?userId="+userId);
        //获取咖啡的位置
        serviceURL+=("?content="+"请按照链接地图去401取咖啡");
        serviceURL+=("?url="+"https://map.baidu.com/");
        JSONObject jsonObject = restTemplate.getForEntity(serviceURL, JSONObject.class).getBody();
        return true;
    }

    //送咖啡
    @RequestMapping("/sendCoffee")
    public boolean sendCoffee(@RequestParam(name = "userId") int userId){
        //根据用户id去App后台获取用户位置信息
        String serviceURL = UrlConstant.getAppBackEndServiceURL(UrlConstant.APP_BACK_END_SEND_MESSAGE_TO_MP);
        serviceURL+=("?userId="+userId);
        //获取咖啡的位置
        serviceURL+=("?content="+"请按照链接地图去402送咖啡");
        serviceURL+=("?url="+"https://map.baidu.com/");
        JSONObject jsonObject = restTemplate.getForEntity(serviceURL, JSONObject.class).getBody();
        return true;
    }
}
