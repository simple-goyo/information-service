package com.fdse.is.sys.queue.controller;

import com.alibaba.fastjson.JSONObject;
import com.fdse.is.common.constant.UrlConstant;
import com.fdse.is.common.service.ScClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * <pre>
 *     author : shenbiao
 *     e-mail : 1105125966@qq.com
 *     time   : 2018/09/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/entry")
    public int entry(@RequestParam(name = "userId") int userId,@RequestParam(name = "commodityId") int commodityId){
        //根据用户id去App后台获取用户位置信息
        String serviceURL = UrlConstant.getAppBackEndServiceURL(UrlConstant.APP_BACK_END_USER_GET_LOCATION);
        serviceURL+=("?userId="+userId);
        JSONObject json = restTemplate.getForEntity(serviceURL, JSONObject.class).getBody();
        //根据货物id获取队列id集合，在其中选择满足最远距离要求（用户到队列的距离小于允许最远排队距离）的队列，
        // 并且按照平均时间*当前排队人数的值的大小排序，选择最合适的队列

        return 0;
    }
}
