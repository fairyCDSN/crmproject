package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.product;
import com.trkj.crmproject.vo.BaoJiaVo;

public interface BaoJiaService {
    public PageInfo<BaoJiaVo> findBaojia(int pageNum, int pageSize,String user_name, String customer_name,String state,
                                         String time1, String time2,int salesperson_id);
    public int insertProduct(product[] ss, int user_id, String jfstyle, String plan_jftime);
}
