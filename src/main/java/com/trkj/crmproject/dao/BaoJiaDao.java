package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.BaoJia;
import com.trkj.crmproject.entity.product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaoJiaDao {
    public List<BaoJia> findBaojia(@Param("user_name")String user_name, @Param("customer_name")String customer_name,
                                   @Param("state") String state, @Param("time1") String time1, @Param("time2")String time2,
                                   @Param("salesperson_id")int salesperson_id);
    public int insertProduct(@Param("product")product product,@Param("user_id")int user_id);
}
