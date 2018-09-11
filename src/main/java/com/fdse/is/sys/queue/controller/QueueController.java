package com.fdse.is.sys.queue.controller;

import com.alibaba.fastjson.JSONObject;
import com.fdse.is.common.constant.UrlConstant;
import com.fdse.is.sys.queue.model.Queue;
import com.fdse.is.sys.queue.model.QueueUser;
import com.fdse.is.sys.queue.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.List;

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
    @Autowired
    private QueueService queueService;

    @RequestMapping("/entry")
    public int entry(@RequestParam(name = "userId") int userId,@RequestParam(name = "commodityId") int commodityId){
        //根据用户id去App后台获取用户位置信息
        String serviceURL = UrlConstant.getAppBackEndServiceURL(UrlConstant.APP_BACK_END_USER_GET_LOCATION);
        serviceURL+=("?userId="+userId);
        JSONObject jsonObject = restTemplate.getForEntity(serviceURL, JSONObject.class).getBody();
        Double longitude= (Double) jsonObject.get("longitude");
        Double latitude= (Double) jsonObject.get("latitude");
        //根据货物id获取队列id集合，在其中选择满足最远距离要求（用户到队列的距离小于允许最远排队距离）的队列，
        // 并且按照平均时间*当前排队人数的值的大小排序，选择最合适的队列
        //找到最合适的队列
        Queue optimalQueue=queueService.getOptimalQueue(commodityId, longitude, latitude);
        //如果不存在则返回0
        if(optimalQueue==null){
            return 0;
        }
        //如果该用户已经在这个队列中则返回0
        int count=queueService.getQueueUserByQueueIdAndUserId(optimalQueue.getId(),userId);
        if(count>0){
            return 0;
        }
        //保存该用户在这个队列中的排队信息
        QueueUser queueUser=new QueueUser();
        queueUser.setQueueId(optimalQueue.getId());
        queueUser.setUserId(userId);
        queueUser.setEntryTime(new Timestamp(System.currentTimeMillis()));
        queueService.saveQueueUser(queueUser);
        return queueUser.getId();
    }
}
