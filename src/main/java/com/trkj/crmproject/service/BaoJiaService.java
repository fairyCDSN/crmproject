package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.ProductXq;
import com.trkj.crmproject.entity.contact;
import com.trkj.crmproject.entity.jfjl;
import com.trkj.crmproject.entity.product;
import com.trkj.crmproject.vo.BaoJiaVo;
import com.trkj.crmproject.vo.ProductVo;

import java.util.List;

public interface BaoJiaService {
    public PageInfo<BaoJiaVo> findBaojia(int pageNum, int pageSize,String user_name, String customer_name,String state,
                                         String time1, String time2,int salesperson_id);
    public int insertProduct(ProductVo[] ss, int user_id, String jfstyle, String plan_jftime,int customer_id,String title,int contact_id);
    public int insertProduct1(ProductVo[] ss, int bjid);
    public List<contact> findConName(int customer_id);
    public contact findConXq1(int contact_id);
    public List<ProductXq> findProXq(int bjid);
    public ProductXq findProXq1(int pro_id);
    public int deletepro(int pro_id,int bjid);
    public int updatepro(ProductXq[] ss, int bjid);
    public List<jfjl> findjfjl(int bjid);
    public jfjl findjfjl1(int bjid,String user_name);
    public int insertjiaofu(int bjid,String user_name);
    public int delectjiaofu(int jf_id,int state_id);
    public int insertordertable(jfjl[] jfjl,String fk, String user_name,String beizhu,String order_bh,String order_title);
}
