package com.fdse.is.sys.sensor.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fdse.is.common.constant.UrlConstant;
import com.fdse.is.sys.sensor.service.HeaterService;
import com.fdse.is.sys.sensor.service.impl.HeaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HeaterController
 * @Description TODO
 * @Author LiuJing
 * @Date 2018/9/149:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("/heater")
public class HeaterController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getTemOfWater")
    public Map<String,String> getTemOfWater() {
        //返回值
        Map<String,String> result=new HashMap<>();
        result.put("temOfWater","99");
        return result;
    }

    @RequestMapping("/hot")
    public boolean isHotWater(@RequestParam(name = "id") int id) {
        return id % 2 == 0;
    }

    @RequestMapping("/warm")
    public boolean isWarmWater(@RequestParam(name = "id") int id) {
        return id % 2 == 0;
    }

    @RequestMapping("/enough")
    public boolean isEnoughWater(@RequestParam(name = "id") int id) {
        return id % 2 == 0;
    }
}
