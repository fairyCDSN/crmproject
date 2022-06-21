package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.OrdertableDao;
import com.trkj.crmproject.dao.PcPlanDao;
import com.trkj.crmproject.entity.OrderTable;
import com.trkj.crmproject.entity.PcPlan;
import com.trkj.crmproject.service.PcPlanService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.OrderTableVo;
import com.trkj.crmproject.vo.PcPlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PcPlanServiceImpl implements PcPlanService {
    @Autowired
    private PcPlanDao pcPlanDao;

    @Override
    public PageInfo<PcPlanVo> findPcplan(int pageNum, int pageSize,String qs, String state, String monery1, String monery2,String user_name) {
        Page<PcPlan> page= PageHelper.startPage(pageNum,pageSize);
        int[] order_id=pcPlanDao.findorderId();
        List<PcPlan> list = new ArrayList<>();
        for(int i=0;i<order_id.length;i++){
            PcPlan pcPlan =pcPlanDao.findPcplan(order_id[i],qs,state,monery1,monery2,user_name);
            String time=pcPlanDao.findmint(order_id[i])+"~"+pcPlanDao.findmaxt(order_id[i]);
            pcPlan.setTime(time);
            if(pcPlan.getOrderId1()!=0){
                if(pcPlan.getPcpel().equals(user_name)) {
                    list.add(pcPlan);
                }
            }
        }
        Page<PcPlanVo> pcPlans=new Page<>();
        BeanTools.copyList(list,pcPlans,PcPlanVo.class);
        PageInfo<PcPlanVo> pageInfo=new PageInfo<>(pcPlans);
        return pageInfo;
    }

}
