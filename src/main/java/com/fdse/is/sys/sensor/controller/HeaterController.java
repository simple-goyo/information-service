package com.fdse.is.sys.sensor.controller;

import com.fdse.is.sys.sensor.service.HeaterService;
import com.fdse.is.sys.sensor.service.impl.HeaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/hot")
    public boolean isHotWater(@RequestParam(name = "id") int id){
        return id%2 == 0;
    }

    @RequestMapping("/warm")
    public boolean isWarmWater(@RequestParam(name = "id") int id){
        return id%2 == 0;
    }

    @RequestMapping("/enough")
    public boolean isEnoughWater(@RequestParam(name = "id") int id){
        return id%2 == 0;
    }



}
