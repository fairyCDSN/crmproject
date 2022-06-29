package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.JiaoFuDao;
import com.trkj.crmproject.dao.PcPlanDao;
import com.trkj.crmproject.entity.JiaoFu;
import com.trkj.crmproject.entity.PcPlan;
import com.trkj.crmproject.service.JiaoFuService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.JiaoFuVo;
import com.trkj.crmproject.vo.PcPlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JiaoFuServiceImpl implements JiaoFuService {
    @Autowired
    private JiaoFuDao jiaoFuDao;

    @Override
    public PageInfo<JiaoFuVo> findJiaoFu(int pageNum, int pageSize,String qs,String state,String user_name) {
        Page<JiaoFu> page= PageHelper.startPage(pageNum,pageSize);
        int[] order_id=jiaoFuDao.findorderId();
        List<JiaoFu> list = new ArrayList<>();
        for(int i=0;i<order_id.length;i++){
            JiaoFu jiaoFu =jiaoFuDao.findJiaoFu(order_id[i],qs,state);
            String time=jiaoFuDao.findmint(order_id[i])+"~"+jiaoFuDao.findmaxt(order_id[i]);
            jiaoFu.setTime(time);
            if(jiaoFu.getMaxstate().equals("交付完成")){
                jiaoFu.setState("交付完成");
            }else if(jiaoFu.getMaxstate().equals("待执行") || jiaoFu.getMaxstate().equals("正在出库")){
                if(jiaoFu.getMinstate().equals("正在出库") || jiaoFu.getMinstate().equals("交付完成")){
                    jiaoFu.setState("正在交付");
                }else if(jiaoFu.getMinstate().equals("待执行")){
                    jiaoFu.setState("待执行");
                }
            }else if(jiaoFu.getMinstate().equals("待执行")){
                jiaoFu.setState("待执行");
            }
            if(jiaoFu.getOrderId1()!=0) {
                if(jiaoFu.getCjr().equals(user_name)) {
                    list.add(jiaoFu);
                }
            }
        }
        Page<JiaoFuVo> jiaoFus=new Page<>();
        BeanTools.copyList(list,jiaoFus,JiaoFuVo.class);
        PageInfo<JiaoFuVo> pageInfo=new PageInfo<>(jiaoFus);
        return pageInfo;
    }
}
