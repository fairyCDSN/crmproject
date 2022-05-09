package com.trkj.crmproject.service;

import com.trkj.crmproject.dao.ProductDao;
import com.trkj.crmproject.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    //商品清单  全部查询
    @Override
    public List<Product> selectProductAll() {
        return productDao.selectList(null);
    }
}
