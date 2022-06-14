package com.trkj.crmproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CategoryDao;
import com.trkj.crmproject.dao.ProductDao;
import com.trkj.crmproject.entity.Category;
import com.trkj.crmproject.entity.ProCk;
import com.trkj.crmproject.entity.mybatis_plus.Product;
import com.trkj.crmproject.service.ProductService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    //商品清单  全部查询
//    @Override
//    public List<Product> selectProductAll() {
//        return productDao.selectList(null);
//    }

    //商品清单  根据ID查询
//    public Product selectProId(int proId){
//        return productDao.selectById(proId);
//    }

    //分页
    public PageInfo<ProductVo> findpro(int pageNum, int pageSize){
        Page<ProductVo> page= PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> list=productDao.selectProckName();
        Page<ProductVo> depts=new Page<>();
        BeanTools.copyList(list,depts,ProductVo.class);
        PageInfo<ProductVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //商品清单  查询全部（根据ckId外键查询到ckName）
    @Override
    public List<ProductVo> selectProckName() {
        return productDao.selectProckName();
    }

    //商品清单  查询全部类别
    public List<Category> selectCatAll(){
        return categoryDao.selectList(null);
    }


    //商品清单  查询全部（根据proName模糊查询）
    @Override
//    public List<ProductVo> selectProNamelike(String proName) {
//        return productDao.selectProNamelike(proName);
//    }
    public List<ProductVo> selectProNamelike(String proName,String catName,String ckName) {

        return productDao.selectProNamelike(proName,catName,ckName);
    }

    //商品清单  查询全部（选择下拉框，根据catName查询）
    @Override
    public List<ProductVo> selectProcatNnameAll(String catName){
        return productDao.selectProcatNnameAll(catName);
    }
    //商品清单  根据ckName查询全部（下拉框）
    @Override
    public List<ProductVo> selectProckNameAll(String ckName){
        return productDao.selectProckNameAll(ckName);
    }


    // 商品清单  查询商品详情
    @Override
    public ProductVo selectProIdxq(int proId){
        return productDao.selectProIdxq(proId);
    }



    //商品清单 根据ckid查询商品
    @Override
    public List<ProductVo> selectProckId(int ckId){
        return productDao.selectProckId(ckId);
    }

    //商品清单 根据ckid,proId查询商品的库存
    @Override
    public int selectProckIdAndproId(int ckId , int proId){
        return productDao.selectProckIdAndproId(ckId,proId);
    }

    //商品清单  根据仓库ID，商品ID，报损报溢的查询数量修改库存
    @Override
    public int updateProCkNumber(ProCk proCk){
       return productDao.updateProCkNumber(proCk);
    }

    //盘点单  根据盘点ID查询商品
    @Override
    public List<ProductVo> selectPdIdproAll(int pdId){
        return productDao.selectPdIdproAll(pdId);
    }


    //zys
    @Override
    public List<Product> selectcpname() {
        QueryWrapper<Product> qw=new QueryWrapper<>();
        qw.select("pro_id","pro_name");
        List<Product> list=productDao.selectList(qw);
        return list;
    }

}
