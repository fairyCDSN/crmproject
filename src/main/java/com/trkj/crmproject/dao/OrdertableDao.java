package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.OrderTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrdertableDao {
    public List<OrderTable> findOrdertable(@Param("user_name") String user_name,@Param("order_bh")  String order_bh,
                                           @Param("order_title")  String order_title,@Param("khqyr") String khqyr,
                                           @Param("state")  String state,@Param("time1") String time1,
                                           @Param("time2")  String time2);
}
