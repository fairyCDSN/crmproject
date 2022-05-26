package com.trkj.crmproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CggoodsDao;
import com.trkj.crmproject.entity.Cggoods;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.CggoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CggoodsServiceImpl implements CggoodsService {

    @Autowired
    private CggoodsDao dao;

    @Override
    public PageInfo<CggoodsVo> findgoods(int pageNum, int pageSize) {
        Page<CggoodsVo> page= PageHelper.startPage(pageNum,pageSize);
        List<CggoodsVo> list=dao.findgoods();
        Page<CggoodsVo> cggoods=new Page<>();
        System.out.println("这是impl层"+list);
        BeanTools.copyList(list,cggoods,CggoodsVo.class);
        PageInfo<CggoodsVo> pageInfo=new PageInfo<>(cggoods);
        return pageInfo;
    }

    @Override
    public PageInfo<CggoodsVo> selectgoods(int pageNum, int pageSize, String gdName) {
        Page<CggoodsVo> page= PageHelper.startPage(pageNum,pageSize);
        List<CggoodsVo> list=dao.selectgoods(gdName);
        Page<CggoodsVo> cggoods=new Page<>();
        System.out.println("这是impl层"+list);
        BeanTools.copyList(list,cggoods,CggoodsVo.class);
        PageInfo<CggoodsVo> pageInfo=new PageInfo<>(cggoods);
        return pageInfo;
    }

    @Override
    public PageInfo<CggoodsVo> updategoods(Integer gdNumber,Integer gdId,int pageNum,int pageSize,String gdname) {
        UpdateWrapper<Cggoods> uw=new UpdateWrapper<>();
        uw.set("gd_number",gdNumber+1).eq("gd_Id",gdId);
        int update=dao.update(null,uw);
        Page<CggoodsVo> page= PageHelper.startPage(pageNum,pageSize);
        List<CggoodsVo> list=dao.selectgoods(gdname);
        Page<CggoodsVo> cggoods=new Page<>();
        System.out.println("这是impl层"+list);
        BeanTools.copyList(list,cggoods,CggoodsVo.class);
        PageInfo<CggoodsVo> pageInfo=new PageInfo<>(cggoods);
        return pageInfo;
    }

    @Override
    public PageInfo<CggoodsVo> updategoodsjs(Integer gdNumber,Integer gdId,int pageNum,int pageSize,String gdname) {
        UpdateWrapper<Cggoods> uw=new UpdateWrapper<>();
        uw.set("gd_number",gdNumber-1).eq("gd_Id",gdId);
        int update=dao.update(null,uw);
        Page<CggoodsVo> page= PageHelper.startPage(pageNum,pageSize);
        List<CggoodsVo> list=dao.selectgoods(gdname);
        Page<CggoodsVo> cggoods=new Page<>();
        System.out.println("这是impl层"+list);
        BeanTools.copyList(list,cggoods,CggoodsVo.class);
        PageInfo<CggoodsVo> pageInfo=new PageInfo<>(cggoods);
        return pageInfo;
    }
}
