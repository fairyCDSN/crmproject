package com.trkj.crmproject.service;

import com.trkj.crmproject.entity.Product;
import com.trkj.crmproject.vo.ProductVo;

import java.util.List;

public interface ProductService {
    //商品清单  查询全部
    public List<Product> selectProductAll();

    //商品清单  根据ID查询
    public Product selectProId(int proId);

    //商品清单  修改
    public int updatePro(Product product);


    //商品清单  查询全部（根据ckId外键查询到ckName）
    public List<ProductVo> selectProckName();

    //商品清单  查询全部（根据proName模糊查询）
    public List<ProductVo> selectProNamelike(String proName);

    //商品清单  查询全部（选择下拉框，根据ckName模糊查询）
    public List<ProductVo> selectProckNamexz(String ckName);
}
