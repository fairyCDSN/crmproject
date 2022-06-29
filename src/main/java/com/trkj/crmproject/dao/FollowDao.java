package com.trkj.crmproject.dao;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Follow;
import com.trkj.crmproject.vo.FollowVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface FollowDao {
    List<Follow> findFollow(@Param("user_name") String user_name,@Param("customer_name") String customer_name,
                            @Param("follow_title") String follow_title,@Param("time1") String time1,
                            @Param("time2") String time2);
    int insertFollow(@Param("follow_title") String follow_title,@Param("customer_id") int customer_id,
                     @Param("contact") String contact,@Param("follow_date") Date follow_date,
                     @Param("follow_manner") String follow_manner,@Param("follow_content") String follow_content,
                     @Param("user_name") String user_name);
}
