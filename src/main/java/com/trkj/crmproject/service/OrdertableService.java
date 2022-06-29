package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.ApprecordsSon;
import com.trkj.crmproject.entity.OrdApp;
import com.trkj.crmproject.entity.OrderXq;
import com.trkj.crmproject.entity.jfjl;
import com.trkj.crmproject.vo.CkVo;
import com.trkj.crmproject.vo.OrderTableVo;

import java.util.List;

public interface OrdertableService {
    public PageInfo<OrderTableVo> findOrdertable(int pageNum, int pageSize, String user_name,String order_bh,String order_title,
                                                 String khqyr,String state,String time1,String time2);
    public List<OrderXq> findOrderTableXq(int order_id);
    public List<OrdApp> selectApp(int sqid, int app_id);
    OrderXq selectStages(int order_id);
    CkVo[] selectCk();
    int updateJiaoFu(jfjl jfjl,int ck_id);
}
