package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.vo.ProductVo;
import com.trkj.crmproject.vo.jfjlVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface BaoJiaDao {
    public List<BaoJia> findBaojia(@Param("user_name")String user_name, @Param("customer_name")String customer_name,
                                   @Param("state") String state, @Param("time1") String time1, @Param("time2")String time2,
                                   @Param("salesperson_id")int salesperson_id);
    BjPro[] findBjPro(int bjid);
    public List<contact> findConName(int customer_id);
    public int insertBaoJia(@Param("user_id")int user_id,@Param("customer_id")int customer_id,
                            @Param("contact_id") int contact_id);
    public int insertApprecords(@Param("sqid") int sqid,@Param("app_id") int app_id);
    public int insertApprecordSon(@Param("state_id")int state_id,@Param("name")int name);
    public int findid();
    public int findid1();
    public int[] findName(String app_type);
    public contact findConXq1(int contact_id);
    public List<ProductXq> findProXq(int bjid);
    public ProductXq findProXq1(int pro_id);
    public int deletepro(@Param("pro_id")int pro_id,@Param("bjid")int bjid);
    public int selectpro(int bjid);
    public int updatepro(@Param("proId") int proId,@Param("bjid") int bjid,@Param("sl") int sl,@Param("mo") double mo);
    public List<jfjl> findjiaofu(int bjid);
    public jfjlVo[] findjfjl(int jf_id);
    public int insertjiaofu(@Param("bjid") int bjid,@Param("user_name") String user_name,
                            @Param("total") int total);
    public int findjfid(int bjid);
    public int[] findjfid1(int bjid);
    public int findjfid2(int bjid);
    public int[] findpro(int bjid);
    public int insertjfjl(@Param("jf_id") int jf_id,@Param("user_name") String user_name,@Param("pro_id") int pro_id);
    public int insertjfjl1(@Param("jf_id") int jf_id,@Param("user_name") String user_name,@Param("pro_id") int pro_id,
                           @Param("bjid") int bjid);
    public int findstateId(int bjid);
    public int findjfbjid(int jf_id);
    public String findCjr(int bjid);
    public int findtatal(int bjid);
    public int delectAppSon(int state_id);
    public int delectApp(int state_id);
    public int delectjiaofu(int jf_id);
    int delectjiaofu1(int jf_id);
    public int deleteAlljiaofu(@Param("jf_id") int jf_id,@Param("bjid") int bjid);
    public int delectjfjl(int jf_id);
    public int delectjfjl1(int jfjl_id);
    public int checkjfde(int bjid);
    int checkjiaofu(int jf_id);
    public int findGoodMonery(@Param("bjid") int bjid,@Param("pro_id") int pro_id);
    public int findorderId();
    public String findconName(int bjid);
    public int findOrderId();
    public int updatejfjl(@Param("jfjlId") int jfjlId,@Param("number") int number);
    public int updatejiaofu(@Param("jf_id") int jf_id,@Param("total") double total,@Param("plan_jftime") Date plan_jftime,
                            @Param("order_id") int order_id);
    int updatebaojia(int bjid);
    int updatebaojiaApp(int bjid);
    public int insertordertable(@Param("bjid") int bjid,@Param("order_bh")  String order_bh,@Param("fk")  String fk,
                                @Param("order_title") String order_title,@Param("state_time")  Date state_time,
                                @Param("khqyr") String khqyr,@Param("beizhu") String beizhu,@Param("cjr")  String cjr);
    public int insertpcplan(@Param("order_id") int order_id,@Param("pc_da")  int pc_da,@Param("pc_mn")  double pc_mn,
                            @Param("pc_pcda") Date pc_pcda,@Param("pc_pel") String pc_pel);


    //wq
    public List<BaoJia> selectBjById(@Param("id")int id);

    public int updateState(@Param("sqid") int id,@Param("state") String state);
}
