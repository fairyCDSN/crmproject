package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Category;
import com.trkj.crmproject.entity.mybatis_plus.Product;
import com.trkj.crmproject.vo.ProductVo;

import java.util.List;

public interface ProductService {
    //商品清单  查询全部
//    public List<Product> selectProductAll();

    //商品清单  根据ID查询
//    public Product selectProId(int proId);


    //分页
    public PageInfo<ProductVo> findpro(int pageNum, int pageSize);


    //商品清单  查询全部（根据pro_id外键查询到pro_ck表的pro_ck_number的和）
    public List<ProductVo> selectProckName();

    //商品清单  查询全部类别
    public List<Category> selectCatAll();


    //商品清单  查询全部（根据proName模糊查询）
    public List<ProductVo> selectProNamelike(String proName);

    //商品清单  查询全部（选择下拉框，根据catName查询）
    public List<ProductVo> selectProcatNnameAll(String catName);
    //商品清单  根据ckName查询全部（下拉框）
    public List<ProductVo> selectProckNameAll(String ckName);

    // 商品清单  查询商品详情
    public ProductVo selectProIdxq(int proId);


    //zsy
    public List<Product> selectcpname();
}
