package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.ProCk;
import com.trkj.crmproject.vo.ProductVo;
import com.trkj.crmproject.entity.mybatis_plus.Product;
import com.trkj.crmproject.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductDao extends BaseMapper<Product> {
    //商品清单  查询全部（根据ckId外键查询到ckName）
    public List<ProductVo> selectProckName();

    //商品清单  查询全部（根据proName模糊查询）
//    public List<ProductVo> selectProNamelike(String proName);
    public List<ProductVo> selectProNamelike(@Param("pro_name") String proName,@Param("cat_name") String catName,@Param("ck_name") String ckName);

    //商品清单  查询全部（选择下拉框，根据catName查询）
    public List<ProductVo> selectProcatNnameAll(String catName);
    //商品清单  根据ckName查询全部（下拉框）
    public List<ProductVo> selectProckNameAll(String ckName);

    // 商品清单  查询商品详情
    public ProductVo selectProIdxq(int proId);



    //商品清单 根据ckid查询商品
    public List<ProductVo> selectProckId(int ckId);
    //商品清单 根据ckid,proId查询商品的库存
    public int selectProckIdAndproId(@Param("ck_id") int ckId ,@Param("pro_id") int proId);

    //商品清单  根据仓库ID，商品ID，报损报溢的查询数量修改库存
    int updateProCkNumber(ProCk proCk);

    //商品清单 修改商品介绍
    int updateProsay(ProductVo productVo);

    //盘点单  根据盘点ID查询商品
    List<ProductVo> selectPdIdproAll(int pdId);


    //李玉春的代码
    //查询所有产品以及条件查询
    public List<ProductVo> findproduct(@Param("pro_name") String pro_name,@Param("pro_type") String pro_type);
    //添加报价表和产品表的中间表
    public int insertProduct(@Param("proId") int proId,@Param("bjid") int bjid,@Param("sl") int sl,
                             @Param("mo") int mo);
    public int insertProduct1(@Param("proId") int proId,@Param("bjid") int bjid,@Param("sl") int sl,@Param("mo") int mo);

    public List<ProductVo> findproduct1(@Param("bjid") int bjid,@Param("pro_name") String pro_name,
                                        @Param("pro_type") String pro_type);
    public int[] cheackProId(int bjid);
}
