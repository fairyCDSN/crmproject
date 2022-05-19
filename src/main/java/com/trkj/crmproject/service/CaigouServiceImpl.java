package com.trkj.crmproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CaigouDao;
import com.trkj.crmproject.dao.CaigousqDao;
import com.trkj.crmproject.entity.Caigou;
import com.trkj.crmproject.entity.Caigousq;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.util.BeanTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaigouServiceImpl implements CaigouService {

    @Autowired
    private CaigouDao dao;

    @Autowired
    private CaigousqDao caigousqDao;

    @Override
    public PageInfo<Caigou> findcaigou(int pageNum, int pageSize) {
        Page<Caigou> page = PageHelper.startPage(pageNum,pageSize);
        List<Caigou> list=dao.findcaigou();
        Page<Caigou> d=new Page<>();
        BeanTools.copyList(list,d,Caigou.class);
        PageInfo<Caigou> pageInfo=new PageInfo<>(d);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo<Caigou> selectcaigou(int pageNum, int pageSize, String state) {
        QueryWrapper<Caigou> qw=new QueryWrapper<>();
        if (state!=""){
            qw.eq("state",state);
        }
        Page<Caigou> page=PageHelper.startPage(pageNum,pageSize);
        List<Caigou> list=dao.selectList(qw);
        Page<Caigou> d=new Page<>();
        BeanTools.copyList(list,d,Caigou.class);
        PageInfo<Caigou> pageInfo=new PageInfo<>(d);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public int addsgdd(Caigou caigou) {
//        int row = dao.insert(caigou);
//        if (row==0){
//            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据插入失败");
//        }
//        UpdateWrapper<Caigousq> uw=new UpdateWrapper<>();
//        String use="在使用";
//        uw.set("usestate",use).eq("sqid",caigou.getSqid());
//        int update=caigousqDao.update(null,uw);
//        if (update==0){
//            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"修改失败");
//        }
        return 0;
    }

    @Override
    public List<Caigou> selectfkcgid() {
        List<Caigou> caigous=dao.selectfkcgid();
        System.out.println("=======我在impl"+caigous);
        return caigous;
    }
}
