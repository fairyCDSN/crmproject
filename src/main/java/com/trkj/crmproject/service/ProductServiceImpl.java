package com.trkj.crmproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.crmproject.dao.ProductDao;
import com.trkj.crmproject.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao dao;

    @Override
    public List<Product> selectcpname() {
        QueryWrapper<Product> qw=new QueryWrapper<>();
        qw.select("pro_id","pro_name");
        List<Product> list=dao.selectList(qw);
        return list;
    }
}
