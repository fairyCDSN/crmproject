package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.ProCk;
import com.trkj.crmproject.entity.mybatis_plus.ProCatMp;
import com.trkj.crmproject.entity.mybatis_plus.RkMp;
import com.trkj.crmproject.entity.mybatis_plus.RkProMp;
import com.trkj.crmproject.vo.ProductVo;
import com.trkj.crmproject.vo.RkVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RkDao extends BaseMapper<RkMp> {

    //入库表 查询入库表全部（连仓库，审批类别查）\
    List<RkVo> selectRkall();


    //入库表 根据仓库名称查询全部
    List<RkVo> selectRkckName(String ckName);
    //入库表 根据入库状态查询
    List<RkVo> selectRkstate(String state);
    //入库表 根据仓库名称 商品状态查询全部
    List<RkVo> selectRkckstate(String ckName,String state);

    //入库表 根据入库id查询入库信息
    RkVo selectRkxq(int rkId);
    //入库表 根据入库id查询商品及入库数量
    List<ProductVo> selectRkpro(int rkId);

    //入库表 修改备注
    int updateRkbz(RkVo rkVo);

    //入库表 添加商品（查询商品的最大id）
    int selectPromax();

    //入库表 查询商品的最大编号
    int selectRkpromax();
    //入库表 根据类别名称查询类别ID
    int selectRkcatid(String catName);

    // 添加商品类别中间表
    int insertproCat(ProCatMp proCatMp);

    //入库表 查询入库表的最大id
    int selectRkidmax();
    //入库表，根据商品名称查商品
    ProductVo selectRkproname(String proName);
    // 添加入库表
    int insertRk(RkMp rkMp);
    //添加入库商品中间表-->
    int insertRkPro(RkProMp proMp);


    //根据仓库名称查询仓库ID
    int selectRkckId(String ckName);
    //根据仓库id，商品id查库存数量
    int selectRknumber(@Param("pro_id") int proId,@Param("ck_id") int ckId);
    //修改入库表的状态
    int updateRkstate(RkVo rkVo);
    //入库表，查询调拨类别的是否已经出库
    String selectRktype(int rkId);
    //查询该商品在该仓库是否有库存
    int selectproIdckId(@Param("pro_id") int proId,@Param("ck_id") int ckId);
    //添加商品库存（库存0）
    int insertproCk(ProCk proCk);

    int insertzsy(RkMp rkMp);

    int selectmaxid();
}
