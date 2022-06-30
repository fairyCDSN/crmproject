package com.trkj.crmproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CggoodsDao;
import com.trkj.crmproject.entity.Cggoods;
import com.trkj.crmproject.service.CggoodsService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.CggoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CggoodsServiceImpl implements CggoodsService {

    @Autowired
    private CggoodsDao dao;

    @Override
    public PageInfo<CggoodsVo> findgoods(int pageNum, int pageSize) {
        Page<CggoodsVo> page = PageHelper.startPage(pageNum, pageSize);
        List<CggoodsVo> list = dao.findgoods();
        Page<CggoodsVo> cggoods = new Page<>();
        System.out.println("这是impl层" + list);
        BeanTools.copyList(list, cggoods, CggoodsVo.class);
        PageInfo<CggoodsVo> pageInfo = new PageInfo<>(cggoods);
        return pageInfo;
    }

    @Override
    public PageInfo<CggoodsVo> selectgoods(int pageNum, int pageSize, String gdName ,String type) {
        Page<CggoodsVo> page = PageHelper.startPage(pageNum, pageSize);
        List<CggoodsVo> list = dao.selectgoods(gdName,type);
        Page<CggoodsVo> cggoods = new Page<>();
        System.out.println("这是impl层" + list);
        BeanTools.copyList(list, cggoods, CggoodsVo.class);
        PageInfo<CggoodsVo> pageInfo = new PageInfo<>(cggoods);
        return pageInfo;
    }

    @Override
    @Transactional
    public PageInfo<CggoodsVo> updategoods(Integer gdNumber, Integer gdId, int pageNum, int pageSize, String gdname,String type) {
        UpdateWrapper<Cggoods> uw = new UpdateWrapper<>();
        uw.set("gd_number", gdNumber + 1).eq("gd_Id", gdId);
        int update = dao.update(null, uw);
        Page<CggoodsVo> page = PageHelper.startPage(pageNum, pageSize);
        List<CggoodsVo> list = dao.selectgoods(gdname,type);
        Page<CggoodsVo> cggoods = new Page<>();
        System.out.println("这是impl层" + list);
        BeanTools.copyList(list, cggoods, CggoodsVo.class);
        PageInfo<CggoodsVo> pageInfo = new PageInfo<>(cggoods);
        return pageInfo;
    }

    @Override
    @Transactional
    public PageInfo<CggoodsVo> updategoodsjs(Integer gdNumber, Integer gdId, int pageNum, int pageSize, String gdname,String type) {
        UpdateWrapper<Cggoods> uw = new UpdateWrapper<>();
        uw.set("gd_number", gdNumber - 1).eq("gd_Id", gdId);
        int update = dao.update(null, uw);
        Page<CggoodsVo> page = PageHelper.startPage(pageNum, pageSize);
        List<CggoodsVo> list = dao.selectgoods(gdname,type);
        Page<CggoodsVo> cggoods = new Page<>();
        System.out.println("这是impl层" + list);
        BeanTools.copyList(list, cggoods, CggoodsVo.class);
        PageInfo<CggoodsVo> pageInfo = new PageInfo<>(cggoods);
        return pageInfo;
    }

    @Override
    public List<Cggoods> findsCggoods(int supplierId) {
        QueryWrapper<Cggoods> qw = new QueryWrapper<>();
        qw.eq("supplier_id", supplierId);
        List<Cggoods> i = dao.selectList(qw);
        return i;
    }

    @Override
    @Transactional
    public int addgoods(Cggoods cggoods) {
        return dao.insert(cggoods);
    }

    @Override
    public String yzgoodname(int supplierId, String goodname) {
        System.out.println("进入实现类方法"+goodname+supplierId);
        return dao.yzgoodname(supplierId,goodname);
    }

    @Override
    public List<String> findgoodstype() {
        return dao.findgoodstype();
    }
}
