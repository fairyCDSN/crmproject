package com.trkj.crmproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.SupplierDao;
import com.trkj.crmproject.entity.Supplier;
import com.trkj.crmproject.service.SupplierService;
import com.trkj.crmproject.util.BeanTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao dao;

    @Override
    public List<Supplier> selectsupname() {
        QueryWrapper<Supplier> qw=new QueryWrapper<>();
        qw.select("supplier_id","supplier_name");
        List<Supplier> list=dao.selectList(qw);
        return list;
    }

    @Override
    public PageInfo<Supplier> findsupplier(int pageNum,int pageSize) {
        Page<Supplier> page= PageHelper.startPage(pageNum,pageSize);
        List<Supplier> list=dao.findsupplier();
        Page<Supplier> deps=new Page<>();
        BeanTools.copyList(list,deps,Supplier.class);
        PageInfo<Supplier> pageInfo=new PageInfo<>(deps);
        return pageInfo;
    }

    @Override
    public List<String> findsuptype() {
        return dao.findsuptype();
    }

    @Override
    public PageInfo<Supplier> selectsupplier(int pageNum, int pageSize, String suppliername, String suppliertype) {
        Page<Supplier> page= PageHelper.startPage(pageNum,pageSize);
        List<Supplier> list=dao.selectsupplier(suppliername,suppliertype);
        Page<Supplier> deps=new Page<>();
        BeanTools.copyList(list,deps,Supplier.class);
        PageInfo<Supplier> pageInfo=new PageInfo<>(deps);
        return pageInfo;
    }

    @Override
    public int addSupplier(Supplier supplier) {
        return dao.insert(supplier);
    }

    @Override
    public int delectsupplier(int supplierId) {
        UpdateWrapper<Supplier> uw=new UpdateWrapper<>();
        uw.set("use_status",2).eq("supplier_id",supplierId);
        int row = dao.update(null,uw);
        return row;
    }

    @Override
    public String selectsuptype(int supplierId) {
        return dao.selectsuptype(supplierId);
    }
}
