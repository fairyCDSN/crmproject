package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.vo.CkVo;
import com.trkj.crmproject.vo.jfjlVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrdertableDao {
    public List<OrderTable> findOrdertable(@Param("user_name") String user_name,@Param("order_bh")  String order_bh,
                                           @Param("order_title")  String order_title,@Param("khqyr") String khqyr,
                                           @Param("state")  String state,@Param("time1") String time1,
                                           @Param("time2")  String time2);
    public List<OrderXq> findOrderTableXq(int order_id);
    public List<OrdApp> selectApp(@Param("sqid") int sqid, @Param("app_id") int app_id);

    PcPlan[] findPcPlan(int order_id);

    jfjl[] findJiaoFu(int order_id);

    jfjlVo[] findJfjl(int jf_id);

    CkVo[] selectCk();

    int updateJiaoFu( @Param("jf_id") int jf_id,@Param("true_time")  Date true_time);

    int insertChuKu(@Param("order_id") int order_id,@Param("ck_id") int ck_id);
    int insertChuKuPro(@Param("number") int number,@Param("pro_id") int pro_id,@Param("order_id") int order_id);

    int cheackCkSum(int proId);

    int insertWarn(@Param("warn_type") String warn_type,@Param("warn_content")String warn_content);
}
