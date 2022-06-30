package com.trkj.crmproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CaigousqDao;
import com.trkj.crmproject.entity.Caigousq;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.CaigousqService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.CaigousqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CaigousqServiceImpl implements CaigousqService {

    @Autowired
    private CaigousqDao dao;

    //点击添加按钮，查询下拉框的值
    @Override
    public List<Caigousq> selectsupname() {
//        return dao.selectsupname();
        return null;
    }

    @Override
    public PageInfo<Caigousq> findpur(int pageNum, int pageSize) {
        Page<Caigousq> page= PageHelper.startPage(pageNum,pageSize);
        List<Caigousq> list=dao.findcgsq();
        Page<Caigousq> depts=new Page<>();
        BeanTools.copyList(list,depts,Caigousq.class);
        PageInfo<Caigousq> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo<Caigousq> selectPurchaseplan(int pageNum, int pageSize, Integer sqid, Integer supplierId, String type) {
//        QueryWrapper<Caigousq> qw=new QueryWrapper<>();
//        if(sqid!=0){
//            qw.eq("sqid",sqid);
//        }
//        if(supplierId!=0){
//            qw.eq("supplier_id",supplierId);
//        }
//        if(type!=""){
//            qw.eq("type",type);
//        }
//        Page<Caigousq> page=PageHelper.startPage(pageNum,pageSize);
//        List<Caigousq> pur= dao.selectList(qw);
//        Page<Caigousq> d=new Page<>();
//        BeanTools.copyList(pur,d,Caigousq.class);
//        PageInfo<Caigousq> pageInfo=new PageInfo<>(d);
//        return pageInfo;
        return null;
    }

    @Override
    @Transactional
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
//        return dao.selectsqid();
        return null;
    }

    @Override
    @Transactional
    public int updatestate(int sqid, String usestate) {
//        UpdateWrapper<Caigousq> uw=new UpdateWrapper<>();
//        uw.set("usestate",usestate).eq("sqid",sqid);
//        int update=dao.update(null,uw);
//        return update;
        return 0;
    }

    @Override
    public PageInfo<Caigousq> selectcgsqdd(int pageNum, int pageSize, String cgDh, Integer total, String type) {
//        QueryWrapper<Caigousq> qw=new QueryWrapper<>();
//        if (cgDh!=""){
//            qw.like("cg_dh",cgDh);
//        }
//        if (total!=0){
//            qw.between("total",0,total);
//        }
        if (total==null){
            total=0;
        }
        Page<Caigousq> page=PageHelper.startPage(pageNum,pageSize);
        List<Caigousq> pur= dao.selectcgsqdd(cgDh,total,type);
        Page<Caigousq> d=new Page<>();
        BeanTools.copyList(pur,d,Caigousq.class);
        PageInfo<Caigousq> pageInfo=new PageInfo<>(d);
        return pageInfo;
    }

    @Override
    public List<CaigousqVo> selectcgmx(int sqid) {
        return dao.selectcgmx(sqid);
    }

    @Override
    public Caigousq selectcgsqid(int sqid) {
        Caigousq caigousq=dao.selectById(sqid);
        System.out.println("我在impl层"+caigousq);
        return caigousq;
    }

    @Override
    public int addcgsq(Caigousq caigousq) {
        return dao.insert(caigousq);
    }

    @Override
    @Transactional
    public int updatecgsq(int stateId,int sqid) {
        System.out.println("进入添加审批状态方法");
        UpdateWrapper<Caigousq> uw=new UpdateWrapper<>();
        uw.set("state_id",stateId).eq("sqid",sqid);
        int row=dao.update(null,uw);
        return row;
    }

}
