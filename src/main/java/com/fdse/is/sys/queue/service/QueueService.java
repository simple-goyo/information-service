package com.fdse.is.sys.queue.service;

import com.fdse.is.sys.queue.model.Queue;
import com.fdse.is.sys.queue.model.QueueUser;

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

public interface QueueService {
    Queue getOptimalQueue(int commodityId,Double longitude,Double latitude);
    int getQueueUserByQueueIdAndUserId(int queueId,int userId);
    int saveQueueUser(QueueUser queueUser);
}
