package com.fdse.is.sys.queue.mapper;

import com.fdse.is.sys.queue.model.QueueUser;
import org.apache.ibatis.annotations.*;

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
public interface QueueUserMapper {

    @Select("SELECT * FROM q_queue_user WHERE queueId = #{queueId} AND userId = #{userId} ;")
    List<QueueUser> findQueueUserByQueueIdAndUserId(@Param("queueId") int queueId,@Param("userId") int userId);

    @Insert("INSERT INTO q_queue_user (`queueId`, `userId`, `entryTime`, `startTime`,`completeTime`,`state`) VALUES (#{queueId}, #{userId}, #{entryTime},#{startTime},#{completeTime},#{state});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertQueueUser(QueueUser queueUser);
}
