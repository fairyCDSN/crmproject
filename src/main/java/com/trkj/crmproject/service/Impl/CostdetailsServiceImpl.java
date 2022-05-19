package com.trkj.crmproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CostdetailsDao;
import com.trkj.crmproject.entity.reimbursement;
import com.trkj.crmproject.service.CostdetailsService;
import com.trkj.crmproject.util.BeanTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostdetailsServiceImpl implements CostdetailsService {

    @Autowired
    private CostdetailsDao dao;

    @Override
    public PageInfo<reimbursement> selectbx(String reimbursementType,int pageNum,int pageSize) {
        QueryWrapper<reimbursement> qw=new QueryWrapper<>();
        //qw.eq("cd_type",cdType).eq("reimburse",reimburse);
        //List<Costdetails> costdetails= dao.selectList(qw);
        //return costdetails;
        if(reimbursementType!=""){
            System.out.println(reimbursementType+":=================");
            qw.eq("reimbursement_type",reimbursementType);
        }
        Page<reimbursement> page= PageHelper.startPage(pageNum,pageSize);
        List<reimbursement> costdetails=dao.selectList(qw);
        Page<reimbursement> d=new Page<>();
        BeanTools.copyList(costdetails,d,reimbursement.class);
        PageInfo<reimbursement> pageInfo=new PageInfo<>(d);
        System.out.println("Page===================="+pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo<reimbursement> findrb(int pageNum, int pageSize) {
        Page<reimbursement> page= PageHelper.startPage(pageNum,pageSize);
        List<reimbursement> list=dao.selectList(null);
        Page<reimbursement> depts=new Page<>();
        BeanTools.copyList(list,depts,reimbursement.class);
        PageInfo<reimbursement> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public IPage<reimbursement> selectpage(reimbursement vo) {
//        QueryWrapper<Costdetails> qw=new QueryWrapper<>();
////        IPage<Costdetails> page=new Page<>(vo.getCurrent(),vo.getSize());
//        IPage<Costdetails> page=new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(vo.getCurrent(),vo.getSize());
//        if (vo.getCdType()==0&&vo.getReimburse()==0)
//        qw.eq("cd_type",vo.getCdType()).eq("reimburse",vo.getReimburse());
//        if(vo.getCdType()!=0){
//            System.out.println(vo.getCdType()+"cdType:=================");
//            qw.eq("cd_type",vo.getCdType());
//        }
//        if(vo.getReimburse()!=0){
//            System.out.println(vo.getReimburse()+"reimburse:=================");
//            qw.eq("reimburse",vo.getReimburse());
//        }
//        return dao.selectPage(page,qw);
        return null;
    }

    @Override
    public reimbursement selectmx(int cdId) {
        QueryWrapper<reimbursement> qw=new QueryWrapper<>();
        qw.eq("cd_id",cdId);
        reimbursement reimbursement = dao.selectOne(qw);
//        reimbursement vo=new reimbursementVo();
        return reimbursement;
    }

    @Override
    public int updateup(int up,int cdId) {
        UpdateWrapper<reimbursement> uw=new UpdateWrapper<>();
        uw.eq("cd_id",cdId).set("reimburse",up);
        int update = dao.update(null, uw);
        return update;
    }
}
