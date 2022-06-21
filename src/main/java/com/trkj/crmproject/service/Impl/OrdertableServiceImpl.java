package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.OrdertableDao;
import com.trkj.crmproject.entity.OrderTable;
import com.trkj.crmproject.service.OrdertableService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.BaoJiaVo;
import com.trkj.crmproject.vo.OrderTableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdertableServiceImpl implements OrdertableService {
    @Autowired
    private OrdertableDao ordertableDao;
    @Override
    public PageInfo<OrderTableVo> findOrdertable(int pageNum, int pageSize,String user_name,String order_bh,String order_title,
                                                 String khqyr,String state,String time1,String time2) {
        Page<OrderTable> page= PageHelper.startPage(pageNum,pageSize);
        List<OrderTable> list = ordertableDao.findOrdertable(user_name,order_bh,order_title,khqyr,state,time1,time2);
        Page<OrderTableVo> orderTables=new Page<>();
        BeanTools.copyList(list,orderTables,OrderTableVo.class);
        PageInfo<OrderTableVo> pageInfo=new PageInfo<>(orderTables);
        return pageInfo;
    }

}
