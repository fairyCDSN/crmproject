package com.trkj.crmproject.dao;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.PcPlan;
import com.trkj.crmproject.vo.PcPlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface PcPlanDao {
    public PcPlan findPcplan(@Param("order_id")int order_id,@Param("qs") String qs,
                             @Param("state")String state,@Param("monery1") String monery1,
                             @Param("monery2") String monery2,@Param("user_name") String user_name);
    public int[] findorderId();
    public String findmint(int order_id);
    public String findmaxt(int order_id);
}
