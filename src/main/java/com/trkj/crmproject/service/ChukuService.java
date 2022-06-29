package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.ProCk;
import com.trkj.crmproject.vo.ChukuVo;
import com.trkj.crmproject.vo.ProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChukuService {
    //出库表，查询全部（连表查仓库名称，员工名称，审批类别名称）
    List<ChukuVo> selectChukuAll();
    //分页
    PageInfo<ChukuVo> findChuku(int pageNum, int pageSize);

    //出库表 根据仓库id查询全部
    List<ChukuVo> selectChukuckId(String ckName);
    //出库表 根据出库状态查询
    List<ChukuVo> selectChukustate(String state);
    //出库表 根据仓库Id 商品状态查询全部
    List<ChukuVo> selectChukuckstate(String ckName,String state);


    //出库表 根据出库id查询详情
    ChukuVo selectChukuIdxq(int chukuId);
    //出库表 根据出库id查询商品及出库数量
    //分页
    PageInfo<ProductVo> findChukupro(int chukuId, int pageNum, int pageSize);


    //出库表 修改备注
    int updateChukubz(ChukuVo chukuVo);

    //出库表 根据仓库id商品id查询库存
    List<ProCk> selectChukukc(String ckName);
    // 修改出库表的状态
    int updateChukustate(ChukuVo chukuVo);

    //出库 根据仓库名称跟商品名称查询库存信息（添加通知）
}
