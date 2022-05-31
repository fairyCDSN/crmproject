package com.trkj.crmproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.ParecordDao;
import com.trkj.crmproject.entity.Caigousq;
import com.trkj.crmproject.entity.Parecord;
import com.trkj.crmproject.service.ParecordService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.ParecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParecordServiceImpl implements ParecordService {

    @Autowired
    private ParecordDao dao;

    @Override
    public int addfkjh(Parecord parecord) {
        return dao.insert(parecord);
    }

    @Override
    public int upfk(Parecord parecord,int sqid) {
        System.out.println("进入添加审批状态方法");
        UpdateWrapper<Parecord> uw=new UpdateWrapper<>();
        System.out.println("我是方法中传的实体类的实体类parecord:"+parecord);
        System.out.println("sqid:"+sqid);
        uw.set("state_id",parecord.getStateId()).set("sqid",sqid).eq("pa_id",parecord.getPaId());
        int row=dao.update(null,uw);
        return row;
    }

    @Override
    public PageInfo<ParecordVo> findfkjh(int pageNum, int pageSize) {
        Page<ParecordVo> page= PageHelper.startPage(pageNum,pageSize);
        List<ParecordVo> list=dao.findfkjh();
        Page<ParecordVo> depts=new Page<>();
        BeanTools.copyList(list,depts,ParecordVo.class);
        PageInfo<ParecordVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo<ParecordVo> selectfkjh(int pageNum, int pageSize,String cgDh,Integer total) {
        Page<ParecordVo> page= PageHelper.startPage(pageNum,pageSize);
        System.out.println("我是采购单号"+cgDh);
        List<ParecordVo> list=dao.selectfkjh(cgDh,total);
        Page<ParecordVo> depts=new Page<>();
        BeanTools.copyList(list,depts,ParecordVo.class);
        PageInfo<ParecordVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public ParecordVo selectpayment(int paId) {
        ParecordVo i=dao.selectpayment(paId);
        System.out.println("我是查询出来的"+i);
        return i;
    }
}
