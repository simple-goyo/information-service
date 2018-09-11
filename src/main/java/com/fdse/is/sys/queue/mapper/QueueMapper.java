package com.fdse.is.sys.queue.mapper;

import com.fdse.is.sys.queue.model.Queue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
@Mapper
public interface QueueMapper {
    @Select("SELECT * FROM q_queue WHERE q_queue.id IN (SELECT queueId FROM q_queue_commodity WHERE q_queue_commodity.commodityId =#{commodityId}) AND (6378137.0*ACOS(SIN(#{latitude}/180*PI())*SIN(q_queue.latitude/180*PI())+COS(#{latitude}/180*PI())*COS(q_queue.latitude/180*PI())*COS((#{longitude}-q_queue.longitude)/180*PI())))<q_queue.maxDistance ORDER BY q_queue.averageTime*(SELECT COUNT(*) FROM q_queue_user WHERE q_queue_user.state != 1 AND q_queue_user.queueId=q_queue.id)")
    List<Queue> findOptimalQueue(@Param("commodityId") int commodityId, @Param("longitude") Double longitude, @Param("latitude") Double latitude);
}
