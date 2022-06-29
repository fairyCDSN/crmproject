package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Category;
import com.trkj.crmproject.entity.mybatis_plus.Product;
import com.trkj.crmproject.entity.mybatis_plus.RkMp;
import com.trkj.crmproject.vo.ProductVo;
import com.trkj.crmproject.vo.RkVo;

import java.util.List;

public interface RkService {

    //入库表 查询入库表全部（连仓库，审批类别查）
    List<RkVo> selectRkall();
    //分页
    PageInfo<RkVo> findRk(int pageNum, int pageSize);


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
    //分页
    PageInfo<ProductVo> findRkpro(int rkId,int pageNum, int pageSize);


    //入库表 修改备注
    int updateRkbz(RkVo rkVo);

    //入库表 添加商品（查询商品的最大id）
    int selectPromax();

    //添加商品类别
    int insertRkcat(Category category);
    //添加商品类别
    int insertRkpro(Product product);

    //入库表，根据商品名称查商品
    ProductVo selectRkproname(String proName);
    // 添加入库表
    int insertRk(RkMp rkMp);


    //添加入库（修改库存表，修改入库表状态）
    int updateRkstate(RkVo rkVo);
    //入库表，查询调拨类别的是否已经出库
    String selectRktype(int rkId);

}
