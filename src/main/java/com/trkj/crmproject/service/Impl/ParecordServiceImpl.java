package com.trkj.crmproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CaigouDao;
import com.trkj.crmproject.dao.ParecordDao;
import com.trkj.crmproject.entity.Caigou;
import com.trkj.crmproject.entity.Parecord;
import com.trkj.crmproject.service.ParecordService;
import com.trkj.crmproject.util.BeanTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParecordServiceImpl implements ParecordService {

    @Autowired
    private ParecordDao dao;

    @Autowired
    private CaigouDao caigouDao;

    @Override
    public PageInfo<Parecord> findrb(int pageNum, int pageSize) {
        System.out.println("这是分页页数"+pageNum);
        PageHelper.clearPage();
        Page<Parecord> page= PageHelper.startPage(pageNum,pageSize);
        System.out.println("这是分页页数"+page);
        List<Parecord> list=dao.selectfk();
        System.out.println("==============="+list);
        Page<Parecord> depts=new Page<>();
        System.out.println("这是分页查出来的"+depts);
        BeanTools.copyList(list,depts,Parecord.class);
        PageInfo<Parecord> pageInfo=new PageInfo<>(depts);
        System.out.println("这是分页查询的对象"+pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo<Parecord> selectfk(int paId, int pageNum, int pageSize) {
        Page<Parecord> page=PageHelper.startPage(pageNum,pageSize);
        List<Parecord> parecords=dao.pagefk(paId);
        Page<Parecord> d=new Page<>();
        BeanTools.copyList(parecords,d,Parecord.class);
        PageInfo<Parecord> pageInfo=new PageInfo<>(d);
        return pageInfo;
    }

    @Override
    public int addfkjh(Parecord parecord) {
        int row =dao.insert(parecord);
        UpdateWrapper<Caigou> uw=new UpdateWrapper<>();
        String use="在使用";
        uw.set("usestate",use).eq("cg_id",parecord.getCgId());
        int update=caigouDao.update(null,uw);
        return row;
    }

}
