package com.fdse.is.sys.sensor.service.impl;

import com.fdse.is.sys.sensor.service.HeaterService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;

/**
 * @ClassName HeaterServiceImpl
 * @Description TODO
 * @Author LiuJing
 * @Date 2018/9/149:53
 * @Version 1.0
 **/
public class HeaterServiceImpl implements HeaterService {
    int temperature = (int)(Math.random()*100);

    @Override
    public boolean hotWater(int id) {
        System.out.println("------------------------------------");
        return temperature * id > 98;
    }

    @Override
    public boolean warmWater(int id) {
        return temperature*id > 50 && temperature*id < 98;
    }

    @Override
    public boolean enoughWater(int id) {
        return true;
    }
}
