package com.fdse.is.sys.queue.mapper;

import com.fdse.is.sys.queue.model.QueueUser;
import org.apache.ibatis.annotations.*;

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
@Mapper
public interface QueueUserMapper {

    //todo 已完成
    @Select("SELECT * FROM q_queue_user WHERE queueId = #{queueId} AND userId = #{userId} AND state !=10 AND state !=11;")
    List<QueueUser> findQueueUserByQueueIdAndUserId(@Param("queueId") int queueId,@Param("userId") int userId);

    @Insert("INSERT INTO q_queue_user (`queueId`, `userId`, `entryTime`, `startTime`,`completeTime`,`state`) VALUES (#{queueId}, #{userId}, #{entryTime},#{startTime},#{completeTime},#{state});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertQueueUser(QueueUser queueUser);

    @Select("SELECT * FROM q_queue_user WHERE queueId = #{queueId}")
    List<QueueUser> getQueueUsersByQueueId(@Param("queueId") int queueId);

    @Select("SELECT userId FROM q_queue_user WHERE id = #{id} AND state not in(10,11)")
    int getQueueUserIdById(int id);

    @Select("SELECT queueId FROM q_queue_user WHERE id = #{id}")
    int getQueueIdById(int id);

    @Update("UPDATE q_queue_user SET state = #{state} WHERE id = #{id}")
    void updateQueueUser(@Param("id") int id,@Param("state") int state);

    @Select("SELECT entryTime FROM q_queue_user WHERE id = #{id}")
    Timestamp getStartTime(int id);

    @Update("UPDATE q_queue_user SET state = 1 , startTime = #{startTime} WHERE id = #{id}")
    void updateStartTimeAndState(@Param("startTime") Timestamp startTime,@Param("id") int id);
}
