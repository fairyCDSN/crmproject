package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.vo.ProductVo;
import com.trkj.crmproject.entity.mybatis_plus.Product;
import com.trkj.crmproject.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductDao extends BaseMapper<Product> {
    //商品清单  查询全部（根据ckId外键查询到ckName）
    public List<ProductVo> selectProckName();

    //商品清单  查询全部（根据proName模糊查询）
    public List<ProductVo> selectProNamelike(String proName);

    //商品清单  查询全部（选择下拉框，根据catName查询）
    public List<ProductVo> selectProcatNnameAll(String catName);
    //商品清单  根据ckName查询全部（下拉框）
    public List<ProductVo> selectProckNameAll(String ckName);

    // 商品清单  查询商品详情
    public ProductVo selectProIdxq(int proId);


}
