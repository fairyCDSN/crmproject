package com.trkj.crmproject.service;

import com.trkj.crmproject.dao.ProductDao;
import com.trkj.crmproject.entity.Product;
import com.trkj.crmproject.vo.ProductVo;
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

    //商品清单  根据ID查询
    public Product selectProId(int proId){
        return productDao.selectById(proId);
    }

    //商品清单  修改
    public int updatePro(Product product){

        return productDao.updateById(product);
    }


    //商品清单  查询全部（根据ckId外键查询到ckName）
    @Override
    public List<ProductVo> selectProckName() {
        return productDao.selectProckName();
    }

    //商品清单  查询全部（根据proName模糊查询）
    @Override
    public List<ProductVo> selectProNamelike(String proName) {
        return productDao.selectProNamelike(proName);
    }

    //商品清单  查询全部（选择下拉框，根据ckName模糊查询）
    public List<ProductVo> selectProckNamexz(String ckName){
        return productDao.selectProckNamexz(ckName);
    }
}
