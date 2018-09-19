package com.fdse.is.sys.queue.service.impl;

import com.fdse.is.sys.queue.mapper.QueueMapper;
import com.fdse.is.sys.queue.mapper.QueueUserMapper;
import com.fdse.is.sys.queue.model.Queue;
import com.fdse.is.sys.queue.model.QueueUser;
import com.fdse.is.sys.queue.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * <pre>
 *     author : shenbiao
 *     e-mail : 1105125966@qq.com
 *     time   : 2018/09/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Service
public class QueueServiceImpl implements QueueService{
    @Autowired
    private QueueMapper queueMapper;
    @Autowired
    private QueueUserMapper queueUserMapper;
    @Override
    public Queue getOptimalQueue(int commodityId, Double longitude, Double latitude) {
        List<Queue> list=queueMapper.findOptimalQueue(commodityId,longitude,latitude);
        if(list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<QueueUser> getQueueUserByQueueIdAndUserId(int queueId, int userId) {
        return queueUserMapper.findQueueUserByQueueIdAndUserId(queueId,userId);
    }

    @Override
    public int saveQueueUser(QueueUser queueUser) {
        return queueUserMapper.insertQueueUser(queueUser);
    }

    @Override
    public int getQueueUserIdById(int id) {
        return queueUserMapper.getQueueUserIdById(id);
    }

    @Override
    public int getQueueIdById(int id) {
        return queueUserMapper.getQueueIdById(id);
    }

    @Override
    public void updateQueueUser(int id,int state) {
        return;
    }

    @Override
    public List<QueueUser> getQueueUsersByQueueId(int queueId) {
        return queueUserMapper.getQueueUsersByQueueId(queueId);
    }

    @Override
    public Timestamp getStartTime(int id) {
        return queueUserMapper.getStartTime(id);
    }

    @Override
    public void updateStartTimeAndState(Timestamp startTime,int id) {
        queueUserMapper.updateStartTimeAndState(startTime,id);
        return;
    }

    @Override
    public int getMaxTime(int queueId) {
        return queueMapper.getMaxTime(queueId);
    }
}
