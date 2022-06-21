package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Category;
import com.trkj.crmproject.entity.ProCk;
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
//    public List<ProductVo> selectProNamelike(String proName);
    public List<ProductVo> selectProNamelike(String proName,String catName,String ckName);


    //商品清单  查询全部（选择下拉框，根据catName查询）
    public List<ProductVo> selectProcatNnameAll(String catName);
    //商品清单  根据ckName查询全部（下拉框）
    public List<ProductVo> selectProckNameAll(String ckName);
    public PageInfo<ProductVo> findprockName(String ckName,int pageNum, int pageSize);

    // 商品清单  查询商品详情
    public ProductVo selectProIdxq(int proId);



    //商品清单 根据ckid查询商品
    public List<ProductVo> selectProckId(int ckId);

    //商品清单 根据ckid,proId查询商品的库存
    public int selectProckIdAndproId(int ckId , int proId);

    //商品清单  根据仓库ID，商品ID，报损报溢的查询数量修改库存
    int updateProCkNumber(ProCk proCk);

    //盘点单  根据盘点ID查询商品
    List<ProductVo> selectPdIdproAll(int pdId);
    PageInfo<ProductVo> findPdIdpro(int pdId,int pageNum, int pageSize);


    //zsy
    public List<Product> selectcpname();
}
