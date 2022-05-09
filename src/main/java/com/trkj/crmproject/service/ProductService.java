package com.trkj.crmproject.service;

import com.trkj.crmproject.entity.Product;

import java.util.List;

public interface ProductService {
    //商品清单  查询全部
    public List<Product> selectProductAll();
}
