package com.trkj.crmproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CaigousqDao;
import com.trkj.crmproject.entity.Caigousq;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.util.BeanTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaigousqServiceImpl implements CaigousqService {

    @Autowired
    private CaigousqDao dao;

    //点击添加按钮，查询下拉框的值
    @Override
    public List<Caigousq> selectsupname() {
        return dao.selectsupname();
    }

    @Override
    public PageInfo<Caigousq> findpur(int pageNum, int pageSize) {
        Page<Caigousq> page= PageHelper.startPage(pageNum,pageSize);
        List<Caigousq> list=dao.selectList(null);
        Page<Caigousq> depts=new Page<>();
        BeanTools.copyList(list,depts,Caigousq.class);
        PageInfo<Caigousq> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo<Caigousq> selectPurchaseplan(int pageNum, int pageSize, Integer sqid, Integer supplierId, String type) {
        QueryWrapper<Caigousq> qw=new QueryWrapper<>();
        if(sqid!=0){
            qw.eq("sqid",sqid);
        }
        if(supplierId!=0){
            qw.eq("supplier_id",supplierId);
        }
        if(type!=""){
            qw.eq("type",type);
        }
        Page<Caigousq> page=PageHelper.startPage(pageNum,pageSize);
        List<Caigousq> pur= dao.selectList(qw);
        Page<Caigousq> d=new Page<>();
        BeanTools.copyList(pur,d,Caigousq.class);
        PageInfo<Caigousq> pageInfo=new PageInfo<>(d);
        return pageInfo;
    }

    @Override
    public int addcaigousq(Caigousq caigousq) {
        System.out.println("进入imp==============="+caigousq);
        int row=dao.insert(caigousq);
        if (row==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据插入失败");
        }
        return row;
    }

    @Override
    public List<Caigousq> selectsqid() {
        return dao.selectsqid();
    }

    @Override
    public int updatestate(int sqid, String usestate) {
        UpdateWrapper<Caigousq> uw=new UpdateWrapper<>();
        uw.set("usestate",usestate).eq("sqid",sqid);
        int update=dao.update(null,uw);
        return update;
    }

}
