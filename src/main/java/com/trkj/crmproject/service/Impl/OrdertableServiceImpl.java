package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.OrdertableDao;
import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.service.OrdertableService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.BaoJiaVo;
import com.trkj.crmproject.vo.CkVo;
import com.trkj.crmproject.vo.OrderTableVo;
import com.trkj.crmproject.vo.jfjlVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
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

    @Override
    public List<OrderXq> findOrderTableXq(int order_id){
        return ordertableDao.findOrderTableXq(order_id);
    }

    @Override
    public List<OrdApp> selectApp(int sqid, int app_id) {
        return ordertableDao.selectApp(sqid,app_id);
    }

    @Override
    public OrderXq selectStages(int order_id) {
        OrderXq ord=new OrderXq();
        jfjl[] jf=ordertableDao.findJiaoFu(order_id);
        for(int i=0;i<jf.length;i++){
            jfjlVo[] jfVo=ordertableDao.findJfjl(jf[i].getJfId());
            jf[i].setJfjlvo(jfVo);
            if(jf[i].getState().equals("待执行")){
                if(i>0){
                    if(jf[i-1].getNumber()==0){
                        jf[i].setNumber(1);
                    }
                }else if(i==0){
                    jf[i].setNumber(1);
                }
            }
            jf[i].setQs("第"+(i+1)+"期");
        }
        ord.setPcPlan(ordertableDao.findPcPlan(order_id));
        ord.setJfjl(jf);
        return ord;
    }
    @Override
    public CkVo[] selectCk() {
        return ordertableDao.selectCk();
    }

    @Override
    @Transactional
    public int updateJiaoFu(jfjl jfjl,int ck_id) {
        log.debug("交付记录：{}",jfjl);
        int count=1;
        for(int i=0;i<jfjl.getJfjlvo().length;i++){
            log.debug("进入了循环");
            int sum1=ordertableDao.cheackCkSum(jfjl.getJfjlvo()[i].getProId());
            log.debug("库存数量：{}",sum1);
            if(jfjl.getJfjlvo()[i].getNumber()>sum1){
                log.debug("库存数量11111111111：{}",sum1);
                count=0;
                ordertableDao.insertWarn("采购","请尽快补充产品"+jfjl.getJfjlvo()[i].getProName(),"交付");
            }
        }
        if(count == 1){
            log.debug("交付记录：{}",jfjl);
            ordertableDao.updateJiaoFu(jfjl.getJfId(),new Date());
            ordertableDao.insertChuKu(jfjl.getJfId(),ck_id);
            for(int i=0;i<jfjl.getJfjlvo().length;i++){
                ordertableDao.insertChuKuPro(jfjl.getJfjlvo()[i].getNumber(),jfjl.getJfjlvo()[i].getProId(),jfjl.getJfId());
            }
        }
        return count;
    }
}
