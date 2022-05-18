package com.trkj.crmproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.crmproject.dao.SupplierDao;
import com.trkj.crmproject.entity.Supplier;
import com.trkj.crmproject.service.SupplierService;
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
}
