package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.vo.OrderTableVo;

public interface OrdertableService {
    public PageInfo<OrderTableVo> findOrdertable(int pageNum, int pageSize, String user_name,String order_bh,String order_title,
                                                 String khqyr,String state,String time1,String time2);
}
