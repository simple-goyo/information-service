package com.fdse.is.sys.queue.controller;

import com.alibaba.fastjson.JSONObject;
import com.fdse.is.common.constant.UrlConstant;
import com.fdse.is.sys.queue.model.Queue;
import com.fdse.is.sys.queue.model.QueueUser;
import com.fdse.is.sys.queue.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String,String> entry(@RequestParam(name = "userId") int userId,@RequestParam(name = "commodityId") int commodityId){
        //返回值
        Map<String,String> result=new HashMap<>();
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
            result.put("queueUserId","0");
            return result;
        }
        //如果该用户已经在这个队列中则返回0
        List<QueueUser> queueUserList=queueService.getQueueUserByQueueIdAndUserId(optimalQueue.getId(),userId);
        if(queueUserList.size()>0){
            result.put("queueUserId",queueUserList.get(0).getId()+"");
            return result;
        }
        //保存该用户在这个队列中的排队信息
        QueueUser queueUser=new QueueUser();
        queueUser.setQueueId(optimalQueue.getId());
        queueUser.setUserId(userId);
        queueUser.setEntryTime(new Timestamp(System.currentTimeMillis()));
        queueService.saveQueueUser(queueUser);
        result.put("queueUserId", queueUser.getId()+"");
        return result;
    }
    @RequestMapping("/turn")
    public boolean isTurn(@RequestParam(name = "queueUserId") int id){
        //根据用户排队id获取队列id和用户id
        int queueId = queueService.getQueueIdById(id);
        int userId = queueService.getQueueUserIdById(id);
        //根据队列id查询队列上的用户列表
        List<QueueUser> queueUsers = queueService.getQueueUsersByQueueId(queueId);
        if(queueUsers.get(0).getUserId() == userId){
            queueService.updateStartTimeAndState(new Timestamp(System.currentTimeMillis()),queueUsers.get(0).getId());
            return true;
        }else{
            //计算时间间隔
            Date startDate = queueService.getStartTime(id);
            long timeCell = System.currentTimeMillis() - startDate.getTime();
            boolean overtime = timeCell/(1000*60) > queueService.getMaxTime(queueId);
            if(overtime) {
                //超时处理
                queueService.updateQueueUser(id, 10);
                QueueUser queueUser = new QueueUser();
                queueUser.setQueueId(queueId);
                queueUser.setUserId(userId);
                queueUser.setEntryTime(new Timestamp(System.currentTimeMillis()));
                queueService.saveQueueUser(queueUser);
            }
            return false;
        }
    }
}
